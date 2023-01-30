package com.springdata.movie;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="movies")
public class Movie {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "franchise_id")
    private Franchise franchise;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "movie_character",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name ="character_id")
    )
    private Set<Character> characters;


    public Movie(long id, String name, Franchise franchise, Set<Character> characters) {
        this.id = id;
        this.name = name;
        this.franchise = franchise;
        this.characters = characters;
    }

    public Movie() {}

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

    public Franchise getFranchise() {
        return franchise;
    }

    public void setFranchise(Franchise franchise) {
        this.franchise = franchise;
    }

    public Set<Character> getCharacters() {
        if(this.characters == null) {
            this.characters = new HashSet<>();
        }
        return characters;
    }

    public void setCharacters(Set<Character> characters) {
        this.characters = characters;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", franchise=" + franchise +

                '}';
    }
}
