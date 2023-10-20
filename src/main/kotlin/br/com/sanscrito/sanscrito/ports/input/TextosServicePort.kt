package br.com.sanscrito.sanscrito.ports.input

import br.com.sanscrito.sanscrito.adapters.dto.MantraDTO
import br.com.sanscrito.sanscrito.adapters.mapper.SanscritoMapper
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface TextosServicePort {

    fun listarMantras(): List<String>

    fun retornaMantra(tituloMantra: String): MantraDTO


}
