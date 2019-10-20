/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import servlets.inserePiada;

/**
 *
 * @author luish
 */
public class Util
{
    public static boolean up_Arquivo(String nome, Part filePart, inserePiada servlet) throws IOException, ServletException
    {
        boolean f;
        String fileName = filePart.getSubmittedFileName();
        nome = nome + "." + fileName.split("\\.")[1];
        OutputStream out = null;
        InputStream filecontent = null;
        try
        {  
            //criando a pasta
            //File fpasta = new File(getServletContext().getRealPath("/") + "/" + pasta);
            //fpasta.mkdir();
            out = new FileOutputStream(new File(servlet.getServletContext().getRealPath("/") + "/" + nome));
            filecontent = filePart.getInputStream();
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = filecontent.read(bytes)) != -1)
            {
                out.write(bytes, 0, read);
            }
            out.close();
            filecontent.close();
            f = true;
        } catch (Exception fne)
        {
            f = false;
        }
        return f;
    }
}
