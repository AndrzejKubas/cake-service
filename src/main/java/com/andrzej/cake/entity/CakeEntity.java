package com.andrzej.cake.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The Cake definition class.
 */
@Entity
public class CakeEntity {
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String description;
	private String imageUrl;

	/**
	 * Default empty cake constructor.
	 *
	 */
	public CakeEntity() {
	}

	/**
	 * This cake constructor is used to create and initialize the obj at once.
	 *
* @param title ca
	 * @param description
	 * @param imageUrl
	 */
	@JsonCreator
	public CakeEntity(@JsonProperty("title") final String title,
					  @JsonProperty("desc") final String description,
					  @JsonProperty("image") final String imageUrl) {
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
