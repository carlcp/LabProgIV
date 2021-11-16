/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Usuario;
import java.sql.SQLException;
import model.Categoria;
/**
 *
 * @author 834398
 */
public class CategoriaDAO {
    private final Connection con;
    private PreparedStatement cmd;
    
    public CategoriaDAO(){
        this.con = Conexao.conectar();
    }
    
     public int cadastro(Categoria obj){
        try {
            
            String SQL="insert into tb_categoria "
                    + "(nome, fg_ativo) values(?,?) ";
            
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, obj.getNome());
            cmd.setString(2, Integer.toString(obj.getFg_ativo()));   
           
  //envia a instrucao SQL para o banco
            if (cmd.executeUpdate() > 0){
                //operacao realziada com sucesso
                return 1; //OK
            }else{
                return -1; // ERRO
            }
        }catch (SQLException e){
            System.err.println("ERRO: " + e.getMessage());
            return -1;
        }finally{
            Conexao.desconectar(con);
        }
    }
    
    public int atualizar(Categoria obj){
        try{
            String SQL = "update tb_categoria, nome=?,  fg_ativo = ? where id = ? ";
                       
            
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, obj.getNome());
            cmd.setString(2, Integer.toString(obj.getFg_ativo()));          
            cmd.setInt(3, obj.getId());
            
            //envia a instrucao SQL para o banco
            if (cmd.executeUpdate() > 0){
                //operacao realziada com sucesso
                return 1; //OK
            }else{
                return -1; // ERRO
            }
        }catch (SQLException e){
            System.err.println("ERRO: " + e.getMessage());
            return -1;
        }finally{
            Conexao.desconectar(con);
        }
        
    }
}
