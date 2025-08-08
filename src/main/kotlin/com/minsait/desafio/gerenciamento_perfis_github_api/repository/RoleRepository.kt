package com.minsait.desafio.gerenciamento_perfis_github_api.repository

import com.minsait.desafio.gerenciamento_perfis_github_api.entity.Role
import com.minsait.desafio.gerenciamento_perfis_github_api.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoleRepository : JpaRepository<Role, Long> {

    fun findByName(name: String) : Role?

}