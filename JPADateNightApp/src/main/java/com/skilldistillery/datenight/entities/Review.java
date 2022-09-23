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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int rating;
	
	private String comment;
	
	@Column(name="review_date")
	@CreationTimestamp
	private LocalDateTime reviewDate;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="date_night_id")
	private DateNight dateNight;
	
	@OneToMany(mappedBy="review")
	private List<AdditionalImage> images;

	
	//CONSTRUCTOR
	public Review() {
		super();
	}

	
	//METHODS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDateTime getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(LocalDateTime reviewDate) {
		this.reviewDate = reviewDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public DateNight getDateNight() {
		return dateNight;
	}

	public void setDateNight(DateNight dateNight) {
		this.dateNight = dateNight;
	}
	

	public List<AdditionalImage> getImages() {
		return images;
	}


	public void setImages(List<AdditionalImage> images) {
		this.images = images;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", rating=" + rating + ", comment=" + comment + ", reviewDate=" + reviewDate
				+ ", user=" + user + ", dateNight=" + dateNight + "]";
	}
	
	
}