/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladoras;

import Entidades.Categoria;
import Entidades.Filtro;
import Entidades.Piada;
import Entidades.abs.Entidade;
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
        String linha;
        for (Piada p : ps)
        {
            r.append("<tr id=\"" + p.getCod() + "#"
                    + p.getCat().getCod() + "#"
                    + p.getTitulo() + "#"
                    + p.getPalChave() + "#"
                    + p.getTexto() + "#"
                    + "\"><td>").append(p.getCod()).append("</td><td>").append(p.getCat().toString()).append("</td><td>").append(p.getTitulo()).append("</td><td>").append(p.getPalChave()).append("</td><td>").append(p.getTexto().substring(0, 25)).append("</td><td onclick=\"editarPiada(this)\"><img src=\"images/iconfinder_edit-paste_118923.svg\" class=\"image_tabela\"/></td><td onclick=\"deletePiada(").append(p.getCod()).append(")\"><img src=\"images/iconfinder_edit-delete_118920.svg\" class=\"image_tabela\"/></td></tr>");
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
}
