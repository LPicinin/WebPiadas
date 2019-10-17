package Entidades;

import Entidades.abs.Entidade;
import java.sql.ResultSet;

public class Categoria extends Entidades.abs.Entidade
{

    private int cod;

    private String nome;

    private String desc;

    @Override
    protected java.lang.String montaInsert()
    {
        return "INSERT INTO categoria() VALUES("+")";
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
    protected java.lang.String montaSelect(Filtro f)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Entidade getIntancia(ResultSet rs)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
