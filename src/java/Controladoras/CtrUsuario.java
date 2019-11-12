/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladoras;

import Entidades.Moderador;
import Entidades.Normal;
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
        if (ctrUsuario == null)
        {
            ctrUsuario = new CtrUsuario();
        }
        return ctrUsuario;
    }

    public Object isValid(String usr, String pass)
    {
        return Usuario.isValid(usr, pass);
    }

    public boolean insert(String usr, String p, int n)
    {
        Usuario u;
        if (n == 0)
        {
            u = new Moderador(usr, p);
        } else
        {
            u = new Normal(usr, p);
        }
        return u.insert();
    }
    public boolean update(String usr, String p, int n)
    {
        Usuario u;
        if (n == 0)
        {
            u = new Moderador(usr, p);
        } else
        {
            u = new Normal(usr, p);
        }
        return u.update();
    }
    public boolean delete(String usr, String p, int n)
    {
        Usuario u;
        if (n == 0)
        {
            u = new Moderador(usr, p);
        } else
        {
            u = new Normal(usr, p);
        }
        return u.delete();
    }
}
