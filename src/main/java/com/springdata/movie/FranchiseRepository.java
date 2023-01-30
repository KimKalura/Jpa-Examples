package com.springdata.movie;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranchiseRepository extends CrudRepository<Franchise, Long> {
    //public Franchise findByMoviesContaining(Movie movie);
}
