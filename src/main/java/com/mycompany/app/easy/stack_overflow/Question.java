package com.mycompany.app.easy.stack_overflow;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.mycompany.app.easy.stack_overflow.comments.Comment;
import com.mycompany.app.easy.stack_overflow.comments.Commentable;

public class Question implements Commentable {
    private final String id;
    private final String owner;
    private final String question;
    private Map<String, Answer> answers;
    private Map<String, Comment> comments;
    private Map<String, Tag> tags;
    private Map<String, Vote> votes;

    public Question(String id, String question, String owner) {
        this.id = id;
        this.question = question;
        this.owner = owner;
        answers = new ConcurrentHashMap<String, Answer>();
        comments = new ConcurrentHashMap<String, Comment>();
        tags = new ConcurrentHashMap<String, Tag>();
        votes = new ConcurrentHashMap<String, Vote>();
    }

    public String getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getOwner() {
        return owner;
    }

    public Map<String, Answer> getAnswers() {
        return answers;
    }

    public Map<String, Comment> getComments() {
        return comments;
    }

    public Map<String, Tag> getTags() {
        return tags;
    }

    public Map<String, Vote> getVotes() {
        return votes;
    }

    @Override
    public void addComment(Comment comment) {
        comments.put(comment.getId(), comment);
    }
}
