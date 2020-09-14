package com.runadium.runadoc.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;



@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }),
		@UniqueConstraint(columnNames = { "email" }) })
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(min = 3, max = 50)
	private String fullName;

	@NotBlank
	@Size(min = 3, max = 50)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(min = 6, max = 100)
	private String password;

	@Column(name = "created_at", nullable = false)
	@CreationTimestamp
	private Date createdAt;

	@Column(name = "updated_at", nullable = false)
	@UpdateTimestamp
	private Date updatedAt;

	@Lob
	@Column(name = "image")
	private byte[] image;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	 @OneToMany(mappedBy="id")
	    private Set<RendezVous> rendezVous;
	

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_etablissements", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "etablissement_id"))
	private Set<Role> etablissements = new HashSet<>();


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
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


	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}


	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	public Set<RendezVous> getRendezVous() {
		return rendezVous;
	}


	public void setRendezVous(Set<RendezVous> rendezVous) {
		this.rendezVous = rendezVous;
	}


	public Set<Role> getEtablissements() {
		return etablissements;
	}


	public void setEtablissements(Set<Role> etablissements) {
		this.etablissements = etablissements;
	}


	public User(@NotBlank @Size(min = 3, max = 50) String fullName,
			@NotBlank @Size(min = 3, max = 50) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(min = 6, max = 100) String password, Date createdAt, Date updatedAt, byte[] image,
			Set<Role> roles, Set<RendezVous> rendezVous, Set<Role> etablissements) {
		super();
		this.fullName = fullName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.image = image;
		this.roles = roles;
		this.rendezVous = rendezVous;
		this.etablissements = etablissements;
	}


	public User() {
		super();
	}

}