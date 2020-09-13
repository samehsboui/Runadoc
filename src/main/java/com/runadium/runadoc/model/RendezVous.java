package com.runadium.runadoc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "rendezVous")
public class RendezVous {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
	
	@ManyToOne
    @JoinColumn(name="etablissement_id", nullable=false)
    private Etablissement etablissement;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RendezVous(Long id) {
		super();
		this.id = id;
	}

	public RendezVous() {
		super();
	}
	
	
	
	
}
