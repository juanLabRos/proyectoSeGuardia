/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dominio.Suscripcion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jon
 */
@Local
public interface isuscripcionService {

    public List<Suscripcion> findAllSuscripcion();

    public Suscripcion encontrarSuscripcionPorId(Suscripcion suscripcion);

    public Suscripcion encontrarSuscripcionPorFechaInicio(Suscripcion suscripcion);

    public Suscripcion encontrarSescripcionPorFechaFin(Suscripcion suscripcion);
    
    public Suscripcion encontrarSuscripcionPorPrecio(Suscripcion suscripcion);

    public Suscripcion enoncontrarUsuarioPorId(Suscripcion suscripcion);

    public void insertSuscripcion(Suscripcion suscripcion);

    public void updateSuscripcion(Suscripcion suscripcion);

    public void deleteSuscripcion(Suscripcion suscripcion);
   
}
