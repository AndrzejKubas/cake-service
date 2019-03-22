package com.andrzej.cake.runner;

import com.andrzej.cake.model.Cake;
import com.andrzej.cake.repository.CakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This runner is loading the pre-defined data(cakes) into the in-memory database.
 */
@Component
public class GithubUserContentLoader implements ApplicationRunner {
	protected static final String CAKES_URL = "https://gist.githubusercontent.com/hart88/198f29ec5114a3ec3460/raw/8dd19a88f9b8d24c23d9960f3300d0c917a4f07c/cake.json";

	private final CakeRepository cakeRepository;
	private final RestTemplate restTemplate;

	/**
	 * Default constructor for pre-defined data(cakes) loader.
	 *
	 * @param cakeRepository cake repository
	 * @param builder rest template builder
	 */
	@Autowired
	public GithubUserContentLoader(CakeRepository cakeRepository, RestTemplateBuilder builder) {
		this.cakeRepository = cakeRepository;
		this.restTemplate = builder.build();

		//Workaround for the wrong 'Content-Type' header in server response , server should set it into application/json
		setTextPlainMediaTypeToRestTemplate();
	}

	/**
	 * The method sets "text/plain" into rest template as supported media type.
	 *
	 */
	protected void setTextPlainMediaTypeToRestTemplate() {
		final List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
		final MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.TEXT_PLAIN));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);
	}

	/**
	 * The method fetches data from CAKES_URL.
	 *
	 * @return server response
	 */
	protected ResponseEntity<Cake[]> fetchCakes() {
		return this.restTemplate.getForEntity(CAKES_URL, Cake[].class);
	}

	/**
	 * Method returns list of cakes
	 *
	 * @return
	 */
	protected List<Cake> fetchCakeList() {
		return Arrays.asList(fetchCakes().getBody());
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		cakeRepository.saveAll(fetchCakeList());
	}
}
