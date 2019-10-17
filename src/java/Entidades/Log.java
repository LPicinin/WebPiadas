package Entidades;

import Entidades.abs.Entidade;
import java.sql.ResultSet;

public class Log  extends Entidades.abs.Entidade
{

    private String ip;

    private String browser;

    @Override
    protected java.lang.String montaInsert()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected java.lang.String montaUpdate()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected java.lang.String montaDelete()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected java.lang.String montaSelect(Filtro ...f)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Entidade getIntancia(ResultSet rs)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
