package com.andrzej.cake.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;
import java.util.Collection;

/**
 * The User definition class, used in authentication and authorization.
 *
 * @see UserDetails
 */
@Entity
@Table(name = "USER_", uniqueConstraints = { @UniqueConstraint(columnNames = { "USERNAME" }) })
public class User implements UserDetails, Serializable {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ACCOUNT_EXPIRED")
	private boolean accountExpired;

	@Column(name = "ACCOUNT_LOCKED")
	private boolean accountLocked;

	@Column(name = "CREDENTIALS_EXPIRED")
	private boolean credentialsExpired;

	@Column(name = "ENABLED")
	private boolean enabled;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "AUTHORITIES", joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"),inverseJoinColumns = @JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID"))
	@OrderBy
	@JsonIgnore
	private Collection<Authority> authorities;

	/**
	 * The method returns user's unique identifier.
	 *
	 * @return
	 */
	public Long getId() {
		return id;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return !accountExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !accountLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return !credentialsExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public Collection<? extends org.springframework.security.core.GrantedAuthority> getAuthorities() {
		return authorities;
	}
}
