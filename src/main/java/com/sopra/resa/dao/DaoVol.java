package com.sopra.resa.dao;

import java.util.List;

import com.sopra.resa.model.Ville;
import com.sopra.resa.model.Vol;

/*
 * DaoClient = Data Access Object
 *         alias "Data Service" alias "repository spring"
 *   avec methodes CRUD
 *   et throws RuntimeException implicites
 */
public interface DaoVol extends DaoGeneric<Vol, Long> {
	List<Vol> findBetweenCities(Ville depart, Ville arrivee);
	List<Vol> findByDepartureDate(Date dateDepart);
	

}
