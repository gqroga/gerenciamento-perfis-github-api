package com.minsait.desafio.gerenciamento_perfis_github_api.dto.response

import com.minsait.desafio.gerenciamento_perfis_github_api.entity.Role

data class UserResponse(
    val id: Long? = null,
    val login: String,
    val url: String,
    val roles: MutableSet<Role>
)