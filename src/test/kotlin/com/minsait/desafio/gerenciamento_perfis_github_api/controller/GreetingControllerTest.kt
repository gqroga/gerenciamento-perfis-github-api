package com.minsait.desafio.gerenciamento_perfis_github_api.controller

import com.minsait.desafio.gerenciamento_perfis_github_api.service.GreetingService
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(controllers = [GreetingController::class])
class GreetingControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var greetingService: GreetingService

    @Test
    fun `GET api greet returns message for provided name`() {
        given(greetingService.greet("Ana")).willReturn("Hello, Ana")

        mockMvc.perform(
            get("/api/greet")
                .param("name", "Ana")
                .accept(MediaType.TEXT_PLAIN)
        )
            .andExpect(status().isOk)
            .andExpect(content().string("Hello, Ana"))
    }

    @Test
    fun `GET api greet returns default message when name missing`() {
        given(greetingService.greet(null)).willReturn("Hello, GitHub Profiles API")

        mockMvc.perform(
            get("/api/greet")
                .accept(MediaType.TEXT_PLAIN)
        )
            .andExpect(status().isOk)
            .andExpect(content().string("Hello, GitHub Profiles API"))
    }
}