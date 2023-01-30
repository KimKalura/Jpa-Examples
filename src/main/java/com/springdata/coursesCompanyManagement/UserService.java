package com.springdata.coursesCompanyManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private TeamRepository teamRepository;
    private ModuleRepository moduleRepository;

    public UserService(@Autowired TeamRepository teamRepository, @Autowired ModuleRepository moduleRepository) {
        this.teamRepository = teamRepository;
        this.moduleRepository = moduleRepository;
    }

    public List<Module> findUserModules(User user) {
        Team team = user.getTeam();
        return team.getModuleList();
    }
}
