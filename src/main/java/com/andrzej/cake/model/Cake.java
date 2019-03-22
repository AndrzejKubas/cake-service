package com.andrzej.cake.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Cake definition class.
 */
@Entity
@Table(name = "CAKE")
public class Cake {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "TITLE")
	@JsonProperty("title")
	private String title;

	@Column(name = "DESCRIPTION")
	@JsonProperty("desc")
	private String description;

	@Column(name = "IMAGE_URL")
	@JsonProperty("image")
	private String imageUrl;

	/**
	 * Default empty cake constructor.
	 *
	 */
	public Cake() {
	}

	/**
	 * The constructor is used to create and initialize the obj at once.
	 *
	 * @param title title
	 * @param description description
	 * @param imageUrl image URL
	 */
	public Cake(final String title, final String description, final String imageUrl) {
		this.title = title;
		this.description = description;
		this.imageUrl = imageUrl;
	}

	/**
	 * The method returns cake's unique identifier.
	 *
	 * @return cake's unique identifier
	 */
	public Long getId() {
		return id;
	}

	/**
	 * The method returns cake's title.
	 *
	 * @return cake's title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * The method returns cake's description.
	 *
	 * @return cake's description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * The method returns cake's image URL.
	 *
	 * @return cake's image URL
	 */
	public String getImageUrl() {
		return imageUrl;
	}
}
