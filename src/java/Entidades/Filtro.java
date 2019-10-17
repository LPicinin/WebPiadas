/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Aluno
 */
public class Filtro
{
    private String nome;
    private String coluna;
    private String chave;

    public Filtro(String nome, String coluna, String chave)
    {
        this.nome = nome;
        this.coluna = coluna;
        this.chave = chave;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getColuna()
    {
        return coluna;
    }

    public void setColuna(String coluna)
    {
        this.coluna = coluna;
    }

    public String getChave()
    {
        return chave;
    }

    public void setChave(String chave)
    {
        this.chave = chave;
    }

    @Override
    public String toString()
    {
        return nome;
    }
    
    
}
