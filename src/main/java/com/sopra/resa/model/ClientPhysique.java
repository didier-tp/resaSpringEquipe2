package com.sopra.resa.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue(value = "physique")
public class ClientPhysique extends Client {
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "TITRE_PHYSIQUE")
	private TitrePhysique titre;

	@Column(name = "PRENOM_CLIENT_PHYSIQUE")
	private String prenom;

	/**
	 * @param nom
	 * @param numeroTel
	 * @param numeroFax
	 * @param email
	 * 
	 * @param adresse
	 * @param login
	 * @param titre
	 * @param prenom
	 */
	public ClientPhysique(String nom, Integer numeroTel, Integer numeroFax, String email, Adresse adresse, Login login,
			TitrePhysique titre, String prenom) {
		super(nom, numeroTel, numeroFax, email, adresse, login);
		this.titre = titre;
		this.prenom = prenom;
	}
	

	/**
	 * @param id
	 * @param nom
	 * @param numeroTel
	 * @param numeroFax
	 * @param email
	 * @param adresse
	 * @param login
	 * @param titre
	 * @param prenom
	 */
	public ClientPhysique(Long id, String nom, Integer numeroTel, Integer numeroFax, String email, Adresse adresse,
			Login login, TitrePhysique titre, String prenom) {
		super(id, nom, numeroTel, numeroFax, email, adresse, login);
		this.titre = titre;
		this.prenom = prenom;
	}


	public ClientPhysique() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param titre
	 * @param prenom
	 */
	public ClientPhysique(TitrePhysique titre, String prenom) {
		super();
		this.titre = titre;
		this.prenom = prenom;
	}

	/**
	 * @return the titre
	 */
	public TitrePhysique getTitre() {
		return titre;
	}

	/**
	 * @param titre
	 *            the titre to set
	 */
	public void setTitre(TitrePhysique titre) {
		this.titre = titre;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
