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
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="comedians")
public class Comedian {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message="Gotta have a name.")
	@Size(min=3, max=20, message="Name must be 3 to 20 characters")
	private String name;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date createdAt;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date updatedAt;

	@OneToMany(mappedBy="comedian", fetch=FetchType.LAZY)
	private List<Joke> jokes;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Joke> getJokes() {
		return jokes;
	}

	public void setJokes(List<Joke> jokes) {
		this.jokes = jokes;
	}



}
