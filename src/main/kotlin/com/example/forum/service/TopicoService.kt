package com.example.forum.service

import com.example.forum.dto.AtualizacaoTopicoDto
import com.example.forum.dto.TopicoDto
import com.example.forum.dto.TopicoPorCategoriaDto
import com.example.forum.exceptions.MinhaNotFoundException
import com.example.forum.mapper.TopicoMapper
import com.example.forum.model.Topico
import com.example.forum.repository.TopicoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private val mapper: TopicoMapper,
    private val repository: TopicoRepository
) {
    fun listar(nome: String?, pag: Pageable): Page<TopicoDto> {
        val topicos = if (nome == null) {
            return this.repository.findAll(pag).map { t -> mapper.mapToDto(t) }
        } else {
            return this.repository
                .findByCursoNome(nome, pag)
                .map { t -> this.mapper.mapToDto(t) }
        }
    }

    fun findById(id: Long): Topico {
        return this.repository.getById(id)
    }

    fun cadastrar(topico: Topico): Topico {
        return this.repository.save(topico)
    }

    fun atualizar(dto: AtualizacaoTopicoDto): Topico {
        val topico = this.repository
            .findAll()
            .stream()
            .filter { t -> t.id == dto.id }
            .findFirst()
            .orElseThrow { MinhaNotFoundException("DeU MErda") }

        val novoTopico = Topico(
            curso = topico.curso,
            autor = topico.autor,
            titulo = dto.titulo,
            mensagem = dto.msg,
            id = dto.id
        )

        return this.repository.save(novoTopico)
    }

    fun deletar(id: Long) {
        this.repository.deleteById(id)
    }

    fun relatorio(): List<TopicoPorCategoriaDto> {
        return this.repository.relatorio()
    }
}