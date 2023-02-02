/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dominio.Examen;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jon
 */
@Local
public interface iexamenService {

    public List<Examen> findAllExamen();

    public Examen buscarPorId(Examen examen);

    public Examen buscarPorNombre(Examen examen);

    public Examen buscarPorTema(Examen examen);

    public void insertExamen(Examen examen);

    public void updateExamen(Examen examen);

    public void deleteExamen(Examen examen);
    
    public List<Examen> buscarExamen(Examen examen);
    
}
