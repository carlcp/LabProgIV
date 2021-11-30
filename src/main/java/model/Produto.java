/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ycar2
 */
public class Produto {
     private int id;
     private int id_categoria;
     private String nome;
     private double preco;
     private double taxa;
     private int qntd;
     private int fg_ativo;
     
     public Produto(){
         
     }

    public Produto(int id, int id_categoria, String nome, double preco, double taxa, int qntd, int fg_ativo) {
        this.id = id;
        this.id_categoria = id_categoria;
        this.nome = nome;
        this.preco = preco;
        this.taxa = taxa;
        this.qntd = qntd;
        this.fg_ativo = fg_ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    public int getQntd() {
        return qntd;
    }

    public void setQntd(int qntd) {
        this.qntd = qntd;
    }

    public int getFg_ativo() {
        return fg_ativo;
    }

    public void setFg_ativo(int fg_ativo) {
        this.fg_ativo = fg_ativo;
    }
     
    
    
}
