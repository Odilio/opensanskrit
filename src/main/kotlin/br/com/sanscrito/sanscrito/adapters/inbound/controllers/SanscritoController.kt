package br.com.sanscrito.sanscrito.adapters.inbound.controllers

import br.com.sanscrito.sanscrito.adapters.converter.Converter
import br.com.sanscrito.sanscrito.adapters.dto.SanscritoDTO
import br.com.sanscrito.sanscrito.adapters.mapper.SanscritoMapper
import br.com.sanscrito.sanscrito.application.services.MantrasService
import br.com.sanscrito.sanscrito.ports.input.MantrasServicePort
import br.com.sanscrito.sanscrito.ports.input.SanscritoServicePort
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@Validated
@RestController
@CrossOrigin(origins = ["*"], maxAge = 3600)
@RequestMapping("/sanscrito")
class SanscritoController {

    private val log = LoggerFactory.getLogger(javaClass)

    @Autowired
    private lateinit var service: SanscritoServicePort

    @Autowired
    private lateinit var serviceMantrasService: MantrasServicePort

    @GetMapping(value = ["/v1/transcript"])
    fun transliterarSanscrito(@RequestParam(required = false) sanskrit: String?): String? {

        return sanskrit?.let { service.transliterate(it) }
    }


    @GetMapping(value = ["/v1/translate"])
    fun traduzirSanscrito(@RequestParam(required = false) sanskrit: String?): String? {

        return sanskrit?.let { service.translate(it) }
    }

    @GetMapping(value = ["/v1/mantra"])
    fun retornaMantra(@RequestParam(required = false) sanskrit: String?): String? {

        return sanskrit?.let { serviceMantrasService.retornaMantra(it) }
    }
}
