package me.ablax.mynotes.model.model;

import me.ablax.mynotes.entity.Blog;

/**
 * @author Murad Hamza on 27.05.2022 г.
 */
public class BlogResponse {
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public static BlogResponse fromBlog(final Blog blog){
        return new BlogResponse(blog.getId(),blog.getTitle(), blog.getAuthor(), blog.getBlogContent());
    }

    public BlogResponse(final Long id, final String title, final String username, final String blogContent) {
        this.id = id;
        this.title = title;
        this.username = username;
        this.blogContent = blogContent;
    }

    private Long id;
    private String title;
    private String username;
    private String blogContent;

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(final String blogContent) {
        this.blogContent = blogContent;
    }


    public BlogResponse() {
    }}
