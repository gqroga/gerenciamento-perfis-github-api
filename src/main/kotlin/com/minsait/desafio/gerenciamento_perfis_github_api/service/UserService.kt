package com.minsait.desafio.gerenciamento_perfis_github_api.service

import com.minsait.desafio.gerenciamento_perfis_github_api.dto.AddRoleDTO
import com.minsait.desafio.gerenciamento_perfis_github_api.dto.GitHubUserDTO
import com.minsait.desafio.gerenciamento_perfis_github_api.dto.response.UserResponse
import com.minsait.desafio.gerenciamento_perfis_github_api.entity.User
import com.minsait.desafio.gerenciamento_perfis_github_api.mapper.UserMapper
import com.minsait.desafio.gerenciamento_perfis_github_api.repository.RoleRepository
import com.minsait.desafio.gerenciamento_perfis_github_api.repository.UserRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service
import java.rmi.server.ObjID

@Service
class UserService(

    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository){

    fun saveUsers(gitHubUsers: List<GitHubUserDTO>?) {
        gitHubUsers?.forEach { user -> val newUser = User(
            login = user.login,
            url = user.url)

            userRepository.save(newUser)
        }
    }

    fun addRole(addRoleDTO: AddRoleDTO) : UserResponse {
        val user = userRepository.findById(addRoleDTO.userID)
            .orElseThrow{ (EntityNotFoundException("User not Found")) }

        val role = roleRepository.findById(addRoleDTO.roleID)
        .orElseThrow{ (EntityNotFoundException("Role not found"))}

        user.roles.add(role)
        userRepository.save(user)
        return UserMapper.toResponse(user)
    }

    fun findAllUsers() : List<UserResponse> {
        val userList = userRepository.findAll().stream().map {
            user ->
            UserMapper.toResponse(user)
        }.toList()

        return userList

    }
}