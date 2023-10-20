package br.com.sanscrito.sanscrito.application.services

import br.com.sanscrito.sanscrito.adapters.dto.MantraDTO
import br.com.sanscrito.sanscrito.ports.input.MantrasServicePort
import br.com.sanscrito.sanscrito.ports.input.TextosServicePort
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.io.File

@Service
class TextosService : TextosServicePort {



    private val log = LoggerFactory.getLogger(javaClass)
    private val mantrasFolder = File("egipciotextos")

    override fun retornaMantra(tituloMantra: String): MantraDTO {
        log.info("Método retornaMantra chamado com o título: $tituloMantra")

        val mantraFile = File(mantrasFolder, "$tituloMantra.txt")
        log.info("Tentando ler o arquivo em: ${mantraFile.absolutePath}")

        return if (mantraFile.exists()) {
            log.info("Arquivo encontrado!")
            val content = mantraFile.readText(Charsets.UTF_8)
            val spotifyUrl = MantraSpotfyMap.getMap()[tituloMantra] ?: ""
            MantraDTO(content,spotifyUrl)

        } else {
            log.warn("Arquivo não encontrado!")
            MantraDTO("","")
        }
    }

    override fun listarMantras(): List<String> {
        TODO("Not yet implemented")
    }




}
