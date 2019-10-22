/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades.abs;

import Entidades.Filtro;
import banco.Banco;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aluno
 */
public abstract class Entidade
{

    public final boolean insert()
    {
        boolean result;
        String sql = montaInsert();
        
        result = Banco.conectar().manipular(sql);
        Banco.desconectar();
        
        return result;
    }

    public final boolean update()
    {
        boolean result;
        String sql = montaUpdate();
        
        result = Banco.conectar().manipular(sql);
        Banco.desconectar();
        
        return result;
    }

    public final boolean delete()
    {
        boolean result;
        String sql = montaDelete();
        
        result = Banco.conectar().manipular(sql);
        Banco.desconectar();
        
        return result;
    }

    public final List<Entidade> select(Filtro ...f)
    {
        List<Entidade> l = new ArrayList<>();
        String sql = montaSelect(f)+" ";
        for (Filtro filtro : f)
        {
            if (f[0] != filtro)
            {
                sql += ",";
            }
            sql += " " + filtro.getColuna() + "=" + filtro.getChave();
        }
        ResultSet rs = Banco.conectar().consultar(sql);
        Banco.desconectar();
        try
        {
            while (rs.next())
            {
                l.add(getIntancia(rs));
            }
        } catch (SQLException ex)
        {

        }
        return l;
    }

    protected abstract String montaInsert();

    protected abstract String montaUpdate();

    protected abstract String montaDelete();

    protected abstract String montaSelect(Filtro ...f);

    protected abstract Entidade getIntancia(ResultSet rs);
}
