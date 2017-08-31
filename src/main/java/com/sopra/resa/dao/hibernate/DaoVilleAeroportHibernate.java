package com.sopra.resa.dao.hibernate;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sopra.resa.dao.DaoVilleAeroport;
import com.sopra.resa.model.VilleAeroport;

//@Component
@Repository // id par defaut = Nom de la classe avec minuscule au début
@Transactional // en version spring
public class DaoVilleAeroportHibernate extends DaoGenericImpl<VilleAeroport, Long> implements DaoVilleAeroport {

}
