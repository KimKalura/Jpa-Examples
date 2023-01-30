package com.springdata.veterinaryclinic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Specialization {

    @Id
    @GeneratedValue
    private Long id;


    @ManyToOne
    private Doctor doctor;

}
