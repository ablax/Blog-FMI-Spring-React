package me.ablax.mynotes.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * @author Murad Hamza on 27.05.2022 г.
 */

@Entity(name = "blogs")
public class Blog {

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String title;
    private String blogContent;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public Blog() {

    }


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(final LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String username) {
        this.author = username;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(final String blogContent) {
        this.blogContent = blogContent;
    }


    public Blog(final Long id, final String author, final String title, final String blogContent, final LocalDateTime createdAt, final LocalDateTime updatedAt) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.blogContent = blogContent;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Blog(final String author, final String title, final String blogContent) {
        this.author = author;
        this.title = title;
        this.blogContent = blogContent;
    }

    public Blog(final Long id, final String author, final String title, final String blogContent) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.blogContent = blogContent;
    }
}
