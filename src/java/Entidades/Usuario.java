package Entidades;

import Entidades.Filtro;
import Entidades.abs.Entidade;
import banco.Banco;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuario extends Entidades.abs.Entidade
{

    protected String user;

    protected String pass;

    protected int nivel;

    public Usuario(String user, String pass, int nivel)
    {
        this.user = user;
        this.pass = pass;
        this.nivel = nivel;
    }

    public String getUser()
    {
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public String getPass()
    {
        return pass;
    }

    public int getNivel()
    {
        return nivel;
    }

    public void setNivel(int nivel)
    {
        this.nivel = nivel;
    }

    public static Usuario isValid(String usr, String pass)
    {
        Usuario u = null;
        String sql = "SELECT * FROM usuario WHERE login_user = '" + usr + "' AND pass_user = '" + pass + "'";
        System.out.println(sql);

        try
        {
            ResultSet rs = Banco.conectar().consultar(sql);
            Banco.desconectar();
            if (rs.next())
            {
                int i = rs.getInt("nivel");
                if (i == 0)
                {
                    u = new Moderador(rs.getString("login_user"), rs.getString("pass_user"));
                } else
                {
                    u = new Normal(rs.getString("login_user"), rs.getString("pass_user"));
                }
            }
        } catch (SQLException ex)
        {
            System.out.println(ex.getCause());
        }
        return u;
    }

    public void setPass(String pass)
    {
        this.pass = pass;
    }

    @Override
    protected String montaInsert()
    {
        return "insert into usuario(login_user, pass_user, nivel) values('" + user + "', '" + pass + "', " + nivel + ")";
    }

    @Override
    protected String montaUpdate()
    {
        return "update usuario set login_user='" + user + "', pass_user='" + pass + "', nivel=" + nivel;
    }

    @Override
    protected String montaDelete()
    {
        return "delete from usuario where login_user='" + user + "' AND pass_user='" + pass + "'";
    }

    @Override
    protected String montaSelect(Filtro... f)
    {
        return "select * from usuario";
    }

    @Override
    protected Entidade getIntancia(ResultSet rs)
    {
        try
        {
            if (rs.getInt("nivel") == 0)
            {
                return new Moderador(rs.getString("login_user"), rs.getString("pass_usr"));
            } else
            {
                return new Normal(rs.getString("login_user"), rs.getString("pass_usr"));
            }
        } catch (SQLException ex)
        {
            System.out.println("Erro classe Usuario" + ex.getMessage());
        }
        return null;
    }

}
