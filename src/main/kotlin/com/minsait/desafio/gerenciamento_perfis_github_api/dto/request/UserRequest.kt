package com.minsait.desafio.gerenciamento_perfis_github_api.dto.request

data class UserRequest(
    val login: String,
    val url: String,
)