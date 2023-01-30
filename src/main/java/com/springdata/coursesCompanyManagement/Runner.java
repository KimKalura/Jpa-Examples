package com.springdata.coursesCompanyManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    private UserRepository userRepository;
    private TeamRepository teamRepository;
    private TeamService teamService;

    @Autowired
    private UserService userService;

    public Runner(@Autowired UserRepository userRepository, @Autowired TeamRepository teamRepository , @Autowired TeamService teamService) {
        this.userRepository = userRepository;
        this.teamRepository = teamRepository;
        this.teamService = teamService;
    }

    @Override
    public void run(String... args) throws Exception {
//        User user1 = new User("Kim K", "54z478d", "Ariela","Lewy", "lariela@yahoo.com", UserType.TRAINER);
//        User user2 = new User("Yuri K", "56qwa54", "Yuri", "Lee", "yuri@yahoo.com", UserType.STUDENT);
//        User user3 = new User("ARM", "xyg54lpp", "Amram", "Moshe", "amrammoshe@yahoo.com", UserType.ADMIN);
//        User user4 = new User("natan", "52kjzzz", "Efrayim", "Natan", "efrayim@yahoo.com", UserType.STUDENT);
//
//        User savedUser = userRepository.save(user1);
//        userRepository.save(user2);
//        userRepository.save(user3);
//        userRepository.save(user4);
//
//        Team team1 = new Team("Beginner");
//        Team team2 = new Team("Advanced");
//        Team team3 = new Team("Intermediate");
//        Team savedTeam = teamRepository.save(team1);
//        teamRepository.save(team2);
//        teamRepository.save(team3);

        /*System.out.println(teamService.addUserToTeam(1L,6L));
        teamService.removeUserFromTeam(savedUser,savedTeam);*/


        User user = userRepository.findById(2L).get();
        userService.findUserModules(user);

    }
}