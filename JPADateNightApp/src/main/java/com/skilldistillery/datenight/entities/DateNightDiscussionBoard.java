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
public class DateNightDiscussionBoard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "comment")
	private String message;

	@Column(name = "comment_date")
	@CreationTimestamp
	private LocalDateTime commentDate;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "datenight_id")
	private DateNight dateNightId;

	@ManyToOne
	@JoinColumn(name = "date_night_discussion_board_id")
	private DateNightDiscussionBoard parentDiscussion;

	@JsonIgnore
	@OneToMany(mappedBy = "parentDiscussion")
	private List<DateNightDiscussionBoard> discussions;

	public DateNightDiscussionBoard() {
		super();
	}

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

	public LocalDateTime getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(LocalDateTime commentDate) {
		this.commentDate = commentDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public DateNight getDateNightId() {
		return dateNightId;
	}

	public void setDateNightId(DateNight dateNightId) {
		this.dateNightId = dateNightId;
	}

	public DateNightDiscussionBoard getParentDiscussion() {
		return parentDiscussion;
	}

	public void setParentDiscussion(DateNightDiscussionBoard parentDiscussion) {
		this.parentDiscussion = parentDiscussion;
	}

	public List<DateNightDiscussionBoard> getDiscussions() {
		return discussions;
	}

	public void setDiscussions(List<DateNightDiscussionBoard> discussions) {
		this.discussions = discussions;
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
		DateNightDiscussionBoard other = (DateNightDiscussionBoard) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "DateNightDiscussionBoard [id=" + id + ", message=" + message + ", commentDate=" + commentDate
				+ ", user=" + user + ", dateNightId=" + dateNightId + ", parentDiscussion=" + parentDiscussion + "]";
	}

}
