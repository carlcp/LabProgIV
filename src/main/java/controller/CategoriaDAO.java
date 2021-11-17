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
import java.util.ArrayList;
import java.util.List;
import model.Categoria;
/**
 *
 * @author 834398
 * @author 767447
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
    //
    // PESQUISAR POR NOME
    // Pesquisa categorias por nome
    //
    public List<Categoria> pesquisarPorNome(String nome){
        try {
            String SQL = "select * from tb_categoria where nome ilike ? order by id";
            cmd = con.prepareStatement(SQL);
            cmd.setString(1,"%"+nome+"%");
            
            //executar a consulta
            List<Categoria> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()){
                Categoria cat = new Categoria();
                cat.setId(rs.getInt("id"));
                cat.setNome(rs.getString("nome"));
                cat.setFg_ativo(rs.getInt("fg_ativo"));
                lista.add(cat);
            }
            return lista;
        } catch (SQLException e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }finally{
            Conexao.desconectar(con);
        }

    }
     //
    // PESQUISAR POR ID
    // Pesquisa categorias por Id
    //
    public Categoria pesquisarPorId(String id){
        try {
            String SQL = "select * from tb_categoria where id = ? order by id";
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, Interger().parseInt(id));
            
            //executar a consulta
            ResultSet rs = cmd.executeQuery();
            if (rs.next()){
                Categoria cat = new Categoria();
                cat.setId(rs.getInt("id"));
                cat.setNome(rs.getString("nome"));
                cat.setFg_ativo(rs.getInt("fg_ativo"));
                return cat;
            }
            return null;
        } catch (SQLException e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
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
