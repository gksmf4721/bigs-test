package org.example.bigsexternalapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = ["org.example.com.repository"])
@EntityScan(basePackages = ["org.example.com.domain.entity"])
@ComponentScan(basePackages = ["org.example.**.**"])
class BigsExternalApiApplication

fun main(args: Array<String>) {
    runApplication<BigsExternalApiApplication>(*args)
}
