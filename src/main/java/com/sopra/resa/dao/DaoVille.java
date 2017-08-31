package com.sopra.resa.dao;

import com.sopra.resa.model.Ville;

/*
 * DaoClient = Data Access Object
 *         alias "Data Service" alias "repository spring"
 *   avec methodes CRUD
 *   et throws RuntimeException implicites
 */
public interface DaoVille extends DaoGeneric<Ville, Long> {

}
