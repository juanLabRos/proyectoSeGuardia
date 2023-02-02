/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Temas;
import java.util.List;

/**
 *
 * @author Jon
 */
public interface itemasDAO {

    public List<Temas> findAllTemas();

    public Temas findTemasById(Temas temas);

    public Temas findTemaByName(Temas temas);

    public void insertTema(Temas tema);

    public void updateTema(Temas tema);

    public void deleteTema(Temas tema);

}
