package com.patlat.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class AllMovies {

    private static final List<Movie> movies = new ArrayList<>();
    private static long nextId = 1;

    private final AddMovieToList addMovieService;

    @Autowired
    public AllMovies(AddMovieToList addMovieService) {
        this.addMovieService = addMovieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        return movies.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        if (movie.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        movie.setId(nextId++);
        addMovieService.addMovie(movie);
        return ResponseEntity.ok(movie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(
            @PathVariable Long id,
            @RequestBody Movie movie
    ) {
        if (movie.getId() != null && !movie.getId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }

        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getId().equals(id)) {
                movie.setId(id);
                movies.set(i, movie);
                return ResponseEntity.ok(movie);
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        boolean removed = movies.removeIf(m -> m.getId().equals(id));
        if (removed) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
