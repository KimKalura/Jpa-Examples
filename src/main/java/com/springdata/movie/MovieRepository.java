package com.springdata.movie;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
    public List<Movie> findByFranchise(Franchise franchise);

   // Movie findByCharacters(Character character);

}
