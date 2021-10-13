package com.example.forum.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class AtualizacaoTopicoDto(
    @field:NotNull
    val id: Long,
    @field:NotEmpty
    val titulo: String,
    @field:NotEmpty
    val msg: String
)