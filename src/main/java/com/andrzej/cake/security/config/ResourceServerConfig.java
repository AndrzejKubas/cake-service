package com.andrzej.cake.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * The OAuth2 resource server configuration.
 *
 * @see ResourceServerConfigurerAdapter
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	protected static final String OAUTH2_RESOURCE_ID = "resource-server";
	protected static final String OAUTH2_READ_SCOPE = "#oauth2.hasScope('read')";
	protected static final String OAUTH2_WRITE_SCOPE = "#oauth2.hasScope('write')";
	protected static final String OAUTH2_PATTERN = "/api/services/**";

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(OAUTH2_RESOURCE_ID);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.requestMatchers()
				.antMatchers(OAUTH2_PATTERN).and().authorizeRequests()
				.antMatchers(HttpMethod.POST, OAUTH2_PATTERN).access(OAUTH2_WRITE_SCOPE)
				.anyRequest().access(OAUTH2_READ_SCOPE);
	}
}
