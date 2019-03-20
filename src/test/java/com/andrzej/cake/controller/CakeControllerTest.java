package com.andrzej.cake.controller;

import com.andrzej.cake.service.CakeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Unit tests for CakeController
 */
@RunWith(MockitoJUnitRunner.class)
public class CakeControllerTest {
	CakeController cakeController;

	@Mock
	CakeService cakeService;

	@Before
	public void setUp() {
		cakeController = Mockito.spy(new CakeController(cakeService));
	}

	@Test
	public void testGetCakes() throws Exception {
		//given

		//when
		cakeController.getCakes();

		//then
		verify(cakeService, times(1)).getCakes();
	}

	@Test
	public void testGetCake() throws Exception {
		//given

		//when
		cakeController.getCake(1);

		//then
		verify(cakeService, times(1)).getCake(any());
	}

	@Test
	public void testAddCake() throws Exception {
		//given

		//when
		cakeController.addCake("Title", "Description", "URL");

		//then
		verify(cakeService, times(1)).addCake("Title", "Description", "URL");
	}
}
