package com.minsait.desafio.gerenciamento_perfis_github_api.service

import com.minsait.desafio.gerenciamento_perfis_github_api.dto.GitHubUserDTO
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class GitHubService {

    private val restTemplate = RestTemplate()
    private val apiUrl = "https://api.github.com/users"

    @Value("\${github.api.users}")
    fun getGitHubUsers() : List<GitHubUserDTO>? {
        val responseType = object : ParameterizedTypeReference<List<GitHubUserDTO>> () {}

        val response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, responseType)

        return response.body
    }
}