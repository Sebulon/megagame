package com.chalmersmegagame.game.users.repository;

import com.chalmersmegagame.game.users.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Tells how data can be collected and added/removed from the database.
 */
@RepositoryRestResource()
public interface UsersRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User>/*, QuerydslPredicateExecutor<User>*/ {
}
