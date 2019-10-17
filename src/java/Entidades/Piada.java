package Entidades;

import Entidades.abs.Entidade;
import java.sql.Date;
import java.sql.ResultSet;

public class Piada extends Entidades.abs.Entidade
{

    private int cod;

    private int like;

    private int desLike;

    private int grr;

    private int pontuacao;

    private String titulo;

    private String texto;

    private String palChave;

    private Date dt_cadastro;

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
