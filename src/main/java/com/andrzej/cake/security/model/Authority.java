package com.andrzej.cake.security.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * The Authority definition class, used in authorization.
 *
 * @see GrantedAuthority
 */
@Entity
@Table(name = "AUTHORITY", uniqueConstraints = {@UniqueConstraint(columnNames = {"AUTHORITY"})})
public class Authority implements GrantedAuthority {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "AUTHORITY")
	private String authority;

	/**
	 * The method returns authority's unique identifier.
	 *
	 * @return
	 */
	public Long getId() {
		return id;
	}

	@Override
	public String getAuthority() {
		return authority;
	}
}
