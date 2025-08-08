package com.minsait.desafio.gerenciamento_perfis_github_api

import com.minsait.desafio.gerenciamento_perfis_github_api.config.security.JwtProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(JwtProperties::class)
class GerenciamentoPerfisGithubApiApplication

fun main(args: Array<String>) {
	runApplication<GerenciamentoPerfisGithubApiApplication>(*args)
}
