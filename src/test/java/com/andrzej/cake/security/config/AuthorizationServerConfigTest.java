package com.andrzej.cake.security.config;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Unit tests for AuthorizationServerConfig
 *
 * @see AuthorizationServerConfig
 */
@RunWith(MockitoJUnitRunner.class)
public class AuthorizationServerConfigTest {
	AuthorizationServerConfig authorizationServerConfig;

	@Mock
	AuthenticationManager authenticationManager;

	@Mock
	UserDetailsService userDetailsService;

	@Mock
	DataSource dataSource;

	@Before
	public void setUp() {
		authorizationServerConfig = new AuthorizationServerConfig(authenticationManager, userDetailsService, dataSource);
	}

	@Test
	public void testConfigure_configureAuthorizationServerSecurity() throws Exception {
		//when
		AuthorizationServerSecurityConfigurer oauthServer = Mockito.spy(AuthorizationServerSecurityConfigurer.class);

		//given
		authorizationServerConfig.configure(oauthServer);

		//then
		verify(oauthServer, times(1)).tokenKeyAccess("permitAll()");
		verify(oauthServer, times(1)).checkTokenAccess("isAuthenticated()");
		verify(oauthServer, times(1)).passwordEncoder(isA(BCryptPasswordEncoder.class));
	}

	@Test
	public void testConfigure_configureClientDetailsService() throws Exception {
		//when
		ClientDetailsServiceConfigurer clients = Mockito.mock(ClientDetailsServiceConfigurer.class);

		//given
		authorizationServerConfig.configure(clients);

		//then
		verify(clients, times(1)).jdbc(dataSource);
	}

	@Test
	public void testConfigure_configureAuthorizationServerEndpoints() throws Exception {
		//when
		AuthorizationServerEndpointsConfigurer endpoints = Mockito.spy(AuthorizationServerEndpointsConfigurer.class);

		//given
		authorizationServerConfig.configure(endpoints);

		//then
		verify(endpoints, times(1)).tokenStore(isA(JdbcTokenStore.class));
		verify(endpoints, times(1)).authenticationManager(authenticationManager);
		verify(endpoints, times(1)).userDetailsService(userDetailsService);
	}
}
