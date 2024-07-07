package com.mycompany.app.easy.stack_overflow;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, world!");

         StackOverflow stackOverflow = StackOverflow.getInstance();

        // Register users
        User user1 = new User("1", "john", "password123", 0);
        User user2 = new User("2", "jane", "password456", 0);
        stackOverflow.registerUser(user1);
        stackOverflow.registerUser(user2);

        // User login
        User loggedInUser = stackOverflow.loginUser("john", "password123");
        if (loggedInUser != null) {
            System.out.println("User logged in: " + loggedInUser.getUsername());
        } else {
            System.out.println("Invalid username or password.");
        }

        // Post a question
        Question question1 = new Question("1", "What is Java?", "1");
        stackOverflow.postQuestion(question1);

        // Post an answer
        Answer answer1 = new Answer("1", "Java is an object-oriented programming language.", "2", question1);
        stackOverflow.postAnswer(answer1);

        Vote vote1 = new Vote("1", "1");

        // Vote on the question
        stackOverflow.voteQuestion(question1, vote1);

        // Add tag to quesiton
        stackOverflow.addTagsToQuestion(question1, new Tag("1", "java"));

        // Search for questions
        List<Question> searchResults = stackOverflow.searchQuestions("Java");
        System.out.println("Search Results:");
        for (Question question : searchResults) {
            System.out.println(question.getQuestion());
        }

        // Get questions by tag
        List<Question> taggedQuestions = stackOverflow.getQuestionsByTag("java");
        System.out.println("Questions tagged with 'java':");
        for (Question question : taggedQuestions) {
            System.out.println(question.getQuestion());
        }

        // Get questions by user
        List<Question> userQuestions = stackOverflow.getQuestionsByUser(user1);
        System.out.println("Questions posted by user1:");
        for (Question question : userQuestions) {
            System.out.println(question.getQuestion());
        }
    }
    
}
