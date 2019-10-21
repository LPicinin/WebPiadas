/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladoras;

import Entidades.Usuario;

/**
 *
 * @author Aluno
 */
public class CtrUsuario 
{
    private static CtrUsuario ctrUsuario;

    public static CtrUsuario getInstancia()
    {
        if(ctrUsuario == null)
            ctrUsuario = new CtrUsuario();
        return ctrUsuario;
    }
    public Object isValid(String usr, String pass)
    {
        return Usuario.isValid(usr, pass);
    }
}
