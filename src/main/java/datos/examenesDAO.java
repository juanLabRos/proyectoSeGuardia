/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Examen;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jon
 */
public class examenesDAO implements iexamenesDAO {
     // El EJB se encarga de forma automática de hacer las transacciones.

    // Ahora inyectamos la unidad de persistencia a través del API de JPA
    // Simplemente tenemos que usar la anotación e indicar el nombre de nuestra
    // unidad de persistencia
    @PersistenceContext(unitName = "pu")
    EntityManager em;

    // Con este objeto de em ya podemos interactuar con nuestra BD
    @Override
    public List<Examen> findAllExamen() {
        // Creamos un NamedQuery, y el listado lo leemos con getResultList
        // Por lo que estamos escribiendo menos código
        return em.createNamedQuery("Examenes.findAll").getResultList();
    }

    @Override
    public Examen findExamenById(Examen examen) {
       // En este caso no vamos a usar un NamedQuery, que podríamos haber 
        // agregado en la Entidad de Usuario sino que vamos a incluirlo directamente.
        Query query = em.createNamedQuery("Examen.findByIdexamen");
        query.setParameter("examen", examen.getNombreExamen());
        return (Examen) query.getSingleResult();
    }

    @Override
    public Examen findExamenByName(Examen examen) {
        // En este caso no vamos a usar un NamedQuery, que podríamos haber 
        // agregado en la Entidad de Usuario sino que vamos a incluirlo directamente.
        Query query = em.createNamedQuery("Examen.findByNombreExamen");
        query.setParameter("examen", examen.getNombreExamen());
        return (Examen) query.getSingleResult();
    }
    
      @Override
    public Examen findExamenByTema(Examen examen) {
        // En este caso no vamos a usar un NamedQuery, que podríamos haber 
        // agregado en la Entidad de Usuario sino que vamos a incluirlo directamente.
        Query query = em.createNamedQuery("Examen.findByTema");
        query.setParameter("examen", examen.getIdTema());
        return (Examen) query.getSingleResult();
    }

    @Override
    public void insertExamen(Examen examen) {
        //Inserta en la base de datos
        em.persist(examen);
    }

    @Override
    public void updateExamen(Examen examen) {
        // Sincroniza cualquier modificamos que hayamos hecho de la persona en la BD
        em.merge(examen);
    }

    @Override
    public void deleteExamen(Examen examen) {
        // 1. actualizamos el estado del objeto en la base de datos => se borra.
        em.remove(em.merge(examen));
    }
}
