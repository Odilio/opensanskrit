package br.com.sanscrito.sanscrito.application.services;

import java.util.HashMap;
import java.util.Map;

public class SanskritTransliterationMap {

    private static final Map<String, String> TRANSLITERATION_MAP;
    private static final Map<String, String> CLUSTER_MAP;

    static {
        TRANSLITERATION_MAP = new HashMap<>();
        // Vogais
        TRANSLITERATION_MAP.put("अ", "a");
        TRANSLITERATION_MAP.put("आ", "aa");
        TRANSLITERATION_MAP.put("इ", "i");
        TRANSLITERATION_MAP.put("ई", "ii");
        TRANSLITERATION_MAP.put("उ", "u");
        TRANSLITERATION_MAP.put("ऊ", "uu");
        TRANSLITERATION_MAP.put("ए", "e");
        TRANSLITERATION_MAP.put("ऐ", "ai");
        TRANSLITERATION_MAP.put("ओ", "o");
        TRANSLITERATION_MAP.put("औ", "au");
        TRANSLITERATION_MAP.put("ऋ", "ṛ");
        TRANSLITERATION_MAP.put("ॠ", "ṝ");

        // Algumas consoantes
        TRANSLITERATION_MAP.put("क", "ka");
        TRANSLITERATION_MAP.put("ख", "kha");
        TRANSLITERATION_MAP.put("ग", "ga");
        TRANSLITERATION_MAP.put("घ", "gha");
        TRANSLITERATION_MAP.put("ङ", "nga");
        TRANSLITERATION_MAP.put("च", "cha");
        TRANSLITERATION_MAP.put("छ", "chha");
        TRANSLITERATION_MAP.put("ज", "ja");
        TRANSLITERATION_MAP.put("झ", "jha");
        TRANSLITERATION_MAP.put("ञ", "nya");
        TRANSLITERATION_MAP.put("क", "ka");
        TRANSLITERATION_MAP.put("ख", "kha");
        TRANSLITERATION_MAP.put("ग", "ga");
        TRANSLITERATION_MAP.put("घ", "gha");
        TRANSLITERATION_MAP.put("ङ", "nga");

        TRANSLITERATION_MAP.put("च", "cha");
        TRANSLITERATION_MAP.put("छ", "chha");
        TRANSLITERATION_MAP.put("ज", "ja");
        TRANSLITERATION_MAP.put("झ", "jha");
        TRANSLITERATION_MAP.put("ञ", "nya");

        TRANSLITERATION_MAP.put("ट", "ṭa");
        TRANSLITERATION_MAP.put("ठ", "ṭha");
        TRANSLITERATION_MAP.put("ड", "ḍa");
        TRANSLITERATION_MAP.put("ढ", "ḍha");
        TRANSLITERATION_MAP.put("ण", "ṇa");

        TRANSLITERATION_MAP.put("त", "ta");
        TRANSLITERATION_MAP.put("थ", "tha");
        TRANSLITERATION_MAP.put("द", "da");
        TRANSLITERATION_MAP.put("ध", "dha");
        TRANSLITERATION_MAP.put("न", "na");

        TRANSLITERATION_MAP.put("प", "pa");
        TRANSLITERATION_MAP.put("फ", "pha");
        TRANSLITERATION_MAP.put("ब", "ba");
        TRANSLITERATION_MAP.put("भ", "bha");
        TRANSLITERATION_MAP.put("म", "ma");

        TRANSLITERATION_MAP.put("य", "ya");
        TRANSLITERATION_MAP.put("र", "ra");
        TRANSLITERATION_MAP.put("ल", "la");
        TRANSLITERATION_MAP.put("व", "va");

        TRANSLITERATION_MAP.put("श", "sha");
        TRANSLITERATION_MAP.put("ष", "ṣa");
        TRANSLITERATION_MAP.put("स", "sa");

        TRANSLITERATION_MAP.put("ह", "ha");

    // Alguns conjuntos adicionais (sibilantes e semivogais)
        TRANSLITERATION_MAP.put("ळ", "ḷa");
        TRANSLITERATION_MAP.put("क्ष", "kṣa");
        TRANSLITERATION_MAP.put("ज्ञ", "jña");
        // ... e assim por diante para outras consoantes.

        // Diacríticos (matras)
        TRANSLITERATION_MAP.put("ा", "aa");
        TRANSLITERATION_MAP.put("ि", "i");
        TRANSLITERATION_MAP.put("ी", "ii");
        TRANSLITERATION_MAP.put("ु", "u");
        TRANSLITERATION_MAP.put("ू", "uu");
        TRANSLITERATION_MAP.put("े", "e");
        TRANSLITERATION_MAP.put("ै", "ai");
        TRANSLITERATION_MAP.put("ो", "o");
        TRANSLITERATION_MAP.put("ौ", "au");
        TRANSLITERATION_MAP.put("ं", "m");
        TRANSLITERATION_MAP.put("ः", "h");
        TRANSLITERATION_MAP.put("ा", "aa");
        TRANSLITERATION_MAP.put("ि", "i");
        TRANSLITERATION_MAP.put("ी", "ii");
        TRANSLITERATION_MAP.put("ु", "u");
        TRANSLITERATION_MAP.put("ू", "uu");
        TRANSLITERATION_MAP.put("े", "e");
        TRANSLITERATION_MAP.put("ै", "ai");
        TRANSLITERATION_MAP.put("ो", "o");
        TRANSLITERATION_MAP.put("ौ", "au");
        TRANSLITERATION_MAP.put("ं", "ṁ");  // Anusvara
        TRANSLITERATION_MAP.put("ँ", "ṁ");  // Anusvara (outra forma)
        TRANSLITERATION_MAP.put("ः", "ḥ");  // Visarga
        TRANSLITERATION_MAP.put("्", "");   // Virama (indica a ausência de uma vogal após uma consoante)

// Sinais adicionais
        TRANSLITERATION_MAP.put("०", "0");
        TRANSLITERATION_MAP.put("१", "1");
        TRANSLITERATION_MAP.put("२", "2");
        TRANSLITERATION_MAP.put("३", "3");
        TRANSLITERATION_MAP.put("४", "4");
        TRANSLITERATION_MAP.put("५", "5");
        TRANSLITERATION_MAP.put("६", "6");
        TRANSLITERATION_MAP.put("७", "7");
        TRANSLITERATION_MAP.put("८", "8");
        TRANSLITERATION_MAP.put("९", "9");


        //telugo
        TRANSLITERATION_MAP.put("ॐ", "'Om");

        // ... e assim por diante para outros diacríticos.
    }

    static {
        CLUSTER_MAP = new HashMap<>();
        CLUSTER_MAP.put("क्ष", "kṣa");
        CLUSTER_MAP.put("ज्ञ", "jña");
        CLUSTER_MAP.put("त्र", "tra");
        CLUSTER_MAP.put("श्र", "śra");
        CLUSTER_MAP.put("द्र", "dra");
        CLUSTER_MAP.put("द्य", "dya");
        CLUSTER_MAP.put("स्य", "sya");
        CLUSTER_MAP.put("स्त", "sta");
        CLUSTER_MAP.put("स्थ", "stha");
        CLUSTER_MAP.put("स्व", "sva");
        CLUSTER_MAP.put("ह्म", "hma");
        CLUSTER_MAP.put("ह्य", "hya");
        CLUSTER_MAP.put("ह्र", "hra");
        CLUSTER_MAP.put("ह्ल", "hla");
        CLUSTER_MAP.put("प्र", "pra");
        CLUSTER_MAP.put("फ्र", "phra");
        CLUSTER_MAP.put("ब्र", "bra");
        CLUSTER_MAP.put("भ्र", "bhra");
        CLUSTER_MAP.put("म्र", "mra");
        CLUSTER_MAP.put("य्र", "yra");
        CLUSTER_MAP.put("ल्र", "lra");
        CLUSTER_MAP.put("व्र", "vra");
        CLUSTER_MAP.put("क्त", "kta");
        CLUSTER_MAP.put("ग्ध", "gdha");
        CLUSTER_MAP.put("ङ्क", "ṅka");
        CLUSTER_MAP.put("ङ्ख", "ṅkha");
        CLUSTER_MAP.put("च्च", "cca");
        CLUSTER_MAP.put("त्त", "tta");
        CLUSTER_MAP.put("त्थ", "ttha");
        CLUSTER_MAP.put("द्द", "dda");
        CLUSTER_MAP.put("द्ध", "ddha");
        CLUSTER_MAP.put("द्व", "dva");
        CLUSTER_MAP.put("न्त", "nta");
        CLUSTER_MAP.put("न्थ", "ntha");
        CLUSTER_MAP.put("न्द", "nda");
        CLUSTER_MAP.put("न्ध", "ndha");
        CLUSTER_MAP.put("प्त", "pta");
        CLUSTER_MAP.put("प्थ", "ptha");
        CLUSTER_MAP.put("म्न", "mna");
    }
    public static Map<String, String> getMap() {
        return TRANSLITERATION_MAP;
    }

    public static Map<String, String> getClusterMap() {
        return CLUSTER_MAP;
    }
}
