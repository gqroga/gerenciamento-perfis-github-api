package com.minsait.desafio.gerenciamento_perfis_github_api.controller

import com.minsait.desafio.gerenciamento_perfis_github_api.dto.AddRoleDTO
import com.minsait.desafio.gerenciamento_perfis_github_api.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus


@RestController
@RequestMapping("api/users")
class UserController (
    private val userService: UserService,
){

    @PostMapping("/role")
    @ResponseStatus(HttpStatus.OK)
    fun addRole(@RequestBody addRoleDTO: AddRoleDTO) =
        userService.addRole(addRoleDTO)

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findAllUsers() =
        userService.findAllUsers()
}