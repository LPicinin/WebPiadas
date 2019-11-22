/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Controladoras.CtrPiada;
import Entidades.Filtro;
import Entidades.Usuario;
import Utils.Util;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.Instant;
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
@MultipartConfig(
        location = "/",
        fileSizeThreshold = 1024 * 1024, // 1MB *      
        maxFileSize = 1024 * 1024 * 100, // 100MB **
        maxRequestSize = 1024 * 1024 * 10 * 10 // 100MB ***
)

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
            if(Util.pathServidor == null)
            {
                Util.pathServidor = this.getServletContext().getRealPath("/files") + "/";
            }
            boolean b = false;
            HttpSession s = request.getSession(false);
            Usuario usr;
            String acao;
            if (s != null && (usr = (Usuario) s.getAttribute("user")) != null)
            {
                acao = request.getParameter("evento");
                String codigo = request.getParameter("cod");
                String result = "";
                if (acao != null && acao.equals("atualizaGridPiada"))
                {
                    acao = request.getParameter("evento");
                    String filtro = request.getParameter("busca");
                    result = CtrPiada.getInstancia().getGridPiadas(filtro, 10);

                } else if (acao != null && acao.equals("deletaPiada"))//exclui tabela
                {
                    int cod = Integer.parseInt(request.getParameter("cod"));
                    CtrPiada.getInstancia().delete(cod, this.getServletContext().getRealPath("/files"));
                } else if (acao != null && acao.equals("atualizaTabela"))//refresh tabela
                {
                    String pc = request.getParameter("palchave");

                    if (pc.trim().isEmpty())
                    {
                        result = CtrPiada.getInstancia().getLinhasHTML();
                    } else
                    {
                        Filtro f = new Filtro("", "palchave_piada", pc.trim());
                        result = CtrPiada.getInstancia().getLinhasHTML(f);
                    }
                    //out.print(result);
                } else if (codigo.equals(""))//insert
                {
                    String titulo, palchave, texto;
                    int Codcategoria;
                    Part arq;

                    titulo = request.getParameter("tit_piada");
                    palchave = request.getParameter("palChave");
                    texto = request.getParameter("texto");
                    Codcategoria = Integer.parseInt(request.getParameter("cat"));

                    try
                    {
                        arq = request.getPart("arquivo");
                        if (CtrPiada.getInstancia().insert(titulo, palchave, texto, Codcategoria, usr))
                        {
                            result = "";

                            String c = CtrPiada.getInstancia().getCodigoUltimaPiada();
                            boolean f = Utils.Util.up_Arquivo(c, arq, this);
                            if(!f)
                            {
                                response.sendError(1, "Erro ao Upar o Arquivo");
                            }
                            else
                            {
                                out.print("Inserção bem sucedida!!!");
                            }
                        }
                    } catch (Exception ex)
                    {
                        System.out.println(ex.getCause());
                        System.out.println(ex.getMessage());
                    }
                } else//edit
                {
                    String titulo, palchave, texto;
                    int Codcategoria;
                    Part arq;
                    titulo = request.getParameter("tit_piada");
                    palchave = request.getParameter("palChave");
                    texto = request.getParameter("texto");
                    Codcategoria = Integer.parseInt(request.getParameter("cat"));

                    if(CtrPiada.getInstancia().update(Integer.parseInt(codigo), titulo, palchave, texto, Codcategoria, usr))
                    {
                        boolean f = true;
                        arq = request.getPart("arquivo");
                        if (arq != null)
                        {
                            Util.deletImagem(Integer.parseInt(codigo), this.getServletContext().getRealPath("/files"));
                            if(!Util.up_Arquivo(codigo, arq, this))
                            {
                                
                                response.sendError(1, "Erro ao Atualizar o Arquivo");
                            }
                        }
                        out.print("Update bem sucedida!!!");
                    }
                    
                }
                    out.print(result);
            } else
            {
                acao = request.getParameter("evento");
                String result = "";
                if (acao != null && acao.equals("atualizaGridPiada"))
                {
                    String filtro = request.getParameter("busca");
                    result = CtrPiada.getInstancia().getGridPiadas(filtro, 10);
                    out.print(result);
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
