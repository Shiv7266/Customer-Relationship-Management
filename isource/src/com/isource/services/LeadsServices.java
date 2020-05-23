package com.isource.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.isource.models.Lead;

/**
 * Session Bean implementation class LeadsServices
 */
@Stateless
@LocalBean
public class LeadsServices {

	@PersistenceContext(unitName = "isource")
	EntityManager em;

	public LeadsServices() {
		// TODO Auto-generated constructor stub
	}

	public void addLead(Lead l) {
		em.persist(l);

	}


	public List<Lead> searchLead() {

		TypedQuery<Lead> query = em.createQuery("Select l from Lead l",
				Lead.class);

		List<Lead> allLeads = query.getResultList();
		return allLeads;

	}

	public void deleteLead(int id) {

		TypedQuery<Lead> lquery = em.createNamedQuery("Lead.findById",
				Lead.class);
		lquery.setParameter("id", id);

		Lead removelead = lquery.getSingleResult();

		em.remove(removelead);

	}

}
