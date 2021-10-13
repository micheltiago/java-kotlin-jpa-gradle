package com.example.forum.service

import com.example.forum.exceptions.MinhaNotFoundException
import com.example.forum.model.Usuario
import com.example.forum.repository.UsuarioRepository
import com.example.forum.utils.Constants
import org.springframework.stereotype.Service

@Service
class UsuarioService(private val repository: UsuarioRepository) {

    fun listar(): List<Usuario> {
        return this.repository.findAll()
    }

    fun findById(id: Long): Usuario {
        return this.repository.findById(id)
            .orElseThrow { MinhaNotFoundException("Deu Ruim!") }
    }

    fun findByNome(nome: String): Usuario {
        return Constants.usuarios
            .stream()
            .filter { cur -> cur.nome == nome }
            .findFirst()
            .orElse(Constants.usuarioNull)
    }

}