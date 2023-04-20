package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Estudiante;
import model.Materia;
import model.Profesor;
import model.Valoracionmateria;

public class ValoracionMateriaController {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GestionCentroEducativoJPA");
	public static Valoracionmateria notaEstudianteMateriaProfesor(Estudiante e, Profesor p, Materia m) {
		Valoracionmateria v = null;
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query q = em.createNativeQuery("select * from valoracionmateria where idEstudiante = "+e.getId()+" and idProfesor = "+p.getId()+" and idMateria = "+m.getId()+";", Valoracionmateria.class);
			v = (Valoracionmateria) q.getSingleResult();
		
		} catch (Exception e2) {
		}
		em.close();
		return v;
	}
	
	
	public static void save(Valoracionmateria m) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(m);
		System.out.println("He realizado la modificacion");
		em.getTransaction().commit();
		em.close();
	}
}
