package Entidades;

import Controladoras.CtrUsuario;
import Entidades.abs.Entidade;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    private Categoria cat;

    private Usuario user;

    public Piada()
    {
    }

    public Piada(int cod, int like, int desLike, int grr, int pontuacao, String titulo, String texto, String palChave, Date dt_cadastro, Categoria cat, Usuario user)
    {
        this.cod = cod;
        this.like = like;
        this.desLike = desLike;
        this.grr = grr;
        this.pontuacao = pontuacao;
        this.titulo = titulo;
        this.texto = texto;
        this.palChave = palChave;
        this.dt_cadastro = dt_cadastro;
        this.cat = cat;
        this.user = user;
    }

    public Piada(int like, int desLike, int grr, int pontuacao, String titulo, String texto, String palChave, Date dt_cadastro, Categoria cat, Usuario user)
    {
        this.like = like;
        this.desLike = desLike;
        this.grr = grr;
        this.pontuacao = pontuacao;
        this.titulo = titulo;
        this.texto = texto;
        this.palChave = palChave;
        this.dt_cadastro = dt_cadastro;
        this.cat = cat;
        this.user = user;
    }

    public Piada(int cod)
    {
        this.cod = cod;
    }

    public int getCod()
    {
        return cod;
    }

    public void setCod(int cod)
    {
        this.cod = cod;
    }

    public int getLike()
    {
        return like;
    }

    public void setLike(int like)
    {
        this.like = like;
    }

    public int getDesLike()
    {
        return desLike;
    }

    public void setDesLike(int desLike)
    {
        this.desLike = desLike;
    }

    public int getGrr()
    {
        return grr;
    }

    public void setGrr(int grr)
    {
        this.grr = grr;
    }

    public int getPontuacao()
    {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao)
    {
        this.pontuacao = pontuacao;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

    public String getTexto()
    {
        return texto;
    }

    public void setTexto(String texto)
    {
        this.texto = texto;
    }

    public String getPalChave()
    {
        return palChave;
    }

    public void setPalChave(String palChave)
    {
        this.palChave = palChave;
    }

    public Date getDt_cadastro()
    {
        return dt_cadastro;
    }

    public void setDt_cadastro(Date dt_cadastro)
    {
        this.dt_cadastro = dt_cadastro;
    }

    public Categoria getCat()
    {
        return cat;
    }

    public void setCat(Categoria cat)
    {
        this.cat = cat;
    }

    public Usuario getUser()
    {
        return user;
    }

    public void setUser(Usuario user)
    {
        this.user = user;
    }

    @Override
    protected java.lang.String montaInsert()
    {

        String SQL = "INSERT INTO piada(cod_cat, like_piada, deslike_piada, titulo_piada, palchave_piada, pontuacao_piada, "
                + "texto_piada, datacad_piada, grr_piada, pass_user, login_user) "
                + "VALUES (@2, @3, @4, '@5', '@6', @7, '@8', '@9', @10, '@11', '@12')";
        SQL = SQL.replace("@10", "" + grr);
        SQL = SQL.replace("@11", "" + user.getUser());
        SQL = SQL.replace("@12", "" + user.getPass());
        SQL = SQL.replace("@2", "" + cat.getCod());
        SQL = SQL.replace("@3", "" + like);
        SQL = SQL.replace("@4", "" + desLike);
        SQL = SQL.replace("@5", "" + titulo);
        SQL = SQL.replace("@6", palChave);
        SQL = SQL.replace("@7", "" + pontuacao);
        SQL = SQL.replace("@8", texto);
        SQL = SQL.replace("@9", dt_cadastro.toString());

        return SQL;

    }

    @Override
    protected java.lang.String montaUpdate()
    {
        String SQL = "UPDATE piada SET cod_cat=@2, like_piada=@3, deslike_piada=@4, titulo_piada=@5, palchave_piada=@6, "
                + "pontuacao_piada=@7, texto_piada=@8, datacad_piada=@9, grr_piada=@10, pass_user=@11, login_user=@12"
                + " WHERE cod = @1";

        SQL = SQL.replace("@1", "" + cod);
        SQL = SQL.replace("@2", "" + cat.getCod());
        SQL = SQL.replace("@3", "" + like);
        SQL = SQL.replace("@4", "" + desLike);
        SQL = SQL.replace("@5", "" + titulo);
        SQL = SQL.replace("@6", palChave);
        SQL = SQL.replace("@7", "" + pontuacao);
        SQL = SQL.replace("@8", texto);
        SQL = SQL.replace("@9", dt_cadastro.toString());
        SQL = SQL.replace("@10", "" + grr);
        SQL = SQL.replace("@11", "" + user.getUser());
        SQL = SQL.replace("@12", "" + user.getPass());

        return SQL;
    }

    @Override
    protected java.lang.String montaDelete()
    {
        return "DELETE FROM piada where cod =" + cod;
    }

    @Override
    protected java.lang.String montaSelect(Filtro... f)
    {
        String SQL = "select *from piada";
        if (f.length > 0)
        {
            for (Filtro filtro : f)
            {
                SQL += filtro.getColuna() + "=" + filtro.getChave();
            }
        }
        return SQL;
    }

    @Override
    protected Entidade getIntancia(ResultSet rs)
    {
        try
        {
            return new Piada(rs.getInt("cod"), rs.getInt("like_piada"), rs.getInt("deslike_piada"), rs.getInt("grr_piada"), rs.getInt("pontuacao_piada"),
                    rs.getString("titulo_piada"), rs.getString("texto_piada"), rs.getString("texto_piada"), rs.getDate("datacad_piada"), new Categoria(rs.getInt("cod_cat")), (Usuario) CtrUsuario.getInstancia().isValid(rs.getString("login_user"), rs.getString("pass_user")));
        } catch (SQLException ex)
        {
            return null;
        }

    }

}
