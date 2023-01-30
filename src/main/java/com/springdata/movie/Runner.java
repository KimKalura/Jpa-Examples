package com.springdata.movie;

import com.springdata.twitterapp.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class Runner implements CommandLineRunner {

    private MovieService movieService;
    private FranchiseService franchiseService;
    private CharacterService characterService;

    private MovieRepository movieRepository;
    private FranchiseRepository franchiseRepository;
    private CharacterRepository characterRepository;

    public Runner(@Autowired MovieService movieService,@Autowired FranchiseService franchiseService,@Autowired CharacterService characterService,@Autowired MovieRepository movieRepository,@Autowired FranchiseRepository franchiseRepository,@Autowired CharacterRepository characterRepository) {
        this.movieService = movieService;
        this.franchiseService = franchiseService;
        this.characterService = characterService;
        this.movieRepository = movieRepository;
        this.franchiseRepository = franchiseRepository;
        this.characterRepository = characterRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        Movie movie = new Movie();
//        movie.setName("movie1");
//        Movie savedMovie = movieRepository.save(movie);
//
//        Character character = new Character();
//        character.setName("character1");
//        movieService.addCharacterToMovie(savedMovie, character);


        // //Vad toate filmele dintr-o franciza
        Franchise franchise = franchiseRepository.findById(3L).get();
        System.out.println(movieRepository.findByFranchise(franchise));


        Movie movie = movieRepository.findById(1L).get();
        characterRepository.findAllByMoviesContaining(movie);


        //   franchiseService.addMovieToFranchise(franchise, movie); //**
        //  franchiseService.findByMovie(movie);//***
        /* movieService.findByCharacter(character);*/
    }
}
