package com.minsait.desafio.gerenciamento_perfis_github_api.config.security

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtAuthFilter(
    private val jwtUtil: JwtUtil
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val authHeader = request.getHeader("Authorization")

        if (authHeader.isNullOrBlank() || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response)
            return
        }

        val token = authHeader.removePrefix("Bearer ").trim()
        if (!jwtUtil.validadeToken(token)) {
            filterChain.doFilter(request, response)
            return
        }

        val username = jwtUtil.getUsername(token)
        val authentication = UsernamePasswordAuthenticationToken(username, null, emptyList())

        SecurityContextHolder.getContext().authentication = authentication
        filterChain.doFilter(request, response)
    }
}

