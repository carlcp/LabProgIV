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
import model.Cliente;

/**
 *
 * @author ycar2
 */
public class ClienteDAO {
    private final Connection con;
    private PreparedStatement cmd;
    
    public ClienteDAO() {
     this.con = Conexao.conectar();
    }
    
    public int inserir(Cliente obj){
     try {
            String SQL = "insert into tb_cliente "
                       + "(nome,cpf,ddd,numero,fg_ativo) values (?,?,?,?,?)";
            
            cmd = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            cmd.setString(1, obj.getNome());
            cmd.setString(2, obj.getCpf());
            cmd.setString(3, obj.getDdd());
            cmd.setString(4, obj.getNumero());
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
     public int atualizar(Cliente obj){
        try {
            String SQL = "update tb_cliente set nome=?, cpf=?,ddd=?, numero=?, fg_ativo=? where id=?";

            cmd = con.prepareStatement(SQL);
            cmd.setString(1, obj.getNome());
            cmd.setString(2, obj.getCpf());
            cmd.setString(3, obj.getDdd());
            cmd.setString(4, obj.getNumero());
            cmd.setInt(5,obj.getFg_ativo());
            cmd.setInt(6,obj.getId());
            
            if (cmd.executeUpdate() > 0){
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
    public List<Cliente> listar(){
        try {
            String SQL = "select * from tb_cliente order by id";
            cmd = con.prepareStatement(SQL);
            
            //executar a consulta
            List<Cliente> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()){
                Cliente cli = new Cliente();
                cli.setId(rs.getInt("id"));
                cli.setNome(rs.getString("nome"));
                cli.setCpf(rs.getString("cpf"));
                cli.setDdd(rs.getString("ddd"));
                cli.setNumero(rs.getString("numero"));
                cli.setFg_ativo(rs.getInt("fg_ativo"));
                lista.add(cli);
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
    public List<Cliente> pesquisarPorNome(String nome){
        try {
            String SQL = "select * from tb_cliente where nome ilike ? order by id";        
            cmd = con.prepareStatement(SQL);
            cmd.setString(1,"%"+nome+"%");
            
            //executar a consulta
            List<Cliente> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()){
                Cliente cli = new Cliente();
                cli.setId(rs.getInt("id"));
                cli.setNome(rs.getString("nome"));
                cli.setCpf(rs.getString("cpf"));
                cli.setFg_ativo(rs.getInt("fg_ativo"));
                lista.add(cli);
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
    public Cliente pesquisarPorId(String id){
        try {
            String SQL = "select * from tb_cliente where id = ? order by id";
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, Integer.parseInt(id));
            
            //executar a consulta
            ResultSet rs = cmd.executeQuery();
            if (rs.next()){
                Cliente cli = new Cliente();
                cli.setId(rs.getInt("id"));
                cli.setNome(rs.getString("nome"));
                cli.setDdd(rs.getString("ddd"));
                cli.setNumero(rs.getString("numero"));
                cli.setCpf(rs.getString("cpf"));  
                cli.setFg_ativo(rs.getInt("fg_ativo"));
                return cli;
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
