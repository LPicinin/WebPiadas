/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades.abs;

import Entidades.Filtro;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import trabalhofxferro2.banco.Banco;

/**
 *
 * @author Aluno
 */
public abstract class Entidade
{

    public final boolean insert()
    {
        String sql = montaInsert();
        return Banco.getCon().manipular(sql);
    }

    public final boolean update()
    {
        String sql = montaUpdate();
        return Banco.getCon().manipular(sql);
    }

    public final boolean delete()
    {
        String sql = montaDelete();
        return Banco.getCon().manipular(sql);
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
        ResultSet rs = Banco.getCon().consultar(sql);
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
