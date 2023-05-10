package it.daniele.controller;

import it.daniele.model.Cliente;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 * Session Bean implementation class ClienteServiceBean
 */
@Stateless
public class ClienteServiceBean implements ClienteServiceBeanRemote, ClienteServiceBeanLocal {
	@PersistenceContext(unitName="corsoWebPersistence")
	EntityManager manager;

	public ClienteServiceBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void inserisci(Cliente cliente) {
		manager.persist(cliente);
	}

	@Override
	public Cliente getCliente(Cliente cliente) {
		
		Query q = manager.createQuery("SELECT c FROM Cliente c WHERE c.username=\"" + cliente.getUsername() + "\"");
		Cliente cliente2= (Cliente) q.getSingleResult();

		if (cliente.getPassword().equals(cliente2.getPassword())) {
			return cliente2;
		}
		else return null;
	}

}
