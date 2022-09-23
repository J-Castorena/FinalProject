package com.skilldistillery.datenight.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="date_night")
public class DateNight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	
	@Column(name="image_url")
	private String imageUrl;
	
	private String description;
	
	@Column(name="created_date")
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@Column(name="last_updated_date")
	@CreationTimestamp
	private LocalDateTime lastUpdatedDate;
	
	private Boolean active;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	
	@OneToOne
	@JoinColumn(name="address_id")
	private Address address;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name="date_night_has_category", joinColumns = @JoinColumn(name="date_night_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private List<Category> categories;
	
	@JsonIgnore
	@OneToMany(mappedBy="dateNightId")
	private List<DateNightDiscussionBoard> discussions;
	
	@JsonIgnore
	@OneToMany(mappedBy="dateNight")
	private List<Review> reviews;

	//CONSTRUCTOR
	public DateNight() {
		super();
	}

	//METHODS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	

	public List<DateNightDiscussionBoard> getDiscussions() {
		return discussions;
	}

	public void setDiscussions(List<DateNightDiscussionBoard> discussions) {
		this.discussions = discussions;
	}
	

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "DateNight [id=" + id + ", name=" + name + ", imageUrl=" + imageUrl + ", description=" + description
				+ ", createdDate=" + createdDate + ", lastUpdatedDate=" + lastUpdatedDate + ", active=" + active + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(active, address, categories, createdDate, description, discussions, id, imageUrl,
				lastUpdatedDate, name, reviews, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DateNight other = (DateNight) obj;
		return Objects.equals(active, other.active) && Objects.equals(address, other.address)
				&& Objects.equals(categories, other.categories) && Objects.equals(createdDate, other.createdDate)
				&& Objects.equals(description, other.description) && Objects.equals(discussions, other.discussions)
				&& id == other.id && Objects.equals(imageUrl, other.imageUrl)
				&& Objects.equals(lastUpdatedDate, other.lastUpdatedDate) && Objects.equals(name, other.name)
				&& Objects.equals(reviews, other.reviews) && Objects.equals(user, other.user);
	}

	
	
}
