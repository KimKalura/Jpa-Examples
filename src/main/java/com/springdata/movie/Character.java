package com.springdata.movie;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "characters")
public class Character {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;

    @ManyToMany(mappedBy = "characters", cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private Set<Movie> movies;


    public Character(Long id, String name, Set<Movie> movies) {
        this.id = id;
        this.name = name;
        this.movies = movies;
    }

    public Character() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Movie> getMovies() {
        if (this.movies == null) {
            this.movies = new HashSet<>();
        }
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                //  ", movie=" + movies +
                '}';
    }
}
