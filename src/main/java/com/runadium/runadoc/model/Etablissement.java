package com.runadium.runadoc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "etablissements")
public class Etablissement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nomEtablissement;

	
	
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

	public Etablissement(Long id, String nomEtablissement) {
		super();
		this.id = id;
		this.nomEtablissement = nomEtablissement;
	}

	public Etablissement() {
		super();
	} 
	
	
	

}
