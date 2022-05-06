package com.virtusa.model;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String subject;
	private String description;
	private String views;
	private String discuss;
	@ManyToOne
	@JoinColumn(name = "createdby")
	private UserDetails createdby;
	@ManyToOne
	@JoinColumn(name = "handleby")
	private UserDetails handleby;
	private LocalDate createdon;
	@ManyToOne
	@JoinColumn(name = "parentid")
	private Post parentid;
	
	public Post() {
		this.views="display";
		this.createdon=LocalDate.now();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getViews() {
		return views;
	}
	public void setViews(String views) {
		this.views = views;
	}
	public String getDiscuss() {
		return discuss;
	}
	public void setSolution(String discuss) {
		this.discuss = discuss;
	}
	public UserDetails getCreatedby() {
		return createdby;
	}
	public void setCreatedby(UserDetails createdby) {
		this.createdby = createdby;
	}
	public LocalDate getCreatedon() {
		return createdon;
	}
	public void setCreatedon(LocalDate createdon) {
		this.createdon = createdon;
	}
	
	public Post getParentid() {
		return parentid;
	}
	public void setParentid(Post parentid) {
		this.parentid = parentid;
	}
	public UserDetails getHandleby() {
		return handleby;
	}
	public void setHandleby(UserDetails handleby) {
		this.handleby = handleby;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", subject=" + subject + ", description=" + description + ", views=" + views
				+ ", discuss=" + discuss + ", createdby=" + createdby + ", createdon=" + createdon + ", parentid="
				+ parentid + "]";
	}
	
	
}