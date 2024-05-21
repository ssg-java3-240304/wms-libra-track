package com.sh.model.dto.bookDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public enum Genre {

    Novel("소설"),
    Poem("시"),
    Literacture("문학");

    @Getter
    final String genreName;

    private static Map<String, Genre> genreLabel = new HashMap<>();

    static{
        for (Genre genre : values()) {
            genreLabel.put(genre.genreName, genre);
        }
    }

    public static Genre valueLabel(String name) {
        return genreLabel.get(name);
    }

}
