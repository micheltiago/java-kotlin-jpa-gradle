package com.example.forum.repository

import com.example.forum.dto.TopicoPorCategoriaDto
import com.example.forum.model.Topico
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicoRepository : JpaRepository<Topico, Long> {

    fun findByCursoNome(nome: String,page: Pageable): Page<Topico>

    @Query("SELECT new com.example.forum.dto.TopicoPorCategoriaDto(curso.categoria, count(t)) FROM Topico t JOIN t.curso curso GROUP BY curso.categoria ")
    fun relatorio(): List<TopicoPorCategoriaDto>

}