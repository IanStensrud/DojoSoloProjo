package com.projects.dojosoloprojo.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="jokes")
public class Joke {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	


	@NotBlank(message="No setup? Really now?")
	@Size(min=5, max=255, message="Gotta be between 10 and 255 characters.")
	private String setup;

	@NotBlank(message="Back to the drawing board, aye?")
	@Size(min=5, max=255, message="Gotta be between 10 and 255 characters.")
	private String punchline;


	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User poster;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="comedian_id")
	private Comedian comedian;
	
	@ManyToMany(mappedBy="favs")
	private List<User> favUsers;
	
	@PrePersist
	protected void createdAt() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void updatedAt() {
		this.updatedAt = new Date();
	}
	
	
	public Joke() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSetup() {
		return setup;
	}

	public void setSetup(String setup) {
		this.setup = setup;
	}

	public String getPunchline() {
		return punchline;
	}

	public void setPunchline(String punchline) {
		this.punchline = punchline;
	}

	public Comedian getComedian() {
		return comedian;
	}

	public void setComedian(Comedian comedian) {
		this.comedian = comedian;
	}
	
	public List<User> getFavUsers() {
		return favUsers;
	}

	public void setFavUsers(List<User> favUsers) {
		this.favUsers = favUsers;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getPoster() {
		return poster;
	}

	public void setPoster(User poster) {
		this.poster = poster;
	}





}
