package Entidades;

import Entidades.abs.Entidade;
import java.sql.ResultSet;

public class Moderador extends Usuario
{

    public Moderador(String user, String pass)
    {
        super(user, pass, 0);
    }
    
    @Override
    protected Entidade getIntancia(ResultSet rs)
    {
        return super.getIntancia(rs); //To change body of generated methods, choose Tools | Templates.
    }
}
