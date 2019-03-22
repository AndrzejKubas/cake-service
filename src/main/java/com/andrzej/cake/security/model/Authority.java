package com.andrzej.cake.security.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "AUTHORITY", uniqueConstraints = {@UniqueConstraint(columnNames = {"AUTHORITY"})})
public class Authority implements GrantedAuthority {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "AUTHORITY")
	private String authority;

	public Long getId() {
		return id;
	}

	@Override
	public String getAuthority() {
		return authority;
	}
}
