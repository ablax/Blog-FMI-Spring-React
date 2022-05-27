package me.ablax.mynotes.service;


import me.ablax.mynotes.entity.Blog;
import me.ablax.mynotes.model.request.CreateBlog;

import java.util.List;

/**
 * @author Murad Hamza on 27.05.2022 г.
 */
public interface BlogService {
    List<Blog> getBlogs();

    Blog createBlog(final CreateBlog createBlog);

    Blog findById(final Long bookId);

    void deleteById(final Long bookId);
}
