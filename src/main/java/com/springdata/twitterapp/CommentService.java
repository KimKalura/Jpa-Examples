package com.springdata.twitterapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    private CommentRepository commentRepository;

    public CommentService(@Autowired CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }


    public List<Comment> findAllByTweet(Tweet tweet) {
        return commentRepository.findAllByTweet(tweet);
    }

    public List<Comment> findAllByUser(User user) {
//        List<Comment> result = new ArrayList<>();
//        List<Tweet> userTweets = user.getTweets();
//        for (Tweet tweet : userTweets) {
//            result.addAll(tweet.getComments());
//        }
//        return result;
        //return commentRepository.findAllByTweet_User(user);

        //*sau cu java8
        /*user.getTweets().stream()
                .flatMap(t->t.getComments().stream()).collect(Collectors.toList());*/



        //1. imi iau toate comentariile din DB
        //2. (in java) care sunt com care apartin unui anumit user
        List<Comment> comments = commentRepository.findAll();
        return comments.stream().filter(c->c.getTweet().getUser().getId() == user.getId()).collect(Collectors.toList());
    }

}
