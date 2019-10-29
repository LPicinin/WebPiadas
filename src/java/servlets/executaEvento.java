/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Controladoras.CtrPiada;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Aluno
 */

@MultipartConfig()

@WebServlet(name = "executaEvento", urlPatterns =
{
    "/executaEvento"
})
public class executaEvento extends HttpServlet
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
            HttpSession s = request.getSession(false);
            if (s != null)
            {
                Enumeration<String> parameterNames = request.getParameterNames();
                
                String p;
                while((p = parameterNames.nextElement()) != null)
                {
                    System.out.println(p);
                }
                String acao = request.getParameter("evento");
                String result = "";
                switch (acao)
                {
                    case "atualizaTabela":
                        result = CtrPiada.getInstancia().getLinhasHTML();
                        out.print(result);
                        break;

                    case "inserePiada":
                        String titulo,palchave,texto;
                        int Codcategoria;
                        Part arq;
                        
                        titulo = request.getParameter("titulo");
                        palchave = request.getParameter("palavraChave");
                        texto = request.getParameter("texto");
                        Codcategoria = Integer.parseInt(request.getParameter("categoria"));
                        try
                        {
                            arq = request.getPart("arquivo");
                        } catch (Exception ex)
                        {
                            System.out.println(ex.getCause());
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case "deletaPiada":
                        int cod = Integer.parseInt(request.getParameter("cod"));
                        CtrPiada.getInstancia().delete(cod);
                        break;
                }

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

}
