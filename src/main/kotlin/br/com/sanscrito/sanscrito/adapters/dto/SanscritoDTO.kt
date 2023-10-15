package br.com.sanscrito.sanscrito.adapters.dto

import javax.validation.constraints.NotBlank

data class SanscritoDTO(
    var id: Long? = null,
    @NotBlank
    var nome: String? = null,
    @NotBlank
    var dataHoraUltimaAtualizacao: String? = null,
)
