package br.com.sanscrito.sanscrito

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import java.io.File

@SpringBootApplication
class SeuProjetoApplication : CommandLineRunner {

    private val logger = LoggerFactory.getLogger(SeuProjetoApplication::class.java)

    override fun run(vararg args: String?) {
        val mantrasFolder = File("mantras")
        if (!mantrasFolder.exists() || !mantrasFolder.isDirectory) {
            logger.error("A pasta 'mantras' não foi encontrada!")
            return
        }

        mantrasFolder.listFiles { file -> file.extension == "txt" }?.forEach { file ->
            val content = file.readText(Charsets.UTF_8)
            logger.info("Conteúdo do arquivo ${file.name}:\n$content")
        }
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(SeuProjetoApplication::class.java, *args)
}
