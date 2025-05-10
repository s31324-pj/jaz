package com.patlat.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddMovieToList {
    private final AllMovies allMovies;

    @Autowired
    public AddMovieToList(AllMovies allMovies) {
        this.allMovies = allMovies;
    }

    public void addMovie(Movie movie) {
        allMovies.addMovie(movie);
    }
}
