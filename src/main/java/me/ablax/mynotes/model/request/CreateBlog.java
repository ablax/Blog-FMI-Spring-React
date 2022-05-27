package me.ablax.mynotes.model.request;

import javax.validation.constraints.NotNull;

/**
 * @author Murad Hamza on 27.05.2022 г.
 */
public class CreateBlog {

    @NotNull
    private String title;
    @NotNull
    private String username;
    @NotNull
    private String blogContent;

    public CreateBlog() {
    }

    public CreateBlog(final String title, final String username, final String blogContent) {
        this.title = title;
        this.username = username;
        this.blogContent = blogContent;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }
}
