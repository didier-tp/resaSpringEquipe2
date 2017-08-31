package com.sopra.resa.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue(value = "moral")
public class ClientMoral extends Client {
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "TITRE_MORAL")
	private TitreMoral titre;

	@Column(name = "SIRET_CLIENT")
	private String siret;

	
	
	
	
	/**
	 * @param id
	 * @param nom
	 * @param numeroTel
	 * @param numeroFax
	 * @param email
	 * @param adresse
	 * @param login
	 * @param titre
	 * @param siret
	 */
	public ClientMoral(Long id, String nom, Integer numeroTel, Integer numeroFax, String email, Adresse adresse,
			Login login, TitreMoral titre, String siret) {
		super(id, nom, numeroTel, numeroFax, email, adresse, login);
		this.titre = titre;
		this.siret = siret;
	}

	/**
	 * @param nom
	 * @param numeroTel
	 * @param numeroFax
	 * @param email
	 * @param adresse
	 * @param login
	 * @param titre
	 * @param siret
	 */
	public ClientMoral(String nom, Integer numeroTel, Integer numeroFax, String email, Adresse adresse, Login login,
			TitreMoral titre, String siret) {
		super(nom, numeroTel, numeroFax, email, adresse, login);
		this.titre = titre;
		this.siret = siret;
	}

	public ClientMoral() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param titre
	 * @param siret
	 */
	public ClientMoral(TitreMoral titre, String siret) {
		super();
		this.titre = titre;
		this.siret = siret;
	}

	/**
	 * @return the titre
	 */
	public TitreMoral getTitre() {
		return titre;
	}

	/**
	 * @param titre
	 *            the titre to set
	 */
	public void setTitre(TitreMoral titre) {
		this.titre = titre;
	}

	/**
	 * @return the siret
	 */
	public String getSiret() {
		return siret;
	}

	/**
	 * @param siret
	 *            the siret to set
	 */
	public void setSiret(String siret) {
		this.siret = siret;
	}

}
