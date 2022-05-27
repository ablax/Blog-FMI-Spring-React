package me.ablax.mynotes.repository;

import me.ablax.mynotes.entity.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Murad Hamza on 27.05.2022 г.
 */

@Repository
public interface UsersRepository extends CrudRepository<User, String> {

    Optional<User> findOneByEmail(final String email);

}
