package me.ablax.mynotes.service;

import me.ablax.mynotes.entity.Blog;
import me.ablax.mynotes.model.request.CreateBlog;
import me.ablax.mynotes.repository.BlogsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Murad Hamza on 27.05.2022 г.
 */

@Service
public class BlogServiceImpl implements BlogService {

    private final BlogsRepository blogsRepository;

    public BlogServiceImpl(final BlogsRepository blogsRepository) {
        this.blogsRepository = blogsRepository;
    }

    @Override
    public List<Blog> getBlogs() {
        return blogsRepository.findAll();
    }

    @Override
    public Blog createBlog(final CreateBlog createBlog) {
        final Blog blog = new Blog(createBlog.getUsername(), createBlog.getTitle(), createBlog.getBlogContent());
        return blogsRepository.save(blog);
    }

    @Override
    public Blog findById(final Long bookId) {
        return blogsRepository.findById(bookId).orElseThrow(() -> new RuntimeException("No blog found!"));
    }

    @Override
    public void deleteById(final Long bookId) {
        blogsRepository.deleteById(bookId);
    }


}
