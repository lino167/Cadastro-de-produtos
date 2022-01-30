package dB;
import java.util.ArrayList;
import java.util.List;

import models.Usuario;

public class UsuariosDB {
    private static List<Usuario> usuarioList = new ArrayList<>();

    public static List<Usuario> getUsuariosList() {
        return usuarioList;
      
    }

  public static void addNovoUsuario(Usuario usuario) {
      int id = usuarioList.size() + 1;
    usuario.setId(id);
    usuarioList.add(usuario);
  }



}
