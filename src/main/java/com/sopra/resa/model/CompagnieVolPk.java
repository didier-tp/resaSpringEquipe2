package com.sopra.resa.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Embeddable
public class CompagnieVolPk implements Serializable {

	@ManyToOne
	@JoinColumn(name = "COMPAGNIE_ID")
	private Compagnie compagnie;
	@ManyToOne
	@JoinColumn(name = "VOL_ID")
	private Vol vol;

	public CompagnieVolPk() {

	}

	public CompagnieVolPk(Compagnie compagnie, Vol vol) {
		this.compagnie = compagnie;
		this.vol = vol;
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
		result = prime * result + ((compagnie == null) ? 0 : compagnie.hashCode());
		result = prime * result + ((vol == null) ? 0 : vol.hashCode());
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
		CompagnieVolPk other = (CompagnieVolPk) obj;
		if (compagnie == null) {
			if (other.compagnie != null)
				return false;
		} else if (!compagnie.equals(other.compagnie))
			return false;
		if (vol == null) {
			if (other.vol != null)
				return false;
		} else if (!vol.equals(other.vol))
			return false;
		return true;
	}

}
