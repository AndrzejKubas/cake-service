package com.andrzej.cake.controller;

import com.andrzej.cake.entity.CakeEntity;
import com.andrzej.cake.service.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This controller is exposing the REST microservice API and is mapping it into @CakeService calls.
 *
 */
@RestController
public class CakeController {
	CakeService cakeService;

	/**
	 * Default constructor for initializing the controller.
	 *
	 * @param cakeService
	 */
	@Autowired
	public CakeController(CakeService cakeService) {
		this.cakeService = cakeService;
	}

	/**
	 * This method is defining and mapping 'v1/cakes' endpoint for returning list fo all cakes.
	 *
	 * @return list of all cakes
	 */
	@RequestMapping(value = "v1/cakes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CakeEntity> getCakes() {
		return cakeService.getCakes();
	}

	/**
	 * This method is defining and mapping 'v1/cakes/{id}' endpoint for returning selected cake.
	 *
	 * @param id unique cake identifier
	 * @return cake
	 */
	@RequestMapping(value = "v1/cakes/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CakeEntity getCake(@PathVariable final long id) {
		return cakeService.getCake(id);
	}

	/**
	 * This method is defining and mapping 'v1/cakes?title=&desc=&imageUrl=' endpoint for adding new cake.
	 *
	 * @param title the title of new cake
	 * @param desc the description of bew cake
	 * @param imageUrl the image URL of the new cake
	 * @return new generated cake
	 */
	@RequestMapping(value = "v1/cakes", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public CakeEntity addCake(@RequestParam(value = "title") final String title,
							  @RequestParam(value = "desc") final String desc,
							  @RequestParam(value = "imageUrl") final String imageUrl) {
		return cakeService.addCake(title, desc, imageUrl);
	}
}