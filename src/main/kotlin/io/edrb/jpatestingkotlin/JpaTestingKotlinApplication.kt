package io.edrb.jpatestingkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class JpaTestingKotlinApplication

fun main(args: Array<String>) {
    runApplication<JpaTestingKotlinApplication>(*args)
}
