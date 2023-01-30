package com.springdata.movie;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="franchises")
public class Franchise {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;


    @OneToMany(mappedBy = "franchise", cascade = CascadeType.ALL)
    Set<Movie> movies;


    public Franchise(Long id, String name, Set<Movie> movies) {
        this.id = id;
        this.name = name;
        this.movies = movies;
    }

    public Franchise() {}

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
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Franchise{" +
                "id=" + id +
                ", name='" + name + '\'' +
               // ", movies=" + movies +
                '}';
    }
}
