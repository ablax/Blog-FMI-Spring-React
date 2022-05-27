package me.ablax.mynotes.repository;

import me.ablax.mynotes.entity.Blog;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Murad Hamza on 27.05.2022 г.
 */

@Repository
public interface BlogsRepository extends CrudRepository<Blog, Long> {

    List<Blog> findAll();


}
