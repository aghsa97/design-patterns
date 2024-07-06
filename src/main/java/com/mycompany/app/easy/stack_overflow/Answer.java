package com.mycompany.app.easy.stack_overflow;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.mycompany.app.easy.stack_overflow.comments.Comment;
import com.mycompany.app.easy.stack_overflow.comments.Commentable;

public class Answer implements Commentable {
    private final String id;
    private final String body;
    private final String owner;
    private final Question question;
    private Map<String, Comment> comments;
    private Map<String, Vote> votes;

    public Answer(String id, String answer, String owner, Question question) {
        this.id = id;
        this.body = answer;
        this.owner = owner;
        this.question = question;
        comments = new ConcurrentHashMap<String, Comment>();
        votes = new ConcurrentHashMap<String, Vote>();
    }

    public String getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public Question getQuestion() {
        return question;
    }

    public String getOwner() {
        return owner;
    }

    public Map<String, Comment> getComments() {
        return comments;
    }

    public Map<String, Vote> getVotes() {
        return votes;
    }

    @Override
    public void addComment(Comment comment) {
        comments.put(comment.getId(), comment);
    }
}
