package com.andrzej.cake.repository;

import com.andrzej.cake.model.Cake;
import org.springframework.data.repository.CrudRepository;

/**
 * This interface is used for all CRUD operations in the cake repository.
 */
public interface CakeRepository extends CrudRepository<Cake, Long> {

	/**
	 * This method returns the cake from repository, it's selected by id.
	 *
	 * @param id unique cake identifier
	 * @return cake
	 */
	Cake findById(long id);
}
