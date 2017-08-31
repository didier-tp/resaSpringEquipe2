package com.sopra.resa.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;


@Entity
@Table(name="COMPAGNIE_VOL")
public class CompagnieVol {
	@EmbeddedId
	private CompagnieVolPk id;
	@Version
	@Column(name="VERSION_COMPAGNIE_VOL")
	private int version;

	public CompagnieVol() {
		
	}

	public CompagnieVol(CompagnieVolPk id) {
		this.id = id;
	}

	public CompagnieVolPk getId() {
		return id;
	}

	public void setId(CompagnieVolPk id) {
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
		CompagnieVol other = (CompagnieVol) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
