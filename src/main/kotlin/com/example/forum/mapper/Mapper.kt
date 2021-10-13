package com.example.forum.mapper

interface Mapper<T, U> {

    fun mapToDto(t: T) : U
    fun mapToModel(u: U) : T
}
