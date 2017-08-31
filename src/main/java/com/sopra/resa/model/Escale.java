package com.sopra.resa.model;

//à verifier (util/sql?)
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(schema = "public", name = "ESCALE")
public class Escale {

	@EmbeddedId
	@Column(name = "ID_ESCALE")
	private EscalePK id;
	@Column(name = "HEUREDEPART_ESCALE")
	private Date heureDepart;
	@Column(name = "HEUREARRIVEE_ESCALE")
	private Date heureArrivee;
	@Version
	@Column(name = "VERSION_ESCALE")
	private int version;

	public Escale(Date heureDepart, Date heureArrivee, Vol vol, Aeroport aeroport) {
		super();
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;

	}

	public Escale() {
		super();
	}

	public Date getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(Date heureDepart) {
		this.heureDepart = heureDepart;
	}

	public Date getHeureArrivee() {
		return heureArrivee;
	}

	public void setHeureArrivee(Date heureArrivee) {
		this.heureArrivee = heureArrivee;
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
		Escale other = (Escale) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
