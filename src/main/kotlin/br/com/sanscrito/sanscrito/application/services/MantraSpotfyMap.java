package br.com.sanscrito.sanscrito.application.services;

import java.util.HashMap;
import java.util.Map;

public class MantraSpotfyMap {

    private static final Map<String, String> SPOTIFY_MAP;

    static {
        SPOTIFY_MAP = new HashMap<>();
        // Vogais
        SPOTIFY_MAP.put("shiva", "https://open.spotify.com/embed/track/4wjxjAA5129A7WezAfEi1B?utm_source=generator");
        SPOTIFY_MAP.put("ganesh", "https://open.spotify.com/embed/track/2tmlXgWnsyNMWrZi4a3K4T?utm_source=generator");
        SPOTIFY_MAP.put("durga", "https://open.spotify.com/embed/track/3Q3yWd2A6XO0tySc8MNpko?utm_source=generator");
        SPOTIFY_MAP.put("gayatri", "https://open.spotify.com/embed/track/1kYeYUOjvEX9Vg3Tb8VIHR?utm_source=generator");


    }


    public static Map<String, String> getMap() {
        return SPOTIFY_MAP;
    }
}
