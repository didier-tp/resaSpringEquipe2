package com.sopra.resa.dao;

import com.sopra.resa.model.Compagnie;

/*
 * DaoClient = Data Access Object
 *         alias "Data Service" alias "repository spring"
 *   avec methodes CRUD
 *   et throws RuntimeException implicites
 */
public interface DaoCompagnie extends DaoGeneric<Compagnie, Long> {

}
