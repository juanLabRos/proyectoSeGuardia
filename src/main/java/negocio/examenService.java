/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.iexamenesDAO;
import dominio.Examen;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Jon
 */
@Stateless
public class examenService implements iexamenService {

    @Inject
    private iexamenesDAO examenesDAO;

    @Override
    public List<Examen> findAllExamen() {
        return examenesDAO.findAllExamen();
    }

    @Override
    public Examen buscarPorId(Examen examen) {
        return examenesDAO.findExamenById(examen);
    }

    @Override
    public Examen buscarPorNombre(Examen examen) {
        return examenesDAO.findExamenByName(examen);
    }

    @Override
    public Examen buscarPorTema(Examen examen) {
        return examenesDAO.findExamenByTema(examen);
    }

    @Override
    public void insertExamen(Examen examen) {
        examenesDAO.insertExamen(examen);
    }

    @Override
    public void updateExamen(Examen examen) {
        examenesDAO.updateExamen(examen);
    }

    @Override
    public void deleteExamen(Examen examen) {
        examenesDAO.deleteExamen(examen);
    }
    
     @Override
    public List<Examen> buscarExamen(Examen examen){
        List<Examen> exm = null;
        for (int i=0; i<findAllExamen().size();i++) {
            if (findAllExamen().get(i).getNombreExamen().toLowerCase().contains(examen.getNombreExamen().toLowerCase())){
                exm.add(findAllExamen().get(i));
            }
        }
        return exm;
    }

}
