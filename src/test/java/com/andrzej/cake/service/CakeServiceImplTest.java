package com.andrzej.cake.service;

import com.andrzej.cake.model.Cake;
import com.andrzej.cake.repository.CakeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * Unit tests for CakeServiceImpl
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CakeServiceImplTest {
	CakeServiceImpl cakeServiceImpl;

	@Mock
	CakeRepository cakeRepository;

	@Before
	public void setUp() {
		cakeServiceImpl = Mockito.spy(new CakeServiceImpl(cakeRepository));
	}

	@Test
	public void testGetCakes() throws Exception {
		//given
		List<Cake> cakes = Mockito.spy(new ArrayList<>());
		when(cakeRepository.findAll()).thenReturn(cakes);

		//when
		cakeServiceImpl.getCakes();

		//then
		verify(cakeRepository, times(1)).findAll();
		verify(cakes, times(1)).forEach(any());
	}

	@Test
	public void testGetCake() throws Exception {
		//given
		Long id = new Long(1);
		when(cakeRepository.findById(id)).thenReturn(Optional.of(new Cake()));

		//when
		cakeServiceImpl.getCake(id);

		//then
		verify(cakeRepository, times(1)).findById(id);
	}

	@Test
	public void testAddCake() throws Exception {
		//given

		//when
		Cake result = cakeServiceImpl.addCake(new Cake());

		//then
		verify(cakeRepository, times(1)).save(isA(Cake.class));
	}
}
