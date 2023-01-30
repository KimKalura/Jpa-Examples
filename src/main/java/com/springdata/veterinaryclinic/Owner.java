package com.springdata.veterinaryclinic;

import javax.persistence.*;
import java.util.List;

@Entity
public class Owner {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @OneToOne(mappedBy = "owner", cascade = CascadeType.ALL)
    private Animal animal;



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


}
