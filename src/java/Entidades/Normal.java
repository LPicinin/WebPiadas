package Entidades;

import Entidades.abs.Entidade;
import java.sql.ResultSet;

public class Normal extends Usuario
{

    public Normal(String user, String pass)
    {
        super(user, pass, 1);
    }

    @Override
    protected Entidade getIntancia(ResultSet rs)
    {
        return super.getIntancia(rs); //To change body of generated methods, choose Tools | Templates.
    }
    
}
