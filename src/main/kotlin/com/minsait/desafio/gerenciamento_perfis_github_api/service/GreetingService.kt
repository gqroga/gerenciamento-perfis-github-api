package com.minsait.desafio.gerenciamento_perfis_github_api.service

import org.springframework.stereotype.Service

@Service
class GreetingService {
    fun greet(name: String?): String {
        val trimmedName = name?.trim().orEmpty()
        return if (trimmedName.isBlank()) "Hello, GitHub Profiles API" else "Hello, $trimmedName"
    }
}