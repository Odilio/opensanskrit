package br.com.sanscrito.sanscrito.adapters.outbound

import br.com.sanscrito.sanscrito.adapters.converter.Converter
import br.com.sanscrito.sanscrito.adapters.model.SanscritoModel
import br.com.sanscrito.sanscrito.adapters.outbound.repositories.SanscritoRepository
import br.com.sanscrito.sanscrito.adapters.mapper.SanscritoMapper
import br.com.sanscrito.sanscrito.ports.output.SanscritoPersistencePort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class SanscritoPersistenceAdapter : SanscritoPersistencePort {

    @Autowired
    private lateinit var sanscritoRepository: SanscritoRepository

    override fun findByIdOrNull(codigo: Long) = sanscritoRepository.findByIdOrNull(codigo)?.let {
        Converter.toModel(it, SanscritoMapper::class.java)
    }

    override fun findAll( page: Pageable) =
        sanscritoRepository.findAll(page)
            .map { Converter.toModel(it, SanscritoMapper::class.java) }

    override fun findAllFields(search: String?, page: Pageable) =
        sanscritoRepository.findAllFields(search, page).map { Converter.toModel(it, SanscritoMapper::class.java) }

    override fun save(Sanscrito: SanscritoMapper): SanscritoMapper {
        val SanscritoModel = Converter.toModel(Sanscrito, SanscritoModel::class.java)
        SanscritoModel.dataHoraUltimaAtualizacao = LocalDateTime.now()
        return Converter.toModel(sanscritoRepository.save(SanscritoModel), SanscritoMapper::class.java)
    }

    override fun deleteById(id: Long) = sanscritoRepository.deleteById(id)

}
