package com.sopra.resa.dao.hibernate;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sopra.resa.dao.DaoVille;
import com.sopra.resa.model.Ville;

//@Component
@Repository // id par defaut = Nom de la classe avec minuscule au début
@Transactional // en version spring
public class DaoVilleHibernate extends DaoGenericImpl<Ville, Long> implements DaoVille {

}
