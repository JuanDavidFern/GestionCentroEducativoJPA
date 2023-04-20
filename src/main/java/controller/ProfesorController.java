package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Profesor;



public class ProfesorController {
private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GestionCentroEducativoJPA");
	
	public static List<Profesor> findAll(){
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("select * from profesor", Profesor.class);
		List<Profesor> lista = (List<Profesor>)q.getResultList();
		em.close();
		return lista;
	}
}
