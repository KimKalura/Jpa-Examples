package com.springdata.coursesCompanyManagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepository extends JpaRepository {
    public List<Module> findAllByTeam(Team team);
}
