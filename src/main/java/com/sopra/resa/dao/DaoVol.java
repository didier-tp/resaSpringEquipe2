package com.sopra.resa.dao;

import com.sopra.resa.model.Vol;

/*
 * DaoClient = Data Access Object
 *         alias "Data Service" alias "repository spring"
 *   avec methodes CRUD
 *   et throws RuntimeException implicites
 */
public interface DaoVol extends DaoGeneric<Vol, Long> {

}
