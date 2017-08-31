package com.sopra.resa.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "VILLEAEROPORT")
public class VilleAeroport {
	@EmbeddedId
	private VilleAeroportPk id;
	@Version
	@Column(name = "VERSION_VILLEAEROPORT")
	private int version;

	public VilleAeroport() {
		// TODO Auto-generated constructor stub
	}

	public VilleAeroport(VilleAeroportPk id) {
		super();
		this.id = id;
	}

	public VilleAeroportPk getId() {
		return id;
	}

	public void setId(VilleAeroportPk id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + version;
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
		VilleAeroport other = (VilleAeroport) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (version != other.version)
			return false;
		return true;
	}

}
