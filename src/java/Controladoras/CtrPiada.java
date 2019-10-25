/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladoras;

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
            /*
            r.append("<tr>"
                    + "<td>"+p.getCod()+"</td>"
                    + "<td>"+p.getCat().toString()+"</td>"
                    + "<td>"+p.getTitulo()+"</td>"
                    + "<td>"+p.getPalChave()+"</td>"
                    + "<td>"+p.getTexto().substring(0, 25)+"</td>"
                    + "<td>"
                    + "<img src=\"images/iconfinder_edit-paste_118923.svg\" onclick=\"editarPiada(this)\"/>"
                    + "<img src=\"images/iconfinder_edit-delete_118920.svg\" onclick=\"deletePiada("+p.getCod()+")\"/>"
                    + "</td>"
                    + "</tr>");
            */
            //deixar assim depois de modificar(fica muito mais rápido e com menos memória)
            r.append("<tr><td>").append(p.getCod()).append("</td><td>").append(p.getCat().toString()).append("</td><td>").append(p.getTitulo()).append("</td><td>").append(p.getPalChave()).append("</td><td>").append(p.getTexto().substring(0, 25)).append("</td><td><img src=\"images/iconfinder_edit-paste_118923.svg\" class=\"image_tabela\" onclick=\"editarPiada(this)\"/><img src=\"images/iconfinder_edit-delete_118920.svg\" class=\"image_tabela\" onclick=\"deletePiada(").append(p.getCod()).append(")\"/></td></tr>");
        }
        return r.toString();
    }
}
