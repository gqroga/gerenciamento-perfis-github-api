package com.minsait.desafio.gerenciamento_perfis_github_api.repository

import com.minsait.desafio.gerenciamento_perfis_github_api.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
}