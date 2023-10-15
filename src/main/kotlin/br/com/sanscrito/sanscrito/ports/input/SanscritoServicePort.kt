package br.com.sanscrito.sanscrito.ports.input

import br.com.sanscrito.sanscrito.adapters.mapper.SanscritoMapper
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface SanscritoServicePort {

    fun transliterate(sanskrit: String): String

    fun translate(sanskrit: String): String


}
