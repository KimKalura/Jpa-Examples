package com.springdata.twitterapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private TweetRepository tweetRepository;
    private UserRepository userRepository;

    public UserService(@Autowired TweetRepository tweetRepository, @Autowired UserRepository userRepository) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User addTweetToUser(Tweet tweet, User user){
        //fac leg in java (pas oprional), apoi sa persist legatura asta in baza de date
        tweet.setUser(user);
        user.getTweets().add(tweet);
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(User user){
         userRepository.delete(user);
    }

    public void removeTweetFromUser(Tweet tweet, User user) {
        user.getTweets().remove(tweet);// in Java
        tweetRepository.delete(tweet); //in DB
    }

    public void deleteAllTweetsFromUser(User user) {
        ///user.getTweets().clear();
        tweetRepository.deleteAll(user.getTweets());
    }
}
