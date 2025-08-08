package com.minsait.desafio.gerenciamento_perfis_github_api.service

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class GitHubSyncRunner (

    private val gitHubService: GitHubService,
    private val userService: UserService) : ApplicationRunner {


    override fun run(args: ApplicationArguments?) {
        val gitHubUsers = gitHubService.getGitHubUsers()

        userService.saveUsers(gitHubUsers)

    }

}
