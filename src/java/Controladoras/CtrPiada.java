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
        if(ctrPiada == null)
        {
            ctrPiada = new CtrPiada();
        }
        return ctrPiada;
    }
    
    private List<Piada> get(Filtro ...f)
    {
        List<Entidade> select = new Piada().select(f);
        List<Piada> res = new ArrayList<>();
        for (Entidade ent : select)
        {
            res.add((Piada) ent);
        }
        return res;
    }
    public String getLinhasHTML(Filtro ...f)
    {
        List<Piada> ps = get(f);
        String r="";
        
        return r;
    }
}
