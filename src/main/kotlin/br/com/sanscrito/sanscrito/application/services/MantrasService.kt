package br.com.sanscrito.sanscrito.application.services

import br.com.sanscrito.sanscrito.ports.input.MantrasServicePort
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.io.File

@Service
class MantrasService : MantrasServicePort {



    private val log = LoggerFactory.getLogger(javaClass)
    private val mantrasFolder = File("mantras")

    override fun retornaMantra(tituloMantra: String): String {
        val mantraFile = File(mantrasFolder, "$tituloMantra.txt")

        return if (mantraFile.exists()) {
            mantraFile.readText(Charsets.UTF_8)
        } else {
            ""
        }
    }

    override fun listarMantras(): List<String> {
        TODO("Not yet implemented")
    }




}
