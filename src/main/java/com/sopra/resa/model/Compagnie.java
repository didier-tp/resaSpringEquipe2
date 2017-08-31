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
@Table(schema = "public", name = "COMPAGNIE")
@SequenceGenerator(name = "seq_compagnie", sequenceName = "seq_compagnie", initialValue = 1, allocationSize = 1)
public class Compagnie {
	@Id
	@Column(name = "Compagnie_Id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_compagnie")
	private Long Id;
	@Column(name = "NOM_COMPAGNIE")
	private String nom;
	@Version
	@Column(name = "VERSION_COMPAGNIE")
	private int version;
	@OneToMany(mappedBy = "id.compagnie")
	private Set<CompagnieVol> compagnieAerienneVols;

	public Compagnie() {

	}

	public Compagnie(Long id, String nom, int version) {
		Id = id;
		this.nom = nom;
		this.version = version;
	}

	public Compagnie(String nom) {
		this.nom = nom;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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
	 * @return the compagnieAerienneVols
	 */
	public Set<CompagnieVol> getCompagnieAerienneVols() {
		return compagnieAerienneVols;
	}

	/**
	 * @param compagnieAerienneVols
	 *            the compagnieAerienneVols to set
	 */
	public void setCompagnieAerienneVols(Set<CompagnieVol> compagnieAerienneVols) {
		this.compagnieAerienneVols = compagnieAerienneVols;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compagnie other = (Compagnie) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}

}
