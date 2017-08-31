package com.sopra.resa.dao.hibernate;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sopra.resa.dao.DaoReservation;
import com.sopra.resa.model.Reservation;

//@Component
@Repository // id par defaut = Nom de la classe avec minuscule au début
@Transactional // en version spring
public class DaoReservationHibernate extends DaoGenericImpl<Reservation, Long> implements DaoReservation {

}
