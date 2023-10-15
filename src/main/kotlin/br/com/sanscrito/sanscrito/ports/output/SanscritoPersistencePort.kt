package br.com.sanscrito.sanscrito.ports.output

import br.com.sanscrito.sanscrito.adapters.mapper.SanscritoMapper
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface SanscritoPersistencePort {

    fun findByIdOrNull(codigo: Long): SanscritoMapper?

    fun findAll(page: Pageable): Page<SanscritoMapper>

    fun findAllFields(search: String?, page: Pageable): Page<SanscritoMapper>

    fun save(boilerplate: SanscritoMapper): SanscritoMapper

    fun deleteById(id: Long)
}
