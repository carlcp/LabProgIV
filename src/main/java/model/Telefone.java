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
public class Telefone {
    
    private int ddd;
    private int numero;
    private int id_cliente;
    private int fg_ativo; 
    
    public Telefone(){
        
    }

    public Telefone(int ddd, int numero, int id_cliente, int fg_ativo) {
        this.ddd = ddd;
        this.numero = numero;
        this.id_cliente = id_cliente;
        this.fg_ativo = fg_ativo;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getFg_ativo() {
        return fg_ativo;
    }

    public void setFg_ativo(int fg_ativo) {
        this.fg_ativo = fg_ativo;
    }
    
    
    
    
}
