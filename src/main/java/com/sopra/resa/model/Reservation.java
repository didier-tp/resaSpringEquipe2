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
public class Reservation {
	@Id
	@SequenceGenerator(name = "seqReservation", sequenceName = "seq_Reservation", allocationSize = 1, initialValue = 30)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqReservation")
	@Column(name = "ID_RESERVATION")
	private Long id;
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_DE_RESERVATION")
	private Date date;
	@Column(name = "NUMERO_DE_RESERVATION")
	private Integer numero;
	@OneToMany(mappedBy = "reservation")
	private Set<Passager> passager;
	@ManyToOne(targetEntity = Client.class)
	@JoinColumn(name = "ID_CLIENT_RESERVATION", nullable = false, updatable = true)
	private Client client;
	@ManyToOne(targetEntity = Vol.class)
	@JoinColumn(name = "ID_VOL_RESERVATION", nullable = false, updatable = true)
	private Vol vol;

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
		Reservation other = (Reservation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/**
	 * @param date
	 * @param numero
	 * 
	 */
	public Reservation(Date date, Integer numero) {
		super();
		this.date = date;
		this.numero = numero;

	}

	@Version
	@Column(name = "VERSION_RESERVATION")
	private int version;

	public Reservation(Long id, Date date, Integer numero, Client client, Vol vol) {
		super();
		this.id = id;
		this.date = date;
		this.numero = numero;

		this.client = client;
		this.vol = vol;
	}

	public Reservation() {
		super();
	}

	public Reservation(Date date, Integer numero, Client client, Vol vol) {
		super();
		this.date = date;
		this.numero = numero;

		this.client = client;
		this.vol = vol;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
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

}
