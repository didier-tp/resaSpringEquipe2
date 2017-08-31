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
@Table(schema = "public", name = "AEROPORT")
public class Aeroport {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_aeroport")
	@SequenceGenerator(name = "generator_aeroport", sequenceName = "AEROPORT_SEQ", initialValue = 1, allocationSize = 1)
	@Column(name = "ID_AEROPORT")
	private Long id;
	@Column(name = "NOM_AEROPORT", length = 100)
	private String nom;
	@Version
	@Column(name = "VERSION_AEROPORT")
	private int version;
	@OneToMany(mappedBy = "aeroportdepart")
	private Set<Vol> volsdepart;
	@OneToMany(mappedBy = "aeroportarrivee")
	private Set<Vol> volsarrivee;

	public Aeroport() {
		super();
	}

	public Aeroport(String nom, int version) {
		super();
		this.nom = nom;
		this.version = version;

	}

	public Aeroport(String nom) {
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

	/**
	 * @return the volsdepart
	 */
	public Set<Vol> getVolsdepart() {
		return volsdepart;
	}

	/**
	 * @param volsdepart the volsdepart to set
	 */
	public void setVolsdepart(Set<Vol> volsdepart) {
		this.volsdepart = volsdepart;
	}

	/**
	 * @return the volsarrivee
	 */
	public Set<Vol> getVolsarrivee() {
		return volsarrivee;
	}

	/**
	 * @param volsarrivee the volsarrivee to set
	 */
	public void setVolsarrivee(Set<Vol> volsarrivee) {
		this.volsarrivee = volsarrivee;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
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
		Aeroport other = (Aeroport) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

	

}
