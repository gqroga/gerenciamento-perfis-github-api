package com.minsait.desafio.gerenciamento_perfis_github_api.controller

import com.minsait.desafio.gerenciamento_perfis_github_api.service.GreetingService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class GreetingController(
    private val greetingService: GreetingService
) {

    @GetMapping("/greet")
    fun greet(@RequestParam(required = false) name: String?): ResponseEntity<String> {
        val message = greetingService.greet(name)
        return ResponseEntity.ok(message)
    }
}