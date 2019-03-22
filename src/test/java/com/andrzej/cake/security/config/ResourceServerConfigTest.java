package com.andrzej.cake.security.config;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Unit tests for ResourceServerConfig
 *
 * @see ResourceServerConfig
 */
@RunWith(MockitoJUnitRunner.class)
public class ResourceServerConfigTest {
	ResourceServerConfig resourceServerConfig;

	@Before
	public void setUp() {
		resourceServerConfig= new ResourceServerConfig();
	}

	@Test
	public void testConfigure_configureResourceServerSecurity() throws Exception {
		//given
		ResourceServerSecurityConfigurer resources = Mockito.mock(ResourceServerSecurityConfigurer.class);

		//when
		resourceServerConfig.configure(resources);

		//then
		verify(resources, times(1)).resourceId(ResourceServerConfig.OAUTH2_RESOURCE_ID);
	}
}
