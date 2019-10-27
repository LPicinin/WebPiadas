/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Controladoras.CtrUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luish
 */
@WebServlet(name = "executaEventoUsuario", urlPatterns =
{
    "/executaEventoUsuario"
})
@MultipartConfig
public class executaEventoUsuario extends HttpServlet
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
            boolean flag = false;
            String usr = request.getParameter("usr");
            String p = request.getParameter("pass");
            int n = Integer.parseInt((String) request.getParameter("nivel"));
            if (valida(usr, p, n))
            {
                flag = (CtrUsuario.getInstancia().insert(usr, p, n));
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                out.print("<div class=\"alert alert-danger\" role=\"alert\">\n"
                        + "Falha ao Cadastrar Usuário!\n"
                        + "</div>");
            } else
            {
                out.print("<div class=\"alert alert-success\" role=\"alert\">\n"
                        + "Cadastro Bem Sucedido!\n"
                        + "</div>");
            }
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

    private boolean valida(String usr, String p, int n)
    {
        return (!usr.isEmpty() && !p.isEmpty() && (n == 0 || n == 1));
    }

}
