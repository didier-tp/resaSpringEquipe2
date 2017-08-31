package com.sopra.resa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

@Entity
public class Login {

	@Id
	@SequenceGenerator(name = "seqLogin", sequenceName = "seq_Login", allocationSize = 1, initialValue = 30)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqLogin")
	@Column(name = "ID_LOGIN")
	private Long id;
	@Column(name = "LOGIN", length = 255)
	private String login;
	@Column(name = "MOT_DE_PASSE_LOGIN", length = 255)
	private String motDePasse;
	@Column(name = "ADMIN_LOGIN")
	private Boolean admin;
	@OneToOne(mappedBy = "login")
	@PrimaryKeyJoinColumn
	private Client client;
	@Version
	@Column(name = "VERSION_LOGIN")
	private int version;

	public Login() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param login
	 * @param motDePasse
	 * @param admin
	 * @param client
	 */
	public Login(Long id, String login, String motDePasse, Boolean admin, Client client) {
		super();
		this.id = id;
		this.login = login;
		this.motDePasse = motDePasse;
		this.admin = admin;
		this.client = client;
	}

	/**
	 * @param login
	 * @param motDePasse
	 * @param admin
	 * @param client
	 */
	public Login(String login, String motDePasse, Boolean admin, Client client) {
		super();
		this.login = login;
		this.motDePasse = motDePasse;
		this.admin = admin;
		this.client = client;
	}

	/**
	 * @param login
	 * @param motDePasse
	 * @param admin
	 * 
	 */
	public Login(String login, String motDePasse, Boolean admin) {
		super();
		this.login = login;
		this.motDePasse = motDePasse;
		this.admin = admin;

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
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/**
	 * @param motDePasse
	 *            the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	/**
	 * @return the admin
	 */
	public Boolean getAdmin() {
		return admin;
	}

	/**
	 * @param admin
	 *            the admin to set
	 */
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
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
		Login other = (Login) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
