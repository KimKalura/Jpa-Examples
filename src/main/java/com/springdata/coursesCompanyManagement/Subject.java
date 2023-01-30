package com.springdata.coursesCompanyManagement;

import javax.persistence.*;

@Entity
public class Subject {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "title")
    private String name;

    @OneToOne
    @JoinColumn(name = "session_id")
    private Session session;


    public Subject(String name) {
        this.name = name;
    }

    public Subject() {}

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
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
