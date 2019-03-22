package com.andrzej.cake.service;

import com.andrzej.cake.model.Cake;
import org.springframework.lang.NonNull;

import java.util.List;

/**
 * The interface is used to perform all allowed operations on cakes.
 *
 */
public interface CakeService {

	/**
	 * This method returns all cakes.
	 *
	 * @return List of cakes
	 */
	List<Cake> getCakes();

	/**
	 * This method returns the cake selected by it's id.
	 *
	 * @param id unique cake identifier
	 * @return cake
	 */
	Cake getCake(@NonNull final Long id);

	/**
	 * This method is adding new cake into the system, by filling cake's attributes.
	 *
	 * @param cake new cake
	 * @return new generated cake
	 */
	Cake addCake(@NonNull final Cake cake);
}
