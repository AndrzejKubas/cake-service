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
	 * @param title the title of new cake
	 * @param description the description of bew cake
	 * @param imageUrl the image URL of the new cake
	 * @return new generated cake
	 */
	Cake addCake(@NonNull final String title, @NonNull final String description, @NonNull final String imageUrl);
}
