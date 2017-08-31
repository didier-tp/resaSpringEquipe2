package com.sopra.resa.dao;

import com.sopra.resa.model.Aeroport;

/*
 * DaoClient = Data Access Object
 *         alias "Data Service" alias "repository spring"
 *   avec methodes CRUD
 *   et throws RuntimeException implicites
 */
public interface DaoAeroport extends DaoGeneric<Aeroport, Long> {

}
