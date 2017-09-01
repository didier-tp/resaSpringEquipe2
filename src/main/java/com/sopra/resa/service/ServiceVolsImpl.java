package com.sopra.resa.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.resa.dao.DaoAeroport;
import com.sopra.resa.dao.DaoEscale;
import com.sopra.resa.dao.DaoReservation;
import com.sopra.resa.dao.DaoVille;
import com.sopra.resa.dao.DaoVol;
import com.sopra.resa.model.Aeroport;
import com.sopra.resa.model.Client;
import com.sopra.resa.model.Escale;
import com.sopra.resa.model.Login;
import com.sopra.resa.model.Reservation;
import com.sopra.resa.model.Ville;
import com.sopra.resa.model.Vol;


@Service
@Transactional
public class ServiceVolsImpl implements ServiceVols {
	
	private Logger logger = LoggerFactory.getLogger(ServiceVolsImpl.class);
	
	@Autowired
	private DaoVol daoVol = null;
	@Autowired
	private DaoEscale daoEscale = null;
	@Autowired
	private DaoReservation daoReservation = null;
	@Autowired
	private DaoVille daoVille = null;
	@Autowired
	private DaoAeroport daoAeroport = null;

	public ServiceVolsImpl() {}
	public void initAfterInject() {}
	//public void setDaoVol(DaoVol daoVol) {this.daoVol = daoVol;}
	
	@Override
	public Vol rechercherVolParNumero(Long idVol) {return daoVol.findByKey(idVol);}
	
	@Override
	public List<Ville> rechercherListeVilles() {return daoVille.findAll();}
	
	@Override
	public List<Aeroport> rechercherListeAeroports() {return daoAeroport.findAll();}
	
	@Override
	public void ajouterVol(Vol vol) {daoVol.insert(vol);}
	
	@Override
	public void modifierVol(Vol vol) {daoVol.update(vol);}
	
	@Override
	public void supprimerVol(Vol vol) {
		Set<Reservation> listeResa = vol.getReservations();
		Set<Escale> listeEsc = vol.getEscales();
		if (listeResa.size()>0) 
			for (Reservation r : listeResa) {
				if (r!=null)
				daoReservation.delete(r);
			}
		if (listeEsc.size()>0) 
			for (Escale e : listeEsc) {
				if (e!=null)
					daoEscale.delete(e);
			}
		if (vol!=null)
			daoVol.delete(vol);
	}
			
	
	@Override
	public List<Vol> rechercherVolsEntre(Ville depart, Ville arrivee) {
		return null;
	}

	@Override
	public List<Vol> rechercherVolsAuDepart(Date dateDepart) {
		return null;
	}

}
