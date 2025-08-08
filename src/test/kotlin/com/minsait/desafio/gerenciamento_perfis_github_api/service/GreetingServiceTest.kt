package com.minsait.desafio.gerenciamento_perfis_github_api.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GreetingServiceTest {

    private val service = GreetingService()

    @Test
    fun `returns default greeting when name is null`() {
        val result = service.greet(null)
        assertEquals("Hello, GitHub Profiles API", result)
    }

    @Test
    fun `returns default greeting when name is blank`() {
        val result = service.greet("   ")
        assertEquals("Hello, GitHub Profiles API", result)
    }

    @Test
    fun `returns personalized greeting when name is provided`() {
        val result = service.greet("Ana")
        assertEquals("Hello, Ana", result)
    }
}