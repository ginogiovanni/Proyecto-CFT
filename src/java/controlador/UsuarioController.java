/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import include.Usuario;
import java.util.ArrayList;
import modelo.ModeloUsuario;

/**
 *
 * @author Hawk
 */
public class UsuarioController {

    public boolean validar(Usuario u) {
        ModeloUsuario mu = new ModeloUsuario();
        return mu.autenticar(u);
    }
}
