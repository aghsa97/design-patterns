package com.mycompany.app.easy.stack_overflow;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import com.mycompany.app.easy.stack_overflow.comments.Comment;
import com.mycompany.app.easy.stack_overflow.comments.CommentService;

public class StackOverflow {
    private static StackOverflow instance;
    private final Map<String, User> users;
    private final Map<String, Question> questions;
    private final Map<String, List<Question>> taggedQuestions;
    private final CommentService commentService;

    private StackOverflow() {
        users = new ConcurrentHashMap<String, User>();
        questions = new ConcurrentHashMap<String, Question>();
        taggedQuestions = new ConcurrentHashMap<String, List<Question>>();
        commentService = new CommentService();
    }

    public static synchronized StackOverflow getInstance() {
        if (instance == null) {
            instance = new StackOverflow();
        }
        return instance;
    }

     public Map<String, User> getUsers() {
        return users;
    }

    public Map<String, Question> getQuestions() {
        return questions;
    }

    public Map<String, List<Question>> getTaggedQuestions() {
        return taggedQuestions;
    }
    
    public void registerUser(User user) {
        users.put(user.getId(), user);
    }

    public User loginUser (String username, String password) {
        for (User user : users.values()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password) && user.isLoggedin() == false) {
                user.setLoggedin(true);;
                return user;
            }
        }
        return null;
    }

    public void postQuestion(Question question) {
        questions.put(question.getId(), question);
        for (Tag tag: question.getTags().values()) {
            taggedQuestions.computeIfAbsent(tag.getTag(), k -> new ArrayList<Question>()).add(question);
        }
    }

    public void addTagsToQuestion(Question question, Tag tag) {
        question.getTags().put(tag.getId(), tag);
        taggedQuestions.computeIfAbsent(tag.getTag(), k -> new ArrayList<Question>()).add(question);
    }

    public void postAnswer(Answer answer) {
        Question question = answer.getQuestion();
        question.getAnswers().put(answer.getId(), answer);
    }

    public void postCommentToQuestion(Comment comment, Question question) {
        commentService.postComment(comment, question);
    }

    public void postCommentToAnswer(Comment comment, Answer answer) {
        commentService.postComment(comment, answer);
    }

    public void voteQuestion(Question question, Vote vote) {
        synchronized (question) {
            question.getVotes().put(vote.getId(), vote);
        }
    }

    public void voteAnswer(Answer answer, Vote vote) {
        synchronized (answer) {
            answer.getVotes().put(vote.getId(), vote);
        }
    }

    public void updateUserReputation(User user, int value) {
        synchronized (user) {
            user.setReputation(user.getReputation() + value);
        }
    }

    public List<Question> searchQuestions(String keyword) {
        List<Question> result = new ArrayList<Question>();
        for (Question question : questions.values()) {
            if (question.getQuestion().contains(keyword)) {
                result.add(question);
            }
        }
        return result;
    }

    public List<Question> getQuestionsByTag(String tagName) {
        return taggedQuestions.getOrDefault(tagName, new ArrayList<>());
    }

     public List<Question> getQuestionsByUser(User user) {
        List<Question> results = new ArrayList<Question>();
        for (Question question : questions.values()) {
            if (question.getOwner().equals(user.getId())) {
                results.add(question);
            }
        }
        return results;
    }

}
