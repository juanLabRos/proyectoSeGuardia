/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.itemasDAO;
import dominio.Temas;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Jon
 */
@Stateless
public class temasService implements itemasService {

    @Inject
    private itemasDAO temasDAO;

    @Override
    public List<Temas> findAllTemas() {
        return temasDAO.findAllTemas();
    }

    @Override
    public Temas buscarPorID(Temas tema) {
        return temasDAO.findTemasById(tema);
    }

    @Override
    public Temas buscarPorNombre(Temas tema) {
        return temasDAO.findTemaByName(tema);
    }

    @Override
    public void insertTema(Temas tema) {
        temasDAO.insertTema(tema);
    }

    @Override
    public void updateTema(Temas tema) {
        temasDAO.updateTema(tema);
    }

    @Override
    public void deleteTema(Temas tema) {
        temasDAO.deleteTema(tema);
    }
}
