package com.sopra.resa.service;

import java.util.Date;
import java.util.List;

import com.sopra.resa.model.Aeroport;
import com.sopra.resa.model.Ville;
import com.sopra.resa.model.Vol;

public interface ServiceVols {
	
	List<Vol> rechercherVolsAuDepart (Date dateDepart);
	List<Vol> rechercherVolsEntre (Ville depart, Ville arrivee);
	Vol rechercherVolParNumero(Long idVol);
	List<Ville> rechercherListeVilles();
	List<Aeroport> rechercherListeAeroports();
	void ajouterVol(Vol vol);
	void modifierVol(Vol vol);
	void supprimerVol(Vol vol);
	
}
