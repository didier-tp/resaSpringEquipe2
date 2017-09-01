package com.sopra.resa.service;

import java.util.List;

import com.sopra.resa.model.Client;
import com.sopra.resa.model.Login;
import com.sopra.resa.model.Ville;

/**
 * 
 * ServiceClient = service m�tier (business service) avec gestion des
 * transactions (commit, rollback) + traitements sp�cifiques au m�tier (banque
 * ou aviation ou ...)
 * 
 * avec certains sous traitements qui seront d�l�gu�s au(x) DAO(s)
 *
 */

public interface ServiceClient {
	public Client rechercherClient(Long id);

	public void majClient(Client client); // mettre � jour client

	public List<Client> findClientByName(String nom);

	public Client insertClientWithLogin(Client cli, Login login);

	public void supprimerClientWithLogin(Long idClient);

	public Client rechercherClientAvecResa(Long id);

	public Ville rechercherVille(Long id);

	public Login rechercherLogin(Long id);

}
