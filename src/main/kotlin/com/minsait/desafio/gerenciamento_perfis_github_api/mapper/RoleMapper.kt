package com.minsait.desafio.gerenciamento_perfis_github_api.mapper

import com.minsait.desafio.gerenciamento_perfis_github_api.entity.Role
import com.minsait.desafio.gerenciamento_perfis_github_api.dto.request.RoleRequest
import com.minsait.desafio.gerenciamento_perfis_github_api.dto.response.RoleResponse

object RoleMapper {

    fun toEntity(roleRequest: RoleRequest): Role {
        return Role(name = roleRequest.name)

    }

    fun toResponse(role: Role): RoleResponse {
        return RoleResponse(
            id = role.id,
            name = role.name
        )
    }
}