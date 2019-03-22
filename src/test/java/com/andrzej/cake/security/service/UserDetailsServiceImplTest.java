package com.andrzej.cake.security.service;

import com.andrzej.cake.repository.UserRepository;
import com.andrzej.cake.security.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

/**
 * Unit tests for UserDetailsService
 *
 * @see UserDetailsServiceImpl
 */
@RunWith(MockitoJUnitRunner.class)
public class UserDetailsServiceImplTest {
	UserDetailsServiceImpl userDetailsService;

	@Mock
	UserRepository userRepository;

	@Before
	public void setUp() {
		userDetailsService = new UserDetailsServiceImpl(userRepository);
	}

	@Test
	public void testLoadUserByUsername_loadExistingUser() throws Exception {
		//given
		String username = "Aron";
		when(userRepository.findByUsername(username)).thenReturn(new User());

		//when
		userDetailsService.loadUserByUsername(username);

		//then
		Mockito.verify(userRepository, times(1)).findByUsername(username);
	}

	@Test (expected = UsernameNotFoundException.class)
	public void testLoadUserByUsername_loadNotExistedUser() throws Exception {
		//given
		String username = "Aron";
		when(userRepository.findByUsername(username)).thenThrow(new UsernameNotFoundException(username));

		//when
		userDetailsService.loadUserByUsername(username);

		//then
		Mockito.verify(userRepository, times(1)).findByUsername(username);
	}
}
