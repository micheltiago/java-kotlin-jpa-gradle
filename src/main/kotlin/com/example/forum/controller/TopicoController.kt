package com.example.forum.controller

import com.example.forum.dto.AtualizacaoTopicoDto
import com.example.forum.dto.TopicoDto
import com.example.forum.dto.TopicoPorCategoriaDto
import com.example.forum.model.Topico
import com.example.forum.service.TopicoService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/topicos")
class TopicoController(
    private val service: TopicoService
) {

    @GetMapping
    @Cacheable("topicosCache")
    fun listar(@RequestParam(required = false) nome: String?,
               @PageableDefault(size = 5,sort = ["dataCriacao"], direction = Sort.Direction.DESC) pag: Pageable
    ): Page<TopicoDto> {
        return this.service.listar(nome, pag)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): Topico {
        return this.service.findById(id)
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = ["topicosCache"], allEntries = true)
    fun cadastrar(@RequestBody @Valid top: Topico, uriBuilder: UriComponentsBuilder): ResponseEntity<Topico> {
        this.service.cadastrar(top)
        val uri = uriBuilder.path("/topicos/${top.id}").build().toUri()
        return ResponseEntity.created(uri).body(top)
    }

    @PutMapping
    @Transactional
    @CacheEvict(value = ["topicosCache"], allEntries = true)
    fun atualizar(@RequestBody @Valid top: AtualizacaoTopicoDto): ResponseEntity<Topico> {
        return ResponseEntity.ok(this.service.atualizar(top))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    @CacheEvict(value = ["topicosCache"], allEntries = true)
    fun deleter(@PathVariable id: Long) {
        this.service.deletar(id)
    }


    @GetMapping("/relatorio")
    fun relatorio(): List<TopicoPorCategoriaDto>{
        return this.service.relatorio()
    }

}