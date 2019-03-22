package com.andrzej.cake.repository;

import com.andrzej.cake.security.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface is used for all CRUD operations on user repository.
 *
 * @see CakeRepository
 */
public interface UserRepository extends CrudRepository<User, Long> {

	/**
	 * The method returns particular user from repository, the user is selected by username.
	 *
	 * @param username unique username
	 * @return User
	 */
	User findByUsername(String username);
}
