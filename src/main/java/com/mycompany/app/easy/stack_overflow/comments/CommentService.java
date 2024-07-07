package com.mycompany.app.easy.stack_overflow.comments;

public class CommentService {
    public void postComment(Comment comment, Commentable body) {
        body.addComment(comment);
    }
}
