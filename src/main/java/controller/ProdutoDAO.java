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
import model.Produto;

/**
 *
 * @author ycar2
 */
public class ProdutoDAO {
     private final Connection con;
    private PreparedStatement cmd;
    
    public ProdutoDAO(){
        this.con = Conexao.conectar();
    }
    
    
    public int inserir(Produto obj){
        try {
            String SQL = "insert into tb_produto (id_categoria,nome, "
                    + " preco,qntd, taxa,fg_ativo) values (?,?,?,?,?,?)";
            
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
            String SQL = "update tb_produto id_categoria=?,set nome=?,"
                    + "preco=?,qntd=?, taxa=?, fg_ativo=? where id=?";

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
    public List<Produto> listar(){
        try {
            String SQL = "select * from tb_produto order by id";
            cmd = con.prepareStatement(SQL);
           
            List<Produto> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()){
                Produto obj = new Produto();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setId_categoria(rs.getInt("id_categoria"));
                obj.setQntd(rs.getInt("qntd"));
                obj.setTaxa(rs.getDouble("taxa"));
                obj.setFg_ativo(rs.getInt("fg_ativo"));
                lista.add(obj);
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
    // PESQUISAR POR NOME
    // Pesquisa categorias por nome
    //
    public List<Produto> pesquisarPorNome(String nome){
        try {
            String SQL = "select * from tb_produto where nome ilike ? order by id";
            cmd = con.prepareStatement(SQL);
            cmd.setString(1,"%"+nome+"%");
            
            //executar a consulta
            List<Produto> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()){
                Produto obj = new Produto();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setId_categoria(rs.getInt("id_categoria"));
                obj.setQntd(rs.getInt("qntd"));
                obj.setTaxa(rs.getDouble("taxa"));
                obj.setFg_ativo(rs.getInt("fg_ativo"));
                lista.add(obj);
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
