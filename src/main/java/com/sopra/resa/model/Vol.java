package com.sopra.resa.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
public class Vol {
	@Id
	@SequenceGenerator(name = "seqVol", sequenceName = "seq_Vol", allocationSize = 1, initialValue = 30)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqVol")
	@Column(name = "ID_VOL")
	private Long id;
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_DEPART_VOL")
	private Date dateDepart;
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_ARRIVEE_VOL")
	private Date dateArrivee;
	@Temporal(TemporalType.TIME)
	@Column(name = "HEURE_DEPART_VOL")
	private Date heureDepart;
	@Temporal(TemporalType.TIME)
	@Column(name = "HEURE_ARRIVEE_VOL")
	private Date heureArrivee;
	@OneToMany(mappedBy = "vol")
	private Set<Reservation> reservations;
	@OneToMany(mappedBy = "id.vol")
	private Set<CompagnieVol> compagnieVols;
	@OneToMany(mappedBy = "id.vol")
	private Set<Escale> escales;
	@ManyToOne(targetEntity = Aeroport.class)
	@JoinColumn(name = "ID_AEROPORT_DEPART_VOL", nullable = false, updatable = true)
	private Aeroport aeroportdepart;
	@ManyToOne(targetEntity = Aeroport.class)
	@JoinColumn(name = "ID_AEROPORT_ARRIVEE_VOL", nullable = false, updatable = true)
	private Aeroport aeroportarrivee;
	@Version
	@Column(name = "VERSION_VOL")
	private int version;

	public Vol() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param dateDepart
	 * @param dateArrivee
	 * @param heureDepart
	 * @param heureArrivee
	 * @param aeroportdepart
	 * @param aeroportarrivee
	 */
	public Vol(Date dateDepart, Date dateArrivee, Date heureDepart, Date heureArrivee, Aeroport aeroportdepart,
			Aeroport aeroportarrivee) {
		super();
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
		this.aeroportdepart = aeroportdepart;
		this.aeroportarrivee = aeroportarrivee;
	}

	/**
	 * @param id
	 * @param dateDepart
	 * @param dateArrivee
	 * @param heureDepart
	 * @param heureArrivee
	 * @param aeroportdepart
	 * @param aeroportarrivee
	 */
	public Vol(Long id, Date dateDepart, Date dateArrivee, Date heureDepart, Date heureArrivee, Aeroport aeroportdepart,
			Aeroport aeroportarrivee) {
		super();
		this.id = id;
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
		this.aeroportdepart = aeroportdepart;
		this.aeroportarrivee = aeroportarrivee;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the dateDepart
	 */
	public Date getDateDepart() {
		return dateDepart;
	}

	/**
	 * @param dateDepart
	 *            the dateDepart to set
	 */
	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	/**
	 * @return the dateArrivee
	 */
	public Date getDateArrivee() {
		return dateArrivee;
	}

	/**
	 * @param dateArrivee
	 *            the dateArrivee to set
	 */
	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	/**
	 * @return the heureDepart
	 */
	public Date getHeureDepart() {
		return heureDepart;
	}

	/**
	 * @param heureDepart
	 *            the heureDepart to set
	 */
	public void setHeureDepart(Date heureDepart) {
		this.heureDepart = heureDepart;
	}

	/**
	 * @return the heureArrivee
	 */
	public Date getHeureArrivee() {
		return heureArrivee;
	}

	/**
	 * @param heureArrivee
	 *            the heureArrivee to set
	 */
	public void setHeureArrivee(Date heureArrivee) {
		this.heureArrivee = heureArrivee;
	}

	/**
	 * @return the reservations
	 */
	public Set<Reservation> getReservations() {
		return reservations;
	}

	/**
	 * @param reservations
	 *            the reservations to set
	 */
	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	/**
	 * @return the compagnieAeriennes
	 */
	public Set<CompagnieVol> getCompagnieAeriennes() {
		return compagnieVols;
	}

	/**
	 * @param compagnieAeriennes
	 *            the compagnieAeriennes to set
	 */
	public void setCompagnieAeriennes(Set<CompagnieVol> compagnieVols) {
		this.compagnieVols = compagnieVols;
	}

	/**
	 * @return the escales
	 */
	public Set<Escale> getEscales() {
		return escales;
	}

	/**
	 * @param escales
	 *            the escales to set
	 */
	public void setEscales(Set<Escale> escales) {
		this.escales = escales;
	}

	/**
	 * @return the aeroportdepart
	 */
	public Aeroport getAeroportdepart() {
		return aeroportdepart;
	}

	/**
	 * @param aeroportdepart
	 *            the aeroportdepart to set
	 */
	public void setAeroportdepart(Aeroport aeroportdepart) {
		this.aeroportdepart = aeroportdepart;
	}

	/**
	 * @return the aeroportarrivee
	 */
	public Aeroport getAeroportarrivee() {
		return aeroportarrivee;
	}

	/**
	 * @param aeroportarrivee
	 *            the aeroportarrivee to set
	 */
	public void setAeroportarrivee(Aeroport aeroportarrivee) {
		this.aeroportarrivee = aeroportarrivee;
	}

	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
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
		Vol other = (Vol) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
