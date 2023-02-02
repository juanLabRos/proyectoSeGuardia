/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Suscripcion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jon
 */
public class suscripcionDAO implements isuscripcionDAO {

    @PersistenceContext(unitName = "pu")
    EntityManager em;

    @Override
    public List<Suscripcion> findAllSuscripcion() {
        // Creamos un NamedQuery, y el listado lo leemos con getResultList
        // Por lo que estamos escribiendo menos código
        return em.createNamedQuery("Suscripcion.findAll").getResultList();
    }

    @Override
    public Suscripcion findSuscripcionById(Suscripcion suscripcion) {
        // En este caso no vamos a usar un NamedQuery, que podríamos haber 
        // agregado en la Entidad de Usuario sino que vamos a incluirlo directamente.
        Query query = em.createNamedQuery("Suscripcion.findByIdsuscripcion");
        query.setParameter("suscripcion", suscripcion.getIdsuscripcion());
        return (Suscripcion) query.getSingleResult();
    }

    @Override
    public Suscripcion findSuscripcionByFechaInicio(Suscripcion suscripcion) {
        // En este caso no vamos a usar un NamedQuery, que podríamos haber 
        // agregado en la Entidad de Usuario sino que vamos a incluirlo directamente.
        Query query = em.createNamedQuery("Suscripcion.findByFechaInicio");
        query.setParameter("suscripcion", suscripcion.getFechaInicio());
        return (Suscripcion) query.getSingleResult();
    }

    @Override
    public Suscripcion findSuscripcionByFechaFin(Suscripcion suscripcion) {
        // En este caso no vamos a usar un NamedQuery, que podríamos haber 
        // agregado en la Entidad de Usuario sino que vamos a incluirlo directamente.
        Query query = em.createNamedQuery("Suscripcion.findByFechaFin");
        query.setParameter("suscripcion", suscripcion.getFechaFin());
        return (Suscripcion) query.getSingleResult();
    }
    
    @Override
    public Suscripcion findSuscripcionByPrecio(Suscripcion suscripcion){
        Query query = em.createNamedQuery("Suscripcion.findByPrecio");
        query.setParameter("suscripcion", suscripcion.getPrecio());
        return (Suscripcion) query.getSingleResult();
    }

    @Override
    public Suscripcion findsuscrpcionByIdUsuario(Suscripcion suscripcion) {
        // En este caso no vamos a usar un NamedQuery, que podríamos haber 
        // agregado en la Entidad de Usuario sino que vamos a incluirlo directamente.
        Query query = em.createNamedQuery("Suscripcion.findByIdUsuario");
        query.setParameter("suscripcion", suscripcion.getUsuarioIdusuario());
        return (Suscripcion) query.getSingleResult();
    }

    @Override
    public void insertSuscripcion(Suscripcion suscripcion) {
        //Inserta en la base de datos
        em.persist(suscripcion);
    }

    @Override
    public void updateSuscripcion(Suscripcion suscripcion) {
        // Sincroniza cualquier modificamos que hayamos hecho de la persona en la BD
        em.merge(suscripcion);
    }

    @Override
    public void deteleteSuscripcion(Suscripcion suscripcion) {
        // 1. actualizamos el estado del objeto en la base de datos => se borra.
        em.remove(em.merge(suscripcion));
    }
}
