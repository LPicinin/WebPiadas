/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

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

            ArrayList<Voto> votos = (ArrayList<Voto>) s.getAttribute("votacao");
            if (votos == null)
                votos = new ArrayList<>();
            String res = "";

            String nome = request.getParameter("atr");
            int cod = Integer.parseInt(request.getParameter("cod"));

            Voto nv = new Voto(cod, nome.equals("like"), nome.equals("deslike"), nome.equals("grr"));
            Voto v_on;
            if (votos.contains(nv))
            {
                int index_v_on = votos.indexOf(nv);
                v_on = votos.get(index_v_on);
                switch (nome)
                {
                    case "like":
                        v_on.neglike();
                        break;
                    case "delike":
                        v_on.negDeslike();
                        break;
                    case "grr":
                        v_on.negGrr();
                        break;
                }
                votos.set(index_v_on, v_on);
            }
            else
            {
                v_on = nv;
                votos.add(nv);
            }
            Util.votosp = votos;
            res = "<img src=\"Icons/angry"+((v_on.isGrr())? "_un" : "")+".png\" onclick=\"IncReaction('angry', 2)\" alt=\"\">\n"
                    + "<img src=\"Icons/like_un.png\" onclick=\"IncReaction('like', 2)\" alt=\"\">\n"
                    + "<img src=\"Icons/deslike_un.png\" onclick=\"IncReaction('deslike', 2)\" alt=\"\">";
            s.setAttribute("votacao", votos);
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
