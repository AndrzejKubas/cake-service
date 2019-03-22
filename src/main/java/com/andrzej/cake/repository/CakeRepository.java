package com.andrzej.cake.repository;

import com.andrzej.cake.model.Cake;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface is used for all CRUD operations on cake repository.
 *
 * @see CrudRepository
 */
public interface CakeRepository extends CrudRepository<Cake, Long> {

	/**
	 * The method returns particular cake from repository, the cake is selected by id.
	 *
	 * @param id unique cake identifier
	 * @return cake
	 */
	Cake findById(long id);
}
