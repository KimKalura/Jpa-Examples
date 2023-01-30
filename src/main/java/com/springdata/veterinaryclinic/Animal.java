package com.springdata.veterinaryclinic;

import javax.persistence.*;
import java.util.List;

@Entity
public class Animal {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @OneToOne
    @JoinColumn(name="owner_id")
    private Owner owner;

    @ManyToMany
    private List<Appointment> appointmentList;




    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
