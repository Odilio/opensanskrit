package br.com.sanscrito.sanscrito.application.services

object HieroglyphTranslationMap {
    private val HIEROGLYPH_TO_TRANSCRIPTION = mutableMapOf(


        // Alguns hieroglifos adicionais
        "𓀁𓂋" to "ay",
        "𓀁𓏏" to "ay",
        "𓂋𓏾" to "mw",
        "𓅜𓏾" to "mm",
        "𓅓𓏾" to "nn",
        "𓇌𓏾" to "rr",
        "𓏾𓇋" to "mh",
        "𓏾𓏏" to "mn",
        "𓏾𓉐" to "mk",
        "𓏾𓏺" to "ms",
        "𓏾𓄫" to "mkh",
        "𓏯 𓏛𓏞 𓏛𓏞 𓏛𓏞 𓏛𓏞 𓏛𓏞" to "Rá",
        "𓏯 𓏏𓏞 𓏛𓏞 𓏛𓏞 𓏛𓏞 𓏛𓏞" to "O rei é vivo",
        "𓏛𓏞 𓏏𓏞 𓏛𓏞 𓏛𓏞 𓏛𓏞 𓏛𓏞" to "vida",
        "𓅱𓃀𓈖𓇳𓆑" to "Isis"

    )

    fun transcribe(hieroglyph: String): String {
        val result = StringBuilder()
        var i = 0
        while (i < hieroglyph.length) {
            val match = HIEROGLYPH_TO_TRANSCRIPTION.keys.find { key ->
                i + key.length <= hieroglyph.length && hieroglyph.substring(i, i + key.length) == key
            }

            if (match != null) {
                result.append(HIEROGLYPH_TO_TRANSCRIPTION[match]).append(" ")
                i += match.length
            } else {
                result.append("UNKNOWN ")
                i++
            }
        }
        return result.toString().trim()
    }

   /* @JvmStatic
    fun main(args: Array<String>) {
        val exampleGlyph = "𓁹𓎡 𓏞𓏜𓎡 𓅓 𓆓𓌃𓇋𓐩𓋇𓅨𓂋𓏏𓎟𓏞𓎟𓐪𓏧𓂢"
        println(transcribe(exampleGlyph))
    }*/
}
