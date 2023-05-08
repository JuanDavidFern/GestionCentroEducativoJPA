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
	
	
	public static void update(Valoracionmateria v) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(v);
		System.out.println("He realizado la modificacion");
		em.getTransaction().commit();
		em.close();
	}
	
	public static void insert(Valoracionmateria v) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(v);
		System.out.println("He realizado la inserccion");
		em.getTransaction().commit();
		em.close();
	}
	
	  /**
     * 
     * @param o
     */
    public static void delete(Valoracionmateria v) {
        System.out.println(v.toString());
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(v));
        System.out.println("HECHO");
        em.getTransaction().commit();
        em.close();
    }
	
//    public int getId (Estudiante e) {
//        Materia m = (Materia) jcbMateria.getSelectedItem();
//        List<Valoracionmateria> v = m.getValoracionmaterias();
//        List<Valoracionmateria> v1 = ((Profesor) jcbProfesor.getSelectedItem()).getValoracionmaterias();
//        List<Valoracionmateria> v2 = e.getValoracionmaterias();
//
//        for (int i = 0; i < v.size(); i++) {
//            for (int j = 0; j < v1.size(); j++) {
//                for (int j2 = 0; j2 < v2.size(); j2++) {
//                    if(v.get(i).getId() == v1.get(j).getId() && v.get(i).getId() == v2.get(j2).getId()) {
//                        return v.get(i).getId();
//                    }
//                }
//            }
//        }
//
//        return 0;
//    }
}
