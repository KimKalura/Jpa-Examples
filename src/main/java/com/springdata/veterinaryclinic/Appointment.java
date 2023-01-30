package com.springdata.veterinaryclinic;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Appointment {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private LocalDate localDate;

    @ManyToOne
    private Doctor doctor;

    @ManyToMany
    private List<Animal> animalList;


    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
