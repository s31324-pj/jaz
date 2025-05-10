package com.patlat.MovieService;

import org.springframework.stereotype.Component;

public enum MovieGenre {
    ACTION("action"),
    COMEDY("comedy"),
    DRAMA("drama"),
    HORROR("horror"),
    SCIENCE_FICTION("science fiction"),
    FANTASY("fantasy"),
    THRILLER("thriller"),
    ROMANCE("romance"),
    ANIMATION("animation");


    private final String displayName;

    MovieGenre(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
