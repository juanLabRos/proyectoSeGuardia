/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.iusuarioDAO;
import dominio.Usuario;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Jon
 */
@Stateless
public class usuarioService implements iusuarioService {
    @Inject    
    private iusuarioDAO usuarioDAO;
    
     @Override
    public List<Usuario> listarPersonas() {       
        return usuarioDAO.findAllUsuarios();
    }

    @Override
    public Usuario encontrarPersonaPorID(Usuario usuario) {
        return usuarioDAO.findUsuarioByID(usuario);
    }

    @Override
    public Usuario encontrarPersonaPorUsername(Usuario usuario) {
        return usuarioDAO.findUsuarioByUsername(usuario);
    }

    @Override
    public void insertarUsuario(Usuario usuario) {
        usuarioDAO.insertUsuario(usuario);
    }

    @Override
    public void modificarUsuario(Usuario usuario) {
        usuarioDAO.updateUsuario(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        usuarioDAO.deleteUsuario(usuario);
    }
     @Override
    public boolean comprobar(Usuario usuario){
        int num = this.usuarioDAO.findAllUsuarios().size();     
        for (int i = 0; i < num; i++) {
            if(this.usuarioDAO.findAllUsuarios().get(i).getNombre().equalsIgnoreCase(usuario.getNombreUsuario()) && 
                    this.usuarioDAO.findAllUsuarios().get(i).getPassword().equalsIgnoreCase(usuario.getPassword())){
                return true;
            }
        }
    return false;  
    }
    
    //Cifrado de contraseñas
    @Override
    public String cifrarMD5(String input) throws Exception {
        String md5 = null;
        if (null == input)
            return null;
        // Create MessageDigest object for MD5
        MessageDigest digest = MessageDigest.getInstance("MD5");
        // Update input string in message digest
        digest.update(input.getBytes(), 0, input.length());
        // Converts message digest value in base 16 (hex)
        md5 = new BigInteger(1, digest.digest()).toString(16);
        
        return md5;
    }
}
