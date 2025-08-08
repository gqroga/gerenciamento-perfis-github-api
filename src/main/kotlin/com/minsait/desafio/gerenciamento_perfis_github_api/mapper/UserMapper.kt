package com.minsait.desafio.gerenciamento_perfis_github_api.mapper

import com.minsait.desafio.gerenciamento_perfis_github_api.dto.response.UserResponse
import com.minsait.desafio.gerenciamento_perfis_github_api.entity.User

object UserMapper {

    fun toResponse(user: User): UserResponse {
        return UserResponse(
            id = user.id,
            login = user.login,
            url = user.url,
            roles = user.roles
        )
    }

}