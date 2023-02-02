/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.suscripcionDAO;
import dominio.Suscripcion;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Jon
 */
@Stateless
public class suscripcionService implements isuscripcionService {

    @Inject
    private suscripcionDAO suscripcionDAO;

    @Override
    public List<Suscripcion> findAllSuscripcion() {
        return suscripcionDAO.findAllSuscripcion();
    }

    @Override
    public Suscripcion encontrarSuscripcionPorId(Suscripcion suscripcion) {
        return suscripcionDAO.findSuscripcionById(suscripcion);
    }

    @Override
    public Suscripcion encontrarSuscripcionPorFechaInicio(Suscripcion suscripcion) {
        return suscripcionDAO.findSuscripcionByFechaInicio(suscripcion);
    }
    
    @Override
    public Suscripcion encontrarSuscripcionPorPrecio(Suscripcion suscripcion){
        return suscripcionDAO.findSuscripcionByPrecio(suscripcion);
    }

    @Override
    public Suscripcion encontrarSescripcionPorFechaFin(Suscripcion suscripcion) {
        return suscripcionDAO.findSuscripcionByFechaFin(suscripcion);
    }

    @Override
    public Suscripcion enoncontrarUsuarioPorId(Suscripcion suscripcion) {
        return suscripcionDAO.findsuscrpcionByIdUsuario(suscripcion);
    }

    @Override
    public void insertSuscripcion(Suscripcion suscripcion) {
        suscripcionDAO.insertSuscripcion(suscripcion);
    }

    @Override
    public void updateSuscripcion(Suscripcion suscripcion) {
        suscripcionDAO.updateSuscripcion(suscripcion);
    }

    @Override
    public void deleteSuscripcion(Suscripcion suscripcion) {
        suscripcionDAO.deteleteSuscripcion(suscripcion);
    }

}
