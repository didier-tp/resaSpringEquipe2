package com.sopra.resa.dao.hibernate;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sopra.resa.dao.DaoVol;
import com.sopra.resa.model.Vol;

//@Component
@Repository // id par defaut = Nom de la classe avec minuscule au début
@Transactional // en version spring
public class DaoVolHibernate extends DaoGenericImpl<Vol, Long> implements DaoVol {

}
