package com.isource.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.isource.models.Accounts_Data;
import com.isource.models.Lead;

/**
 * Session Bean implementation class AccountsServices
 */
@Stateless
@LocalBean
public class AccountsServices {

    @PersistenceContext(unitName="isource")
    EntityManager em;
    
    public AccountsServices() {
        // TODO Auto-generated constructor stub
    }
    
    
    public void addAccounts(Accounts_Data data){
    	
    	em.persist(data);
    	
    }
    
    public List<Accounts_Data> searchAccountsReports(){
    	TypedQuery<Accounts_Data> query = em.createQuery("Select l from Accounts_Data l",
    			Accounts_Data.class);

		List<Accounts_Data> allAccounts = query.getResultList();
		return allAccounts;
    }

}
