package Entidades;

import Entidades.abs.Entidade;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Categoria extends Entidades.abs.Entidade
{

    private int cod;

    private String nome;

    private String desc;

    public Categoria(String nome, String desc)
    {
        this.nome = nome;
        this.desc = desc;
    }

    public Categoria(int cod, String nome, String desc)
    {
        this.cod = cod;
        this.nome = nome;
        this.desc = desc;
    }

    @Override
    protected java.lang.String montaInsert()
    {
        return "INSERT INTO categoria(nome_cat, descr_cat) VALUES(" + nome + ", " + desc + ")";
    }

    @Override
    protected java.lang.String montaUpdate()
    {
        return "UPDATE categoria SET nome_cat='" + nome + "', descr_cat = '" + desc + "' WHERE cod_cat=" + cod;
    }

    @Override
    protected java.lang.String montaDelete()
    {
        return "DELETE FROM categoria WHERE cod_cat=" + cod;
    }

    @Override
    protected java.lang.String montaSelect(Filtro... f)
    {
        String sql = "SELECT * FROM categoria";
        return sql;
    }

    @Override
    protected Entidade getIntancia(ResultSet rs)
    {
        try
        {
            return new Categoria(rs.getInt("cod_cat"), rs.getString("nome_cat"), rs.getString("descr_cat"));
        } catch (SQLException ex)
        {
            System.out.println("Erro classe Usuario" + ex.getMessage());
        }
        return null;
    }

}
