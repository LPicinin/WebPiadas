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
import Utils.Util;
import Utils.Voto;
import banco.Banco;
import java.io.File;
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
            r.append(p.getPalChave()).append("</td><td>").append(p.getTexto().split(" ")[0]);
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

    public boolean delete(int cod, String path)
    {
        boolean flag = true;
        Piada p = new Piada(cod);
        flag = flag && p.delete();

        flag = flag && Util.deletImagem(cod, path);
        return flag;
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

    public boolean update(int cod, String titulo, String palchave, String texto, int Codcategoria, Usuario usr)
    {
        Piada p = new Piada(cod, 0, 0, 0, 0, titulo, texto, palchave, Date.valueOf(LocalDate.now()), new Categoria(Codcategoria), usr);
        return p.update();
    }

    private String votosSession(int codPiada)
    {
        String res;
        Voto v = new Voto(codPiada, false, false, false);
        if (Util.votosp != null && Util.votosp.contains(v))
        {
            int index = Util.votosp.indexOf(v);
            v = Util.votosp.get(index);
        }
        return geraPontuacao(v);
    }

    private String getCaminhoImagemPiada(int codPiada)
    {
        return "files/" + codPiada + ".png";
    }

    public String getGridPiadas(String filtro, int limit)
    {
        String html = "";
        Piada p = new Piada();
        List<Piada> piadas = p.getALLPiadasGrid(filtro, limit);
        if (piadas.size() > 0)
        {

            html = "<div class=\"row\">\n"
                    + "                <div class=\"col-md-8\">\n"
                    + "                    <div class=\"noticia_wrapper\">\n"
                    + "                        <span class=\"noticia_autor\">" + piadas.get(0).getUser().getUser() + "</span>\n"
                    + "                        <div class=\"imagemDiv\">"
                    + "                             <a href=\"piada?cod_piada=" + piadas.get(0).getCod() + "\" class=\"noticia_titulo\">" + piadas.get(0).getTitulo() + "</a>\n"
                    + "                             <img src=\"" + getCaminhoImagemPiada(piadas.get(0).getCod()) + "\" alt=\"Sem imagem\">"
                    + "                        </div>"
                    + "                         <span class=\"noticia_data\">" + piadas.get(0).getDt_cadastro().toString() + "</span>\n"
                    + "                        <br />\n"
                    + "                        <p class=\"noticia_resumo\">\n"
                    + piadas.get(0).getTexto().split(" ")[0]
                    + "                        </p>\n"
                    + "                        <div id=\"c" + piadas.get(0).getCod() + "\">\n"
                    + votosSession(piadas.get(0).getCod())
                    + "                         </div>"
                    + "                    </div>\n"
                    + "                </div>";

            if (piadas.size() > 1)
            {
                html += "\n"
                        + "                <div class=\"col-md-4\">\n"
                        + "                    <div class=\"noticia_wrapper\">\n"
                        + "                        <span class=\"noticia_autor\">" + piadas.get(1).getUser().getUser() + "</span>\n"
                        + "                         <div class=\"imagemDiv\">"
                        + "                        <a href=\"piada?cod_piada=" + piadas.get(1).getCod() + "\" class=\"noticia_titulo\">" + piadas.get(1).getTitulo() + "</a>\n"
                        + "                         <img src=\"" + getCaminhoImagemPiada(piadas.get(1).getCod()) + "\" alt=\"Sem imagem\">"
                        + "                         </div>"
                        + "                        <span class=\"noticia_data\">" + piadas.get(1).getDt_cadastro().toString() + "</span>\n"
                        + "                        <br />\n"
                        + "                        <p class=\"noticia_resumo\">\n"
                        + piadas.get(1).getTexto().split(" ")[0]
                        + "                        </p>"
                        + "                        <div id=\"c" + piadas.get(1).getCod() + "\">\n"
                        + votosSession(piadas.get(1).getCod())
                        + "                         </div>"
                        + "                    </div>\n"
                        + "                </div>";
            }
            html += "";
            for (int i = 2; i < piadas.size(); i++)
            {
                html += "<div class=\"col-md-4\">\n"
                        + "                    <div class=\"noticia_wrapper\">\n"
                        + "                        <span class=\"noticia_autor\">" + piadas.get(i).getUser().getUser() + "</span>\n"
                        + "                        <div class=\"imagemDiv\">"
                        + "                             <a href=\"piada?cod_piada=" + piadas.get(i).getCod() + "\" class=\"noticia_titulo\">" + piadas.get(i).getTitulo() + "</a>\n"
                        + "                             <img src=\"" + getCaminhoImagemPiada(piadas.get(i).getCod()) + "\" alt=\"Sem imagem\">"
                        + "                        </div>"
                        + "                         <span class=\"noticia_data\">" + piadas.get(i).getDt_cadastro().toString() + "</span>\n"
                        + "                        <br />\n"
                        + "                        <p class=\"noticia_resumo\">\n"
                        + piadas.get(i).getTexto().split(" ")[0]
                        + "                        </p>"
                        + "                        <div id=\"c" + piadas.get(i).getCod() + "\">\n"
                        + votosSession(piadas.get(i).getCod())
                        + "                         </div>"
                        + "                    </div>\n"
                        + "                </div>\n\n";
            }
            html += "</div>";
        } else
        {
            //sem piadas no banco
        }
        return html;
    }

    public void computaVoto(int cod, String nome, Voto v)
    {
        Piada p = new Piada(cod);
        p.autoComplete();
        switch (nome)
        {
            case "like":
                if (v.isLike())
                {
                    p.incLike();
                    if (v.isfCaso_especial())
                    {
                        p.decDeslike();
                    }
                } else
                {
                    p.decLike();
                }
                break;
            case "deslike":
                if (v.isDeslike())
                {
                    p.incDeslike();
                    if (v.isfCaso_especial())
                    {
                        p.decLike();
                    }
                } else
                {
                    p.decDeslike();
                }
                break;
            case "angry":
                if (v.isGrr())
                {
                    p.incGrr();
                } else
                {
                    p.decGrr();
                }
                break;
        }
    }

    public String geraPontuacao(Voto v_on)
    {
        Piada p = new Piada(v_on.getCod_piada());
        p.autoComplete();
        return "<img src=\"Icons/angry" + ((!v_on.isGrr()) ? "_un" : "") + ".png\" onclick=\"IncReaction('angry', " + v_on.getCod_piada() + ")\" alt=\"\">\n"
                + "                             <label>" + p.getGrr() + "</label>\n"
                + "<img src=\"Icons/like" + ((!v_on.isLike()) ? "_un" : "") + ".png\" onclick=\"IncReaction('like', " + v_on.getCod_piada() + ")\" alt=\"\">\n"
                + "                             <label>" + p.getLike() + "</label>\n"
                + "<img src=\"Icons/deslike" + ((!v_on.isDeslike()) ? "_un" : "") + ".png\" onclick=\"IncReaction('deslike', " + v_on.getCod_piada() + ")\" alt=\"\">"
                + "                             <label>" + p.getDesLike() + "</label>\n";
    }
}
