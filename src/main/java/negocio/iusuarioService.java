/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dominio.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jon
 */
@Local
public interface iusuarioService {

    public List<Usuario> listarPersonas();

    public Usuario encontrarPersonaPorID(Usuario usuario);

    public Usuario encontrarPersonaPorUsername(Usuario usuario);

    public void insertarUsuario(Usuario usuario);

    public void modificarUsuario(Usuario usuario);

    public void eliminarUsuario(Usuario usuario);

    public boolean comprobar(Usuario usuario);

    public String cifrarMD5(String input) throws Exception;
}
