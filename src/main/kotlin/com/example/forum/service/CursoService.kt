package com.example.forum.service

import com.example.forum.model.Curso
import com.example.forum.utils.Constants
import org.springframework.stereotype.Service

@Service
class CursoService {

    fun listar(): List<Curso> {
        return Constants.cursos
    }

    fun findById(id: Long): Curso {
        return Constants.cursos
            .stream()
            .filter { cur -> cur.id == id }
            .findFirst()
            .orElse(Constants.cursoNull)
    }

    fun findByNome(nome: String): Curso {
        return Constants.cursos
            .stream()
            .filter { cur -> cur.nome == nome }
            .findFirst()
            .orElse(Constants.cursoNull)
    }

}