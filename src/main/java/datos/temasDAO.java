/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Temas;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jon
 */
public class temasDAO implements itemasDAO{
      // El EJB se encarga de forma automática de hacer las transacciones.

    // Ahora inyectamos la unidad de persistencia a través del API de JPA
    // Simplemente tenemos que usar la anotación e indicar el nombre de nuestra
    // unidad de persistencia
    @PersistenceContext(unitName = "pu")
    EntityManager em;

    // Con este objeto de em ya podemos interactuar con nuestra BD
    @Override
    public List <Temas> findAllTemas() {
        // Creamos un NamedQuery, y el listado lo leemos con getResultList
        // Por lo que estamos escribiendo menos código
        return em.createNamedQuery("Temas.findAll").getResultList();
    }

    @Override
    public Temas findTemasById(Temas temas) {
        Query query = em.createNamedQuery("Temas.findByIdtemas");
        query.setParameter("idTema", temas.getIdtemas());
        return (Temas) query.getSingleResult();
    }
    
    @Override 
    public Temas findTemaByName (Temas temas){
      Query query = em.createNamedQuery("Temas.findByNombreTema");
        query.setParameter("nombreTema", temas.getNombreTema());
        return (Temas) query.getSingleResult();
    }

    

    @Override
    public void insertTema(Temas tema) {
        em.persist(tema);
    }

    @Override
    public void updateTema(Temas tema) {
        // Sincroniza cualquier modificamos que hayamos hecho de la persona en la BD
        em.merge(tema);
    }

    @Override
    public void deleteTema(Temas tema) {
        // 1. actualizamos el estado del objeto en la base de datos => se borra.
        em.remove(em.merge(tema));
    }
    
}
