package org.progamer.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.progamer.model.Setup;

public class SetupDao {

	@Inject
	private EntityManager manager;
	
	//CREATE
	public void create(Setup setup) {
		manager.getTransaction().begin();
		manager.persist(setup);
		manager.getTransaction().commit();

		manager.clear();

	}
	
	//SELECT
	public List<Setup> listAll(){
		
		TypedQuery<Setup> query = manager.createQuery("SELECT s from Setup s", Setup.class);
		return query.getResultList();
	}
}
