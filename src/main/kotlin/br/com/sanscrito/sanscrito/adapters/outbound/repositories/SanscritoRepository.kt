package br.com.sanscrito.sanscrito.adapters.outbound.repositories

import br.com.sanscrito.sanscrito.adapters.model.SanscritoModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface SanscritoRepository : JpaRepository<SanscritoModel, Long> {

    @Query(
        """
        SELECT u FROM SanscritoModel u WHERE
            CAST(u.id as text) like upper(CONCAT('%',:search,'%'))
            or upper(u.nome) like upper(CONCAT('%',:search,'%'))
            or to_char(u.dataHoraUltimaAtualizacao, 'dd/MM/yyyy') like CONCAT('%',:search,'%')
            or to_char(u.dataHoraUltimaAtualizacao, 'yyyy-MM-dd') like CONCAT('%',:search,'%')
            or to_char(u.dataHoraUltimaAtualizacao, 'dd/MM/yyyy HH:mm:ss') like CONCAT('%',:search,'%')
            or to_char(u.dataHoraUltimaAtualizacao, 'yyyy-MM-dd HH:mm:ss') like CONCAT('%',:search,'%')
    """
    )
    fun findAllFields(@Param("search") search: String?, page: Pageable?): Page<SanscritoModel>
}
