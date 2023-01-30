package com.springdata.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FranchiseService {

    private FranchiseRepository franchiseRepository;
    private CharacterRepository characterRepository;
    private MovieRepository movieRepository;

    public FranchiseService(@Autowired FranchiseRepository franchiseRepository, @Autowired CharacterRepository characterRepository, @Autowired MovieRepository movieRepository) {
        this.franchiseRepository = franchiseRepository;
        this.characterRepository=characterRepository;
        this.movieRepository=movieRepository;
    }


    //adaug un film intr-o franciza.
//    public Franchise addMovieToFranchise(Franchise franchise, Movie movie) {
//        movie.setFranchise(franchise);
//        franchise.getMovies().add(movie);
//        return franchiseRepository.save(franchise);
//    }


    //Vad toate filmele dintr-o franciza **vezi movie Rep
//    public Franchise findByMovie(Movie movie) {
//        return franchiseRepository.findByMovie(movie);
//    }

}
