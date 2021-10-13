package com.example.forum.utils

import com.example.forum.model.Curso
import com.example.forum.model.Topico
import com.example.forum.model.Usuario
import java.util.*

class Constants {

    companion object {

        private val curso1 = Curso(
            id = 22,
            nome = "Arquitetura Urbana",
            categoria = "Arquitetura"
        )

        private val curso2 = Curso(
            id = 23,
            nome = "Kotlin 2.0",
            categoria = "Programacao"
        )

        private val curso3 = Curso(
            id = 10,
            nome = "Kotlin 01",
            categoria = "Programacao"
        )

        val cursoNull = Curso(
            id = 0,
            nome = "",
            categoria = ""
        )

        private val usuario1 = Usuario(
            id = 1,
            nome = "Lucas Jung",
            email = "lucasjung@hotmail"
        )

        private val usuario2 = Usuario(
            id = 2,
            nome = "Tiago Michel",
            email = "tmichel@hotmail"
        )

        private val usuario3 = Usuario(
            id = 3,
            nome = "Natalia Jung de bona",
            email = "nati@hotmail"
        )

        val usuarioNull = Usuario(
            id = 0,
            nome = "",
            email = ""
        )

        private val topico1 = Topico(
            id = 1,
            titulo = "Dúvidas Kotlin",
            mensagem = "Variáveis no Kotlin",
            curso = curso3,
            autor = usuario1
        )

        private val topico2 = Topico(
            id = 2,
            titulo = "Certezas Kotlin plus",
            mensagem = "Variáveis mutáveis Kotlin",
            curso = curso2,
            autor = usuario2
        )

        private val topico3 = Topico(
            id = 3,
            titulo = "Dúvidas Arquitetura",
            mensagem = "Reboco da parede",
            curso = curso1,
            autor = usuario3
        )

        val topicoNull = Topico(
            id = 100,
            titulo = "",
            mensagem = "",
            curso = cursoNull,
            autor = usuarioNull
        )

        val cursos: List<Curso> = Arrays.asList(curso1, curso2, curso3)
        val usuarios: List<Usuario> = Arrays.asList(usuario1, usuario2, usuario3)
        var topicos: List<Topico> = Arrays.asList(topico1, topico2, topico3)

    }

}