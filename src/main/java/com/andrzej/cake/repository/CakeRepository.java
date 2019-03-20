package com.andrzej.cake.repository;

import com.andrzej.cake.entity.CakeEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * This interface is used for all CRUD operations in the cake repository.
 */
public interface CakeRepository extends CrudRepository<CakeEntity, Long> {

	/**
	 * This method returns the cake from repository, it's selected by id.
	 *
	 * @param id unique cake identifier
	 * @return cake
	 */
	CakeEntity findById(long id);
}
