package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Estudiante;
import model.Valoracionmateria;



public class EstudianteController {
private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GestionCentroEducativoJPA");
	
	public static List<Estudiante> findAll(){
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("select * from estudiante", Estudiante.class);
		List<Estudiante> lista = (List<Estudiante>)q.getResultList();
		em.close();
		return lista;
	}
	
	public static void update(Estudiante m) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(m);
		System.out.println("He realizado la modificacion");
		em.getTransaction().commit();
		em.close();
	}
	
	public static void insert(Estudiante m) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(m);
		System.out.println("He realizado la inserccion");
		em.getTransaction().commit();
		em.close();
	}
}
