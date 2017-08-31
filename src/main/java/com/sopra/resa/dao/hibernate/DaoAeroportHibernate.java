package com.sopra.resa.dao.hibernate;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sopra.resa.dao.DaoAeroport;
import com.sopra.resa.model.Aeroport;

//@Component
@Repository // id par defaut = Nom de la classe avec minuscule au début
@Transactional // en version spring
public class DaoAeroportHibernate extends DaoGenericImpl<Aeroport, Long> implements DaoAeroport {

}
