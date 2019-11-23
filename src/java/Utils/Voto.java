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
    boolean fCaso_especial;//pra quando há uma troca especial, exemplo like quando o deslike está ativo

    public Voto(int cod_piada, boolean like, boolean deslike, boolean grr)
    {
        this.cod_piada = cod_piada;
        this.like = like;
        this.deslike = deslike;
        this.grr = grr;
        this.fCaso_especial = false;
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
        if (deslike && !like)
        {
            fCaso_especial = true;
            deslike = !deslike;
        }
        like = !like;
    }

    public void negDeslike()
    {
        if (like && !deslike)
        {
            fCaso_especial = true;
            like = !like;
        }
        deslike = !deslike;
    }

    public boolean isfCaso_especial()
    {
        return fCaso_especial;
    }

    public void setfCaso_especial(boolean fCaso_especial)
    {
        this.fCaso_especial = fCaso_especial;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj != null && obj instanceof Voto)
        {
            return ((Voto) obj).cod_piada == this.cod_piada;
        }
        return false;
    }

}
