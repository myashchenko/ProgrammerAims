package com.programmer.blogPost;

import com.programmer.blog.Blog;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by kolyan on 9/23/15.
 */
@Entity
@Table(name = "blog_post")
public class BlogPost {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "id")
    private Long id;

    @Column(name = "post_name")
    @NotNull
    private String postName;

    @Column(name = "text")
    @NotNull
    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
