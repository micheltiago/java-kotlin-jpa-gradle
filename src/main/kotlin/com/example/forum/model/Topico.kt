package com.example.forum.model

import com.example.forum.enum.StatusTopicoEnum
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
data class Topico(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @field:NotEmpty
    @field:Size( min = 5, max = 100, message = "Deve estar entre 5 e 100")
    val titulo: String,
    @field:NotEmpty(message="A mensagem não pode estar vazia")
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    @field:NotNull
    @ManyToOne
    val curso: Curso,
    @field:NotNull
    @ManyToOne
    val autor: Usuario,
    @Enumerated(value = EnumType.STRING)
    val status: StatusTopicoEnum = StatusTopicoEnum.NAO_RESPONDIDO,
    @OneToMany(mappedBy = "topico")
    val respostas: List<Resposta> = ArrayList()

)