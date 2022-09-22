package com.skilldistillery.datenight.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	private String email;
	
	private String username;
	
	private String password;
	
	@Column(name="image_url")
	private String imageUrl;
	
	private String biography;
	
	private String role;
	
	private Boolean enabled;
	
	@Column(name = "date_of_birth")
	private LocalDate dob;
	
	@OneToOne
	@JoinColumn(name="address_id")
	private Address address;
	
	@OneToMany(mappedBy="user")
	private List<Blog> blogs;
	
	@OneToMany(mappedBy="user")
	private List<Review> reviews;
	
	@OneToMany(mappedBy="parentBlogComment")
	private List<BlogComment> blogComments;
	
	@OneToMany(mappedBy="user")
	private List<DateNight> dateNights;
	
	
	
	
	
	
	//CONSTRUCTOR
	public User() {
		super();
	}

	//METHODS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

	
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<BlogComment> getBlogComments() {
		return blogComments;
	}

	public void setBlogComments(List<BlogComment> blogComments) {
		this.blogComments = blogComments;
	}

	@OneToMany(mappedBy="user")
	private List<DateNightDiscussionBoard> discussions;
	
	
	public List<DateNightDiscussionBoard> getDiscussions() {
		return discussions;
	}

	public void setDiscussions(List<DateNightDiscussionBoard> discussions) {
		this.discussions = discussions;
	}

	public List<DateNight> getDateNights() {
		return dateNights;
	}

	public void setDateNights(List<DateNight> dateNights) {
		this.dateNights = dateNights;
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
		User other = (User) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", username=" + username + ", password=" + password + ", imageUrl=" + imageUrl + ", biography="
				+ biography + ", role=" + role + ", enabled=" + enabled + ", dob=" + dob + "]";
	}
	
	
}
