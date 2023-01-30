package com.springdata.veterinaryclinic;

import javax.persistence.*;
import java.util.List;

@Entity
public class Doctor {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @OneToMany
    private List<Appointment> appointmentList;




    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
