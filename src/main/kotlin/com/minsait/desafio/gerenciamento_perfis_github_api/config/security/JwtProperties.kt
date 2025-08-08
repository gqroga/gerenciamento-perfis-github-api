package com.minsait.desafio.gerenciamento_perfis_github_api.config.security

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component


@Component
@ConfigurationProperties(prefix = "jwt")
class JwtProperties {

    lateinit var secret : String
    var expiration : Long = 3600000

}