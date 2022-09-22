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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class BlogComment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	
	@Column(name="blog_comment")
	private String message;  
	
	@Column(name="blog_comment_date")
	@CreationTimestamp
	private LocalDateTime blogCommentDate; 
	
	@Column(name="image_url")
	private String imageUrl;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="blog_id")
	private Blog blog;
	
	
	@ManyToOne
	@JoinColumn(name="blog_comment_id")
	private BlogComment parentBlogComment;
	
	@JsonIgnore
	@OneToMany(mappedBy="parentBlogComment")
	private List<BlogComment> blogComments;
	
	
	
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public BlogComment getParentBlogComment() {
		return parentBlogComment;
	}

	public void setParentBlogComment(BlogComment parentBlogComment) {
		this.parentBlogComment = parentBlogComment;
	}

	public List<BlogComment> getBlogComments() {
		return blogComments;
	}

	public void setBlogComments(List<BlogComment> blogComments) {
		this.blogComments = blogComments;
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

	@Override
	public String toString() {
		return "BlogComment [id=" + id + ", message=" + message + ", blogCommentDate=" + blogCommentDate + ", imageUrl="
				+ imageUrl + ", user=" + user + ", blog=" + blog + ", parentBlogComment=" + parentBlogComment + "]";
	}
	
}
