package com.springdata.coursesCompanyManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TeamService {
    private UserRepository userRepository;
    private TeamRepository teamRepository;

    public TeamService(@Autowired UserRepository userRepository, @Autowired TeamRepository teamRepository) {
        this.userRepository = userRepository;
        this.teamRepository = teamRepository;
    }

    public Team addUserToTeam(Long userId, Long teamId) {
        Team team = teamRepository.findById(teamId).orElseThrow(() -> new IllegalArgumentException());
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException());
        team.getUserList().add(user);
        user.setTeam(team);
        return teamRepository.save(team);
    }

    public void removeUserFromTeam(User user, Team team){
        team.getUserList().remove(user);
        userRepository.delete(user);
    }

}
