/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Suscripcion;
import java.util.List;

/**
 *
 * @author Jon
 */
public interface isuscripcionDAO {

    public List<Suscripcion> findAllSuscripcion();

    public Suscripcion findSuscripcionById(Suscripcion suscripcion);

    public Suscripcion findSuscripcionByFechaInicio(Suscripcion suscripcion);

    public Suscripcion findSuscripcionByFechaFin(Suscripcion suscripcion);
    
    public Suscripcion findSuscripcionByPrecio(Suscripcion suscripcion);

    public Suscripcion findsuscrpcionByIdUsuario(Suscripcion suscripcion);

    public void insertSuscripcion(Suscripcion suscripcion);

    public void updateSuscripcion(Suscripcion suscripcion);

    public void deteleteSuscripcion(Suscripcion suscripcion);
           
            
            
}
