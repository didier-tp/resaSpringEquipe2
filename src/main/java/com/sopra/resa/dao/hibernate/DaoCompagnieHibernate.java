package com.sopra.resa.dao.hibernate;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sopra.resa.dao.DaoCompagnie;
import com.sopra.resa.model.Compagnie;

//@Component
@Repository // id par defaut = Nom de la classe avec minuscule au début
@Transactional // en version spring
public class DaoCompagnieHibernate extends DaoGenericImpl<Compagnie, Long> implements DaoCompagnie {

}
