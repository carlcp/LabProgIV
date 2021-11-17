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
public class Combustivel {
    private int id;
     private int id_categoria;
     private String nome;
     private double preco;
     private double taxa;
     private int qntl;
     private int fg_ativo;
     
     public Combustivel(){
         
     }

    public Combustivel(int id, int id_categoria, String nome, double preco, double taxa, int qntl, int fg_ativo) {
        this.id = id;
        this.id_categoria = id_categoria;
        this.nome = nome;
        this.preco = preco;
        this.taxa = taxa;
        this.qntl = qntl;
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

    public int getQntl() {
        return qntl;
    }

    public void setQntl(int qntl) {
        this.qntl = qntl;
    }

    public int getFg_ativo() {
        return fg_ativo;
    }

    public void setFg_ativo(int fg_ativo) {
        this.fg_ativo = fg_ativo;
    }
     
     
}
