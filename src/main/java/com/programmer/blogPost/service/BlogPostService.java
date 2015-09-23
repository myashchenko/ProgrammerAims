package com.programmer.blogPost.service;

import com.programmer.blogPost.BlogPost;

/**
 * Created by kolyan on 9/23/15.
 */
public interface BlogPostService {

    void create(BlogPost blogPost);

    BlogPost read(Long id);

    BlogPost update(BlogPost blogPost);

    void delete(BlogPost blogPost);

    BlogPost getByBlogAndPostIds(Long blogId, Long postId);

}
