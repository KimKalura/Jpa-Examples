package com.springdata.coursesCompanyManagement;

import javax.persistence.*;
import java.util.List;

@Entity
public class Location {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "location")
    private String name;
//    private String street;
//    private String number;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Session> sessionList;


    public Location(String name) {
        this.name = name;
    }

    public Location() {}

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

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sessionList=" + sessionList +
                '}';
    }
}
