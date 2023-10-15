package br.com.sanscrito.sanscrito.adapters.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "sanscritos")
class SanscritoModel(

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "nome")
    var nome: String? = null,

    @Column(name = "data_hora_ultima_atualizacao")
    var dataHoraUltimaAtualizacao: LocalDateTime? = null
)
