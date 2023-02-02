/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Examen;
import java.util.List;

/**
 *
 * @author Jon
 */
public interface iexamenesDAO {

    public List<Examen> findAllExamen();

    public Examen findExamenById(Examen examen);

    public Examen findExamenByName(Examen examen);

    public Examen findExamenByTema(Examen examen);

    public void insertExamen(Examen examen);

    public void updateExamen(Examen examen);

    public void deleteExamen(Examen examen);
    
}
