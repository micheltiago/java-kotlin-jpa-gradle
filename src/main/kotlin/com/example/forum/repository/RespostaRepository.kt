package com.example.forum.repository

import com.example.forum.model.Resposta
import org.springframework.data.jpa.repository.JpaRepository

interface RespostaRepository : JpaRepository<Resposta, Long> {
}