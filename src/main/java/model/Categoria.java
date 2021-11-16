/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 834398
 */
public class Categoria {
    
    private  int id ;
    private String nome;
    private int fg_ativo;
    
    public Categoria(){
        
    }

    public Categoria(int id, String nome, int fg_ativo) {
        this.id = id;
        this.nome = nome;
        this.fg_ativo = fg_ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getFg_ativo() {
        return fg_ativo;
    }

    public void setFg_ativo(int fg_ativo) {
        this.fg_ativo = fg_ativo;
    }
    
    
}
