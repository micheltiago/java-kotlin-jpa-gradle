package com.example.forum.mapper

import com.example.forum.dto.TopicoDto
import com.example.forum.model.Topico
import com.example.forum.utils.Constants
import org.springframework.stereotype.Component

@Component
class TopicoMapper : Mapper<Topico, TopicoDto> {
    override fun mapToDto(t: Topico): TopicoDto {
        return TopicoDto(
            ind = t.id ,
            titulo = t.titulo,
            msg = t.mensagem
        )
    }

    override fun mapToModel(u: TopicoDto): Topico {
        return Topico(
            id = u.ind,
            mensagem = u.msg,
            titulo = u.titulo,
            autor = Constants.usuarioNull,
            curso = Constants.cursoNull
        )
    }
}