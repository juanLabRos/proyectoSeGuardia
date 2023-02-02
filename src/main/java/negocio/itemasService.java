/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dominio.Temas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jon
 */
@Local
public interface itemasService {

    public List<Temas> findAllTemas();

    public Temas buscarPorID(Temas tema);

    public Temas buscarPorNombre(Temas tema);

    public void insertTema(Temas tema);

    public void updateTema(Temas tema);

    public void deleteTema(Temas tema);
    
}
