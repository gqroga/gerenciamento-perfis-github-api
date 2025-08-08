package com.minsait.desafio.gerenciamento_perfis_github_api.config.auth.controller

import com.minsait.desafio.gerenciamento_perfis_github_api.config.security.JwtUtil
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class AuthController (
    private val jwtUtil: JwtUtil
){

    @PostMapping("/login")
    fun login(@RequestBody request : LoginRequest ) : TokenResponse {

        val token = jwtUtil.generateToken(request.username)
         return TokenResponse(token)
    }

}

data class LoginRequest(val username: String)
data class TokenResponse(val token: String)