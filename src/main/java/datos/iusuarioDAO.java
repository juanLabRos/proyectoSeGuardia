/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Usuario;
import java.util.List;

/**
 *
 * @author Jon
 */
public interface iusuarioDAO {

    public List<Usuario> findAllUsuarios();

    public Usuario findUsuarioByID(Usuario usuario);

    public Usuario findUsuarioByUsername(Usuario usuario);

    public Usuario findUsuarioByEmail(Usuario usuario);

    public void insertUsuario(Usuario usuario);

    public void updateUsuario(Usuario usuario);

    public void deleteUsuario(Usuario usuario);
}
