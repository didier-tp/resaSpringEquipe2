package com.sopra.resa.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Embeddable
public class EscalePK implements Serializable {
	@ManyToOne(targetEntity = Vol.class)
	@JoinColumn(name = "ID_VOL")
	private Vol vol;
	@ManyToOne(targetEntity = Aeroport.class)
	@JoinColumn(name = "ID_AEROPORT")
	private Aeroport aeroport;

	/**
	 * @param vol
	 * @param aeroport
	 */
	public EscalePK(Vol vol, Aeroport aeroport) {
		super();
		this.vol = vol;
		this.aeroport = aeroport;
	}

	public EscalePK() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the vol
	 */
	public Vol getVille() {
		return vol;
	}

	/**
	 * @param vol
	 *            the vol to set
	 */
	public void setVille(Vol vol) {
		this.vol = vol;
	}

	/**
	 * @return the aeroport
	 */
	public Aeroport getAeroport() {
		return aeroport;
	}

	/**
	 * @param aeroport
	 *            the aeroport to set
	 */
	public void setAeroport(Aeroport aeroport) {
		this.aeroport = aeroport;
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
		result = prime * result + ((aeroport == null) ? 0 : aeroport.hashCode());
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
		EscalePK other = (EscalePK) obj;
		if (aeroport == null) {
			if (other.aeroport != null)
				return false;
		} else if (!aeroport.equals(other.aeroport))
			return false;
		if (vol == null) {
			if (other.vol != null)
				return false;
		} else if (!vol.equals(other.vol))
			return false;
		return true;
	}

}
