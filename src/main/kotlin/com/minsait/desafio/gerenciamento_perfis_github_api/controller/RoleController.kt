package com.minsait.desafio.gerenciamento_perfis_github_api.controller

import com.minsait.desafio.gerenciamento_perfis_github_api.dto.request.RoleRequest
import com.minsait.desafio.gerenciamento_perfis_github_api.service.RoleService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus


@RestController
@RequestMapping("api/roles")
class RoleController(
    private val roleService: RoleService,
) {

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun createRole (@RequestBody roleRequest: RoleRequest) =
        roleService.createRole(roleRequest)

}
