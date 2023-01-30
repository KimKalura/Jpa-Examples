package com.springdata.coursesCompanyManagement;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Module> moduleList;
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<User> userList;

    private String name;

    public Team(String name) {
        this.name = name;
    }

    public Team() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Module> getModuleList() {
        return moduleList;
    }

    public void setModuleList(List<Module> moduleList) {
        this.moduleList = moduleList;
    }

    public List<User> getUserList() {
        if (this.userList == null) {
            this.userList = new ArrayList<>();
        }
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", moduleList=" + moduleList +
                ", userList=" + userList +
                ", name='" + name + '\'' +
                '}';
    }
}
