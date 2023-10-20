package br.com.sanscrito.sanscrito.application.services

object HieroglyphTransliterationMap {
    private val HIEROGLYPH_TO_TRANSCRIPTION = mutableMapOf(
        "𓀀" to "A",
        "𓃀" to "b",
        "𓁁" to "y",
        "𓂋" to "w",
        "𓎡" to "w",
        "𓄂" to "p",
        "𓅃" to "f",
        "𓅜" to "m",
        "𓅓" to "n",
        "𓇌" to "r",
        "𓁹" to "r",
        "𓏯" to "r",
        "𓇋" to "h",
        "𓏭" to "H",
        "𓈖" to "s",
        "𓋴" to "S",
        "𓍯" to "k",
        "𓎛" to "q",
        "𓀃" to "b",
        "𓁛" to "u",
        "𓂝" to "o",
        "𓃋" to "p",
        "𓄃" to "d",
        "𓅂" to "k",
        "𓅛" to "t",
        "𓆃" to "d",
        "𓆑" to "f",
        "𓆓" to "r",
        "𓇃" to "m",
        "𓇋" to "h",
        "𓊃" to "s",
        "𓏜" to "i",
        "𓅓" to "e",
        "𓆓" to "r",
        "𓌃" to "m",
        "𓇋" to "h",
        "𓐩" to "p",
        "𓋇" to "r",
        "𓅨" to "k",
        "𓂋" to "a",
        "𓏏" to "n",
        "𓆎" to "nefer",
        "𓏤" to "netjer",
        "𓈒" to "...",
        "𓏌" to "ba",
        "𓉐" to "ankh",
        "𓂋𓏏" to "djet",
        "𓂻" to "maat",
        "𓅓𓉔" to "ka",
        "𓅱𓇳" to "mer",
        "𓁏" to "i",
        "𓏞" to "i",
        "𓁄" to "d",
        "𓇎" to "t",
        "𓋍" to "g",
        "𓏏" to "n",
        "𓏾" to "m",
        "𓃿" to "h",
        "𓊃" to "s",
        "𓏺" to "sh",
        "𓄫" to "kh",
        "𓂧" to "gh",
        "𓉟" to "tj",
        "𓋷" to "dj",

        // Alguns hieroglifos compostos
        "𓊃𓏺" to "st",
        "𓋷𓏺" to "dj",
        "𓅓𓏺" to "sw",
        "𓏺𓄫" to "kh",
        "𓏺𓂧" to "gh",
        "𓏺𓉟" to "tj",

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
        "𓏾𓂧" to "mgh",
        "𓏾𓉟" to "mtj"

    )

    private val CLUSTER_HIEROGLYPH = mutableMapOf(
        "𓏛𓏞" to "i",
        "𓏏𓁹" to "nr",  // n-r
        "𓂧𓅓" to "ghn", // gh-n
        "𓏏𓏭" to "nh",  // n-h
        "𓇋𓂧" to "hgh", // h-gh
        "𓂧𓎛" to "ghq", // gh-q
        "𓎡𓃀" to "bw",  // b-w
        "𓏞𓂝" to "ou",  // o-u
        "𓇋𓏌" to "hb",  // h-b
        "𓂝𓇋" to "oh",  // o-h
        "𓇋𓎡" to "hw",  // h-w
        "𓎡𓁛" to "wu",  // w-u
        "𓇋𓈖" to "hs",  // h-s
        "𓅜𓁛" to "mu",  // m-u
        "𓇌𓂧" to "rgh", // r-gh
        "𓅓𓈖" to "ns",  // n-s
        "𓅨𓈖" to "ks",  // k-s
        "𓏏𓊃" to "ns",  // n-s
        "𓅱𓉔" to "mrk", // m-r-k
        "𓊖𓉔" to "tp",  // t-p
        "𓇋𓍯" to "hk",  // h-k
        "𓏏𓏞𓏛𓏞" to "ri",
        "𓏏𓁹𓏛𓏞" to "nr-i",
        "𓂧𓅓𓏛𓏞" to "ghn-i",
        "𓏏𓏭𓏛𓏞" to "nh-i",
        "𓇋𓂧𓏛𓏞" to "hgh-i",
        "𓂧𓎛𓏛𓏞" to "ghq-i",
        "𓎡𓃀𓏛𓏞" to "bw-i",
        "𓏞𓂝𓏛𓏞" to "ou-i",
        "𓇋𓏌𓏛𓏞" to "hb-i",
        "𓂝𓇋𓏛𓏞" to "oh-i",
        "𓇋𓎡𓏛𓏞" to "hw-i",
        "𓎡𓁛𓏛𓏞" to "wu-i",
        "𓇋𓈖𓏛𓏞" to "hs-i",
        "𓅜𓁛𓏛𓏞" to "mu-i",
        "𓇌𓂧𓏛𓏞" to "rgh-i",
        "𓅓𓈖𓏛𓏞" to "ns-i",
        "𓅨𓈖𓏛𓏞" to "ks-i",
        "𓏏𓊃𓏛𓏞" to "ns-i",
        "𓅱𓉔𓏛𓏞" to "mrk-i",
        "𓊖𓉔𓏛𓏞" to "tp-i",
        "𓇋𓍯𓏛𓏞" to "hk-i",
        "𓏯 𓏛𓏞 𓏛𓏞 𓏛𓏞 𓏛𓏞 𓏛𓏞" to "Rá",   // h-k
        "𓅱𓃀𓈖𓇳𓆑" to "Isis",
        "𓏯 𓏏𓏞 𓏛𓏞 𓏛𓏞 𓏛𓏞 𓏛𓏞" to "ra-i-i",
        "𓏛𓏞 𓏏𓏞 𓏛𓏞 𓏛𓏞 𓏛𓏞 𓏛𓏞" to "ankh"
    )

    fun transcribe(hieroglyph: String): String {
        val result = StringBuilder()
        var i = 0

        while (i < hieroglyph.length) {
            // Primeiro, tenta encontrar o cluster mais longo que corresponde
            val clusterMatches = CLUSTER_HIEROGLYPH.keys.filter { key ->
                i + key.length <= hieroglyph.length && hieroglyph.substring(i, i + key.length) == key
            }.sortedByDescending { it.length }

            if (clusterMatches.isNotEmpty()) {
                val longestMatch = clusterMatches.first()
                result.append(CLUSTER_HIEROGLYPH[longestMatch]).append(" ")
                i += longestMatch.length
                continue
            }

            // Caso não encontre em clusters, busca nos hieróglifos individuais
            val singleMatch = HIEROGLYPH_TO_TRANSCRIPTION.keys.find { key ->
                i + key.length <= hieroglyph.length && hieroglyph.substring(i, i + key.length) == key
            }

            if (singleMatch != null) {
                result.append(HIEROGLYPH_TO_TRANSCRIPTION[singleMatch]).append(" ")
                i += singleMatch.length
            } else {
                result.append("UNKNOWN ")
                i++
            }
        }
        return result.toString().trim()
    }


}
