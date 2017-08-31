package com.sopra.resa.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(schema = "public", name = "VILLE")
public class Ville {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_ville")
	@SequenceGenerator(name = "generator_ville", sequenceName = "VILLE_SEQ", initialValue = 1, allocationSize = 1)
	@Column(name = "ID_VILLE")
	private Long id;
	@Column(name = "NOM_VILLE", length = 100)
	private String nom;
	@Version
	@Column(name = "VERSION_VILLE")
	private int version;
	@OneToMany(mappedBy = "id.ville")
	private Set<VilleAeroport> villeaeroports;

	public Ville() {
		super();
	}

	public Ville(Long id) {
		super();
		this.id = id;
	}

	public Ville(Long id, String nom, Set<VilleAeroport> villeaeroports) {
		super();
		this.id = id;
		this.nom = nom;
		this.villeaeroports = villeaeroports;
	}

	public Ville(Long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public Ville(String nom, Set<VilleAeroport> villeaeroports) {
		super();
		this.nom = nom;
		this.villeaeroports = villeaeroports;
	}

	public Ville(String nom) {
		super();
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Set<VilleAeroport> getVilleaeroports() {
		return villeaeroports;
	}

	public void setVilleaeroports(Set<VilleAeroport> villeaeroports) {
		this.villeaeroports = villeaeroports;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ville other = (Ville) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
