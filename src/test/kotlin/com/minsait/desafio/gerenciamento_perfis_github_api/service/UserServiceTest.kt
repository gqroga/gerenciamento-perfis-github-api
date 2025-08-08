package com.minsait.desafio.gerenciamento_perfis_github_api.service

import com.minsait.desafio.gerenciamento_perfis_github_api.entity.Role
import com.minsait.desafio.gerenciamento_perfis_github_api.entity.User
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.assertNotNull

class UserServiceTest {

    @Test
    fun `deve criar uma instância de User com todos os atributos`() {
        
        val login = "johndoe"
        val url = "https://github.com/johndoe"
        val role = Role(name = "ADMIN")
        val roles = mutableSetOf(role)

        val user = User(
            id = 1,
            login = login,
            url = url,
            roles = roles
        )

        assertNotNull(user)
        assertEquals(1, user.id)
        assertEquals(login, user.login)
        assertEquals(url, user.url)
        assertEquals(1, user.roles.size)
        assertEquals("ADMIN", user.roles.first().name)
    }

    @Test
    fun `deve criar uma instância de User com id nulo e roles vazias`() {

        val login = "janedoe"
        val url = "https://github.com/janedoe"

        val user = User(
            login = login,
            url = url
        )

        assertNotNull(user)
        assertEquals(null, user.id)
        assertEquals(login, user.login)
        assertEquals(url, user.url)
        assertEquals(0, user.roles.size)
    }
}
