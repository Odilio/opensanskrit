package br.com.sanscrito.sanscrito.application.services

import br.com.sanscrito.sanscrito.ports.input.SanscritoServicePort
import br.com.sanscrito.sanscrito.ports.output.SanscritoPersistencePort
import com.google.cloud.translate.Translate
import com.google.cloud.translate.TranslateOptions
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.stereotype.Service

@Service
class SanscritoService : SanscritoServicePort {

    @Autowired
    private lateinit var sanscritoAdapter: SanscritoPersistencePort


    @Autowired
    private lateinit var messageSource: MessageSource

    private val log = LoggerFactory.getLogger(javaClass)

    override fun transliterate(sanskrit: String): String {
        val result = StringBuilder()
        var i = 0
        while (i < sanskrit.length) {
            var clusterFound = false
            for ((key, value) in SanskritTransliterationMap.getClusterMap()) {
                if (sanskrit.startsWith(key, i)) {
                    result.append(value)
                    i += key.length
                    clusterFound = true
                    break
                }
            }
            if (!clusterFound) {
                val character = sanskrit[i].toString()
                // Se não houver mapeamento, adicione o caractere original.
                result.append(SanskritTransliterationMap.getMap().getOrDefault(character, character))
                i++
            }
        }
        return result.toString()
    }

    override fun translate(sanskrit: String): String {

        val translate =
            TranslateOptions.newBuilder().setApiKey("AIzaSyB4DiEdFoGf-86FhwsXS5hRRB17zgEkSdw").build().service

        //Translate translate = TranslateOptions.getDefaultInstance().getService();



        // Traduz para inglês (ou outra língua de sua escolha)

        val translation = translate.translate(
            sanskrit,
            Translate.TranslateOption.sourceLanguage("sa"),
            Translate.TranslateOption.targetLanguage("pt-br")
        )

        println("Original Text: $sanskrit")
        println("Translated Text: " + translation.translatedText)
        return translation.translatedText
    }


}
