package br.com.sanscrito.sanscrito.adapters.mapper

import javax.validation.constraints.NotBlank

data class SanscritoMapper(
    var id: Long? = null,
    @NotBlank
    var nome: String? = null,
    @NotBlank
    var dataHoraUltimaAtualizacao: String? = null,
)
