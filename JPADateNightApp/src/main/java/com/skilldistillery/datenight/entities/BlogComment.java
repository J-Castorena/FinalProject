package com.skilldistillery.datenight.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class BlogComment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	
	@Column(name="blog_comment")
	private String blogComment;
	
	@Column(name="blog_comment_date")
	@CreationTimestamp
	private LocalDateTime blogCommentDate; 
	
	@Column(name="image_url")
	private String imageUrl;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@MapsId(value="userId")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="blog_id")
	@MapsId(value="blogId")
	private Blog blog;
	
	@JoinColumn(name="blog_comment_id")
	@MapsId(value="blogCommentId")
	private BlogComment blogCommentId;
	
	//CONSTRUCTOR
	public BlogComment() {
		super();
	}

	//METHODS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBlogComment() {
		return blogComment;
	}

	public void setBlogComment(String blogComment) {
		this.blogComment = blogComment;
	}

	public LocalDateTime getBlogCommentDate() {
		return blogCommentDate;
	}

	public void setBlogCommentDate(LocalDateTime blogCommentDate) {
		this.blogCommentDate = blogCommentDate;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "BlogComment [id=" + id + ", blogComment=" + blogComment + ", blogCommentDate=" + blogCommentDate
				+ ", imageUrl=" + imageUrl + ", user=" + user + "]";
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
		BlogComment other = (BlogComment) obj;
		return id == other.id;
	}
	
}
