package me.ablax.mynotes.controller;

import me.ablax.mynotes.entity.Blog;
import me.ablax.mynotes.model.request.CreateBlog;
import me.ablax.mynotes.model.model.BlogResponse;
import me.ablax.mynotes.service.BlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Murad Hamza on 27.05.2022 г.
 */
@Validated
@RestController
@RequestMapping("/blogs")
public class BlogsController {

    private final BlogService blogService;

    public BlogsController(final BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BlogResponse> getBlog(@PathVariable("bookId") final Long bookId) {
        final Blog blog = blogService.findById(bookId);
        return ResponseEntity.ok(BlogResponse.fromBlog(blog));
    }
    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteBlog(@PathVariable("bookId") final Long bookId) {
        blogService.deleteById(bookId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/create")
    public ResponseEntity<BlogResponse> createBlog(@Valid @RequestBody final CreateBlog createBlog) {
        final Blog blog = blogService.createBlog(createBlog);
        return ResponseEntity.ok(BlogResponse.fromBlog(blog));
    }

    @GetMapping("")
    public ResponseEntity<List<BlogResponse>> login() {
        final List<BlogResponse> blogs = blogService.getBlogs().stream().map(BlogResponse::fromBlog).collect(Collectors.toList());

        return ResponseEntity.ok(blogs);
    }

}
