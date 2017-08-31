package com.sopra.resa.dao;

import com.sopra.resa.model.Reservation;

/*
 * DaoClient = Data Access Object
 *         alias "Data Service" alias "repository spring"
 *   avec methodes CRUD
 *   et throws RuntimeException implicites
 */
public interface DaoReservation extends DaoGeneric<Reservation, Long> {

}
