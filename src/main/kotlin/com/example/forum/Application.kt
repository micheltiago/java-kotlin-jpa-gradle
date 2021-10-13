package com.example.forum

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@EnableCaching
@SpringBootApplication
class AluraKotlinGradleApplication

fun main(args: Array<String>) {
	runApplication<AluraKotlinGradleApplication>(*args)
}
