package com.runadium.runadoc.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "etablissements")
public class Etablissement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nomEtablissement;

	 @OneToMany(mappedBy="id")
	    private Set<RendezVous> rendezVous;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomEtablissement() {
		return nomEtablissement;
	}

	public void setNomEtablissement(String nomEtablissement) {
		this.nomEtablissement = nomEtablissement;
	}

	public Set<RendezVous> getRendezVous() {
		return rendezVous;
	}

	public void setRendezVous(Set<RendezVous> rendezVous) {
		this.rendezVous = rendezVous;
	}

	public Etablissement(String nomEtablissement, Set<RendezVous> rendezVous) {
		super();
		this.nomEtablissement = nomEtablissement;
		this.rendezVous = rendezVous;
	}

	public Etablissement() {
		super();
	}
	
}
