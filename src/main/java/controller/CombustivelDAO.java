/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Combustivel;
import model.Produto;

/**
 *
 * @author ycar2
 */
public class CombustivelDAO {
   private final Connection con;
    private PreparedStatement cmd;
    
     public CombustivelDAO(){
        this.con = Conexao.conectar();
    }
     
     public int inserir(Produto obj){
        try {
            String SQL = "insert into tb_combustiveis (id_categoria,nome, "
                    + " preco,qntl, taxa,fg_ativo) values (?,?,?,?,?,?)";
            
            cmd = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            cmd.setString(1, obj.getNome());
            cmd.setInt(2,obj.getId_categoria());
            cmd.setInt(3,obj.getQntd());
            cmd.setDouble(4,obj.getTaxa());
            cmd.setInt(5,obj.getFg_ativo());
            
            if (cmd.executeUpdate() > 0){
                ResultSet rs = cmd.getGeneratedKeys();
                return rs.next()? rs.getInt(1) : 1;   //OK
            }else{
                return -1;  // ERRO
            }
        } catch (SQLException e) {
            System.err.println("ERRO: " + e.getMessage());
            return -1;
        }finally{
            Conexao.desconectar(con);
        }
    }
    
    //
    // ATUALIZAR
    //
    public int atualizar(Produto obj){
        try {
            String SQL = "update tb_combustiveis id_categoria=?,set nome=?,"
                    + "preco=?,qntl=?, taxa=?, fg_ativo=? where id=?";

            cmd = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            cmd.setString(1, obj.getNome());
            cmd.setInt(2,obj.getId_categoria());
            cmd.setInt(3,obj.getQntd());
            cmd.setDouble(4,obj.getTaxa());
            cmd.setInt(5,obj.getFg_ativo());
            cmd.setInt(6,obj.getId());
            
            //envia a instrução SQL para o banco
            if (cmd.executeUpdate() > 0){
                //operação realizada com sucesso
                return 1;   //OK
            }else{
                return -1;  // ERRO
            }
        } catch (SQLException e) {
            System.err.println("ERRO: " + e.getMessage());
            return -1;
        }finally{
            Conexao.desconectar(con);
        }
    }    
    
    
    //
    // LISTAR
    // Retorna todos os dados da tabela
    public List<Combustivel> listar(){
        try {
            String SQL = "select * from tb_combustiveis order by id";
            cmd = con.prepareStatement(SQL);
           
            List<Combustivel> combustivel = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()){
                Combustivel obj = new Combustivel();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setId_categoria(rs.getInt("id_categoria"));
                obj.setQntl(rs.getInt("qntd"));
                obj.setTaxa(rs.getDouble("taxa"));
                obj.setFg_ativo(rs.getInt("fg_ativo"));
                combustivel.add(obj);
            }
            return combustivel;
        } catch (SQLException e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }finally{
            Conexao.desconectar(con);
        }
    }
    
    //
    // PESQUISAR POR NOME
    // Pesquisa categorias por nome
    //
    public List<Combustivel> pesquisarPorNome(String nome){
        try {
            String SQL = "select * from tb_combustiveis where nome ilike ? order by id";
            cmd = con.prepareStatement(SQL);
            cmd.setString(1,"%"+nome+"%");
            
            //executar a consulta
            List<Combustivel> combustivel = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()){
                Combustivel obj = new Combustivel();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setId_categoria(rs.getInt("id_categoria"));
                obj.setQntl(rs.getInt("qntl"));
                obj.setTaxa(rs.getDouble("taxa"));
                obj.setFg_ativo(rs.getInt("fg_ativo"));
                combustivel.add(obj);
            }
            return combustivel;
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
    public Produto pesquisarPorId(String id){
        try {
            String SQL = "select * from tb_produto where id = ? order by id";
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, Integer.parseInt(id));
            
            //executar a consulta
            ResultSet rs = cmd.executeQuery();
            if (rs.next()){
                Produto obj = new Produto();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setId_categoria(rs.getInt("id_categoria"));
                obj.setQntd(rs.getInt("qntd"));
                obj.setTaxa(rs.getDouble("taxa"));
                obj.setFg_ativo(rs.getInt("fg_ativo"));
                return obj;
            }
            return null;
        } catch (SQLException e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }finally{
            Conexao.desconectar(con);
        }
    }    
}
