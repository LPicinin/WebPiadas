/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Controladoras.CtrPiada;
import Utils.Util;
import Utils.Voto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Aluno
 */
@WebServlet(name = "executareaction", urlPatterns =
{
    "/executareaction"
})
public class executareaction extends HttpServlet
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            HttpSession s = request.getSession(true);
            Integer index_v_on = null;
            ArrayList<Voto> votos = (ArrayList<Voto>) s.getAttribute("votacao");
            if (votos == null)
            {
                votos = new ArrayList<>();
            }
            String res = "";

            String nome = request.getParameter("atr");
            int cod = Integer.parseInt(request.getParameter("cod"));

            Voto nv = new Voto(cod, nome.equals("like"), nome.equals("deslike"), nome.equals("angry"));
            Voto v_on;
            if (votos.contains(nv))
            {
                index_v_on = votos.indexOf(nv);
                v_on = votos.get(index_v_on);
                v_on.setfCaso_especial(false);
                switch (nome)
                {
                    case "like":
                        v_on.neglike();
                        break;
                    case "deslike":
                        v_on.negDeslike();
                        break;
                    case "angry":
                        v_on.negGrr();
                        break;
                }
            } else
            {
                v_on = nv;
            }
            CtrPiada.getInstancia().computaVoto(cod, nome, v_on);
            if (index_v_on == null)
            {
                votos.add(nv);
            } else
            {
                votos.set(index_v_on, v_on);
            }
            res = CtrPiada.getInstancia().geraPontuacao(v_on);
            /*res = "<img src=\"Icons/angry" + ((!v_on.isGrr()) ? "_un" : "") + ".png\" onclick=\"IncReaction('angry', "+cod+")\" alt=\"\">\n"
                    + "<img src=\"Icons/like" + ((!v_on.isLike()) ? "_un" : "") + ".png\" onclick=\"IncReaction('like', "+cod+")\" alt=\"\">\n"
                    + "<img src=\"Icons/deslike" + ((!v_on.isDeslike()) ? "_un" : "") + ".png\" onclick=\"IncReaction('deslike', "+cod+")\" alt=\"\">";*/
            s.setAttribute("votacao", votos);
            Util.votosp = votos;
            out.println(res);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
