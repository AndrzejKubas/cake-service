package com.andrzej.cake.runner;

import com.andrzej.cake.model.Cake;
import com.andrzej.cake.repository.CakeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Unit tests for GithubUserContentLoader
 *
 * @see GithubUserContentLoader
 */
@RunWith(MockitoJUnitRunner.class)
public class GithubUserContentLoaderTest {
	GithubUserContentLoader githubUserContentLoader;

	@Mock
	CakeRepository cakeRepository;

	@Mock
	RestTemplate restTemplate;

	@Before
	public void setUp() {
		RestTemplateBuilder restTemplateBuilder = Mockito.mock(RestTemplateBuilder.class);
		when(restTemplateBuilder.build()).thenReturn(restTemplate);
		githubUserContentLoader = Mockito.spy(new GithubUserContentLoader(cakeRepository, restTemplateBuilder));
	}


	@Test
	public void testFetchCakes() throws Exception {
		//given

		//when
		githubUserContentLoader.fetchCakes();

		//then
		verify(restTemplate, times(1)).getForEntity(GithubUserContentLoader.CAKES_URL, Cake[].class);
	}

	@Test
	public void testFetchCakeList() throws Exception {
		//given
		ResponseEntity<Cake[]> responseEntity = Mockito.spy(new ResponseEntity<Cake[]>(HttpStatus.OK));
		doReturn(responseEntity).when(githubUserContentLoader).fetchCakes();
		Cake[] cakes = {new Cake()};
		doReturn(cakes).when(responseEntity).getBody();

		//when
		githubUserContentLoader.fetchCakeList();

		//then
		verify(githubUserContentLoader, times(1)).fetchCakes();
		verify(responseEntity, times(1)).getBody();
	}

	@Test
	public void testRun() throws Exception {
		//given
		doReturn(new ArrayList<>()).when(githubUserContentLoader).fetchCakeList();

		//when
		githubUserContentLoader.run(null);

		//then
		verify(cakeRepository, times(1)).saveAll(any());
	}
}
