package com.springdata.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private MovieRepository movieRepository;
    private FranchiseRepository franchiseRepository;

    public MovieService(@Autowired MovieRepository movieRepository, @Autowired FranchiseRepository franchiseRepository) {
        this.movieRepository = movieRepository;
        this.franchiseRepository = franchiseRepository;
    }

    public Movie addCharacterToMovie(Movie movie, Character character) {
        movie.getCharacters().add(character);
        character.getMovies().add(movie);
        return movieRepository.save(movie);
    }

    //Vad toate caracterele dintr-un film
//    public Movie findByCharacter(Character character) {
//        return movieRepository.findByCharacters(character);
//    }

}
