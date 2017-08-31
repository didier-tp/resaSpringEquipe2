package com.sopra.resa.dao.hibernate;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sopra.resa.dao.DaoPassager;
import com.sopra.resa.model.Passager;

//@Component
@Repository // id par defaut = Nom de la classe avec minuscule au début
@Transactional // en version spring
public class DaoPassagerHibernate extends DaoGenericImpl<Passager, Long> implements DaoPassager {

}
