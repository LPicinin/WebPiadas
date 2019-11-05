/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladoras;

import Entidades.Categoria;
import Entidades.Filtro;
import Entidades.Piada;
import Entidades.Usuario;
import Entidades.abs.Entidade;
import banco.Banco;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class CtrPiada
{

    private static CtrPiada ctrPiada;

    private CtrPiada()
    {
    }

    public static CtrPiada getInstancia()
    {
        if (ctrPiada == null)
        {
            ctrPiada = new CtrPiada();
        }
        return ctrPiada;
    }

    private List<Piada> get(Filtro... f)
    {
        List<Entidade> select = new Piada().select(f);
        List<Piada> res = new ArrayList<>();
        for (Entidade ent : select)
        {
            res.add((Piada) ent);
        }
        return res;
    }

    public String getLinhasHTML(Filtro... f)
    {
        List<Piada> ps = get(f);
        StringBuilder r = new StringBuilder("");
        for (Piada p : ps)
        {

            r.append("<tr id=\"" + p.getCod() + "#"
                    + p.getCat().getCod() + "#"
                    + p.getTitulo() + "#"
                    + p.getPalChave() + "#"
                    + p.getTexto() + "#"
                    + "\"><td>");
            r.append(p.getCod());
            r.append("</td><td>").append(p.getCat().toString());
            r.append("</td><td>").append(p.getTitulo()).append("</td><td>");
            r.append(p.getPalChave()).append("</td><td>").append(p.getTexto()
                    .substring(0, p.getTexto().length()/7));
            r.append("</td><td onclick=\"editarPiada(this)\"><img src=\"images/iconfinder_edit-paste_118923.svg\" class=\"image_tabela\"/></td><td onclick=\"deletePiada(");
            r.append(p.getCod()).append(")\"><img src=\"images/iconfinder_edit-delete_118920.svg\" class=\"image_tabela\"/></td></tr>");
        }
        return r.toString();
    }

    public String getCategorias_html()
    {
        String res = "";

        Categoria c = new Categoria("", "");
        List<Entidade> cats = c.select();
        for (Entidade cat : cats)
        {
            c = (Categoria) cat;
            res += "<option value=\"" + c.getCod() + "\">" + c.getNome() + "</option>\n";
        }
        return res;
    }

    public void delete(int cod)
    {
        Piada p = new Piada(cod);
        p.delete();
    }

    public boolean insert(String titulo, String palchave, String texto, int Codcategoria, Usuario user)
    {
        Piada p = new Piada(0, 0, 0, 0, titulo, texto, palchave, Date.valueOf(LocalDate.now()), new Categoria(Codcategoria), user);
        return p.insert();
    }

    public String getCodigoUltimaPiada()
    {
        Integer pk = Banco.conectar().getMaxPK("piada", "cod");
        Banco.desconectar();
        return pk.toString();
    }
}
