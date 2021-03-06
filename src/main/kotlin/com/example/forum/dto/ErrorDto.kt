package com.example.forum.dto

import java.time.LocalDateTime

data class ErrorDto (
    val timestemp: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val error: String,
    val message: String?,
    val path: String
)
