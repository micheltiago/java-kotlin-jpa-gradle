package com.example.forum.dto

import javax.validation.constraints.NotEmpty

data class TopicoDto(
    @NotEmpty val ind : Long? = null,
    @NotEmpty val titulo: String,
    val msg : String,
)