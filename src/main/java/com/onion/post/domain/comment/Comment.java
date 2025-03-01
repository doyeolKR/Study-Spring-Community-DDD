package com.onion.post.domain.comment;

import com.onion.common.domain.PositiveIntegerCounter;
import com.onion.post.domain.Post;
import com.onion.post.domain.content.CommentContent;
import com.onion.post.domain.content.Content;
import com.onion.user.domain.User;

public class Comment {

    private final Long id;
    private final Post post;
    private final User author;
    private final CommentContent content;
    private final PositiveIntegerCounter likeCount;

    public Comment(Long id, Post post, User author, CommentContent content) {

        if(post == null || author == null || content == null) {
            throw new IllegalArgumentException();
        }

        this.id = id;
        this.post = post;
        this.author = author;
        this.content = content;
        this.likeCount = new PositiveIntegerCounter();
    }

    public void like(User user) {
        if(this.author.equals(user)) {
            throw new IllegalArgumentException();
        }
        likeCount.increase();
    }

    public void unlike() {
        likeCount.decrease();
    }

    public void updateComment(User user, String updateContent) {
        if(!this.author.equals(user)) {
            throw new IllegalArgumentException();
        }
        this.content.updateContent(updateContent);
    }
}
