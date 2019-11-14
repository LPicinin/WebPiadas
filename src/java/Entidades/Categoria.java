package Entidades;

import Entidades.abs.Entidade;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

    public Categoria(int cod)
    {
        Filtro f = new Filtro("categoria", "cod_cat", Integer.toString(cod));
        List<Entidade> r = this.select();
        if(r.size() > 0)
        {
            Categoria c = (Categoria) r.get(0);
            this.cod = c.getCod();
            this.nome = c.getNome();
            this.desc = c.getDesc();
        }
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
        if (f.length > 0)
        {
            sql += " where ";
            for (Filtro filtro : f)
            {
                sql += filtro.getColuna() + "=" + filtro.getChave();
            }
        }
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

    public int getCod()
    {
        return cod;
    }

    public void setCod(int cod)
    {
        this.cod = cod;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    @Override
    public String toString()
    {
        return "["+ cod + "] - " + nome;
    }

    @Override
    public void autoComplete()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
