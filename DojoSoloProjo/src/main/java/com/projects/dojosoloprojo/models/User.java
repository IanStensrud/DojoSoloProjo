package com.projects.dojosoloprojo.models;

import java.util.Date;
import java.util.List;

//import java.util.List;
//
import org.springframework.format.annotation.DateTimeFormat;

//
////import com.projects.dojosoloprojo.models.Joke;
//
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(min=3, max=42, message="Username must be between 3 and 42 characters.")
	private String username;

	@NotBlank(message="Email is required.")
	@Email(message="Email invalid.")
	private String email;

	@NotBlank(message="Password is required.")
	@Size(min=8, max=128, message="Password: At least 8 characters.")
	private String password;

	@Transient
	@NotBlank(message="Must confirm password.")
	@Size(min=8, max=128, message="Passwords: Must match.")
	private String confirm;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date createdAt;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date updatedAt;

	@OneToMany(mappedBy="poster", fetch=FetchType.LAZY)
	private List<Joke> myJokes;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="favs", 
		joinColumns = @JoinColumn(name="user_id"),
		inverseJoinColumns = @JoinColumn(name="joke_id")
	)
	private List<Joke> favs;

	@PrePersist
	protected void createdAt() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void updatedAt() {
		this.updatedAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	
	

//	public List<Joke> getOgJokes() {
//		return ogJokes;
//	}
//
//	public void setOgJokes(List<Joke> ogJokes) {
//		this.ogJokes = ogJokes;
//	}

	public List<Joke> getFavs() {
		return favs;
	}

	public void setFavs(List<Joke> favs) {
		this.favs = favs;
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




}
