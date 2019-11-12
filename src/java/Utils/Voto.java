/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author Aluno
 */
public class Voto
{
    int cod_piada;
    boolean like;
    boolean deslike;
    boolean grr;

    public Voto(int cod_piada, boolean like, boolean deslike, boolean grr)
    {
        this.cod_piada = cod_piada;
        this.like = like;
        this.deslike = deslike;
        this.grr = grr;
    }

    public int getCod_piada()
    {
        return cod_piada;
    }

    public boolean isLike()
    {
        return like;
    }

    public boolean isDeslike()
    {
        return deslike;
    }

    public boolean isGrr()
    {
        return grr;
    }

    public void negGrr()
    {
        grr = !grr;
    }
    
    public void neglike()
    {
        like = !like;
    }
    
    public void negDeslike()
    {
        deslike = !deslike;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj != null && obj instanceof Voto)
        {
            return ((Voto)obj).cod_piada == this.cod_piada;
        }
        return false;
    }
    
}
