package br.com.sanscrito.sanscrito.application.services

import br.com.sanscrito.sanscrito.ports.input.EgipcioServicePort
import br.com.sanscrito.sanscrito.ports.input.SanscritoServicePort
import br.com.sanscrito.sanscrito.ports.output.SanscritoPersistencePort
import com.google.cloud.translate.Translate
import com.google.cloud.translate.TranslateOptions
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.stereotype.Service

@Service
class EgipcioService : EgipcioServicePort {



    private val log = LoggerFactory.getLogger(javaClass)

    override fun transliterate(sanskrit: String): String {
        return HieroglyphTransliterationMap.transcribe(sanskrit)

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
