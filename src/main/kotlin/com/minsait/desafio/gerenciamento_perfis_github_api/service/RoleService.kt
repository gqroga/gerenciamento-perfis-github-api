package com.minsait.desafio.gerenciamento_perfis_github_api.service

import com.minsait.desafio.gerenciamento_perfis_github_api.repository.RoleRepository
import com.minsait.desafio.gerenciamento_perfis_github_api.dto.request.RoleRequest
import com.minsait.desafio.gerenciamento_perfis_github_api.dto.response.RoleResponse
import com.minsait.desafio.gerenciamento_perfis_github_api.mapper.RoleMapper
import org.springframework.stereotype.Service

@Service
data class RoleService (
    private val roleRepository: RoleRepository,
) {

    fun createRole(roleRequest: RoleRequest) : RoleResponse {
        val existByName = roleRepository.findByName(roleRequest.name)

        if (existByName != null) {
        throw IllegalArgumentException("Already exists '$roleRequest.name'"  )

        }

        val role = RoleMapper.toEntity(roleRequest)

        roleRepository.save(role)
        return RoleMapper.toResponse(role)
    }
}
