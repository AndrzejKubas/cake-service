package com.andrzej.cake.controller;

import com.andrzej.cake.model.Cake;
import com.andrzej.cake.service.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The controller is exposing the REST microservice API and is mapping it into {@link CakeService} calls.
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
	 * The method is defining and mapping two endpoints for returning list fo all cakes.
	 * 'v1/cakes' endpoint - no need authorization
	 * 'v2/cakes' endpoint - needs OAuth2 authorization
	 *
	 * @return list of all cakes
	 */
	@PreAuthorize("hasAuthority('READ')")
	@RequestMapping(value = {"/api/services/1/cakes"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cake> getCakes() {
		return cakeService.getCakes();
	}

	/**
	 * The method is defining and mapping two endpoints for returning selected cake.
	 * 'v1/cakes/{id}' endpoint - no need authorization
	 * 'v2/cakes/{id}' endpoint - needs OAuth2 authorization
	 *
	 * @param id unique cake identifier
	 * @return cake
	 */
	@PreAuthorize("hasAuthority('READ')")
	@RequestMapping(value = {"/api/services/1/cakes/{id}"}, method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Cake getCake(@PathVariable final long id) {
		return cakeService.getCake(id);
	}

	/**
	 * The method is defining and mapping two endpoints for adding new cake.
	 * 'v1/cakes' endpoint - no need authorization
	 * 'v2/cakes' endpoint - needs OAuth2 authorization
	 *
	 * @param cake cake
	 * @return new generated cake
	 */
	@PreAuthorize("hasAuthority('WRITE')")
	@RequestMapping(value = {"/api/services/1/cakes"}, method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Cake addCake(@RequestBody Cake cake) {
		return cakeService.addCake(cake);
	}
}