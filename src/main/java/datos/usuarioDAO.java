/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jon
 */
public class usuarioDAO implements iusuarioDAO {
    
      // El EJB se encarga de forma automática de hacer las transacciones.

    // Ahora inyectamos la unidad de persistencia a través del API de JPA
    // Simplemente tenemos que usar la anotación e indicar el nombre de nuestra
    // unidad de persistencia
    @PersistenceContext(unitName = "pu")
    EntityManager em;

    // Con este objeto de em ya podemos interactuar con nuestra BD
    @Override
    public List <Usuario> findAllUsuarios() {
        // Creamos un NamedQuery, y el listado lo leemos con getResultList
        // Por lo que estamos escribiendo menos código
        return em.createNamedQuery("Usuarios.findAll").getResultList();
    }

    @Override
    public Usuario findUsuarioByID(Usuario usuario) {
        // Especificamos la clase que queremos buscar y luego el campo por el 
        // que queremos buscar
        return em.find(Usuario.class, usuario.getIdusuario());
    }

    @Override
    public Usuario findUsuarioByUsername(Usuario usuario) {
        // En este caso no vamos a usar un NamedQuery, que podríamos haber 
        // agregado en la Entidad de Usuario sino que vamos a incluirlo directamente.
        Query query = em.createNamedQuery("Usuario.findByUsername");
        query.setParameter("nombreUsuario", usuario.getNombreUsuario());
        return (Usuario) query.getSingleResult();
    }
    
    @Override
    public Usuario findUsuarioByEmail (Usuario usuario){
        Query query = em.createNamedQuery("Usuario.findByEmail");
        query.setParameter("email", usuario.getEmail());
        return(Usuario) query.getSingleResult();
    }

    @Override
    public void insertUsuario(Usuario usuario) {
        em.persist(usuario);
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        // Sincroniza cualquier modificamos que hayamos hecho de la persona en la BD
        em.merge(usuario);
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        // 1. actualizamos el estado del objeto en la base de datos => se borra.
        em.remove(em.merge(usuario));
    }
    
}
