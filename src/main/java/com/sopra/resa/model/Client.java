package com.sopra.resa.model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING, length = 8)
@Table(name = "CLIENT")
public abstract class Client {
	@Id
	@SequenceGenerator(name = "seqClient", sequenceName = "seq_Client", allocationSize = 1, initialValue = 30)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqClient")
	@Column(name = "ID_CLIENT")
	private Long id;
	@Column(name = "NOM_CLIENT", length = 150)
	private String nom;
	@Column(name = "NUMERO_TEL_CLIENT")
	private Integer numeroTel;
	@Column(name = "NUMERO_FAX_CLIENT")
	private Integer numeroFax;
	@Column(name = "EMAIL_CLIENT", length = 150)
	private String email;
	@Version
	@Column(name = "VERSION_CLIENT")
	private int version;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "rue", column = @Column(name = "RUE_CLIENT", length = 255)),
			@AttributeOverride(name = "codePostal", column = @Column(name = "CP_CLIENT", length = 5)),
			@AttributeOverride(name = "ville", column = @Column(name = "VILLE_CLIENT", length = 150)),
			@AttributeOverride(name = "pays", column = @Column(name = "PAYS_CLIENT", length = 150)) })
	private Adresse adresse;
	@OneToOne
	@PrimaryKeyJoinColumn
	private Login login;
	@OneToMany(mappedBy = "client")
	private List<Reservation> reservations;

	public Client() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param nom
	 * @param numeroTel
	 * @param numeroFax
	 * @param email
	 * 
	 * @param adresse
	 * @param login
	 */
	public Client(Long id, String nom, Integer numeroTel, Integer numeroFax, String email, Adresse adresse,
			Login login) {
		super();
		this.id = id;
		this.nom = nom;
		this.numeroTel = numeroTel;
		this.numeroFax = numeroFax;
		this.email = email;
		this.adresse = adresse;
		this.login = login;
	}

	/**
	 * @param nom
	 * @param numeroTel
	 * @param numeroFax
	 * @param email
	 * 
	 * @param adresse
	 * @param login
	 */
	public Client(String nom, Integer numeroTel, Integer numeroFax, String email, Adresse adresse, Login login) {
		super();
		this.nom = nom;
		this.numeroTel = numeroTel;
		this.numeroFax = numeroFax;
		this.email = email;

		this.adresse = adresse;
		this.login = login;
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
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the numeroTel
	 */
	public Integer getNumeroTel() {
		return numeroTel;
	}

	/**
	 * @param numeroTel
	 *            the numeroTel to set
	 */
	public void setNumeroTel(Integer numeroTel) {
		this.numeroTel = numeroTel;
	}

	/**
	 * @return the numeroFax
	 */
	public Integer getNumeroFax() {
		return numeroFax;
	}

	/**
	 * @param numeroFax
	 *            the numeroFax to set
	 */
	public void setNumeroFax(Integer numeroFax) {
		this.numeroFax = numeroFax;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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

	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse
	 *            the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the login
	 */
	public Login getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(Login login) {
		this.login = login;
	}

	/**
	 * @return the reservations
	 */
	public List<Reservation> getReservations() {
		return reservations;
	}

	/**
	 * @param reservations
	 *            the reservations to set
	 */
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
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
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}