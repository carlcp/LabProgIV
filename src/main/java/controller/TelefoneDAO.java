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
import model.Telefone;
import model.Telefone;

/**
 *
 * @author ycar2
 */
public class TelefoneDAO {
    private final Connection con;
    private PreparedStatement cmd;
    
    public TelefoneDAO(){
        this.con = Conexao.conectar();
    }
    
    public int inserir(Telefone obj){
     try {
            String SQL = "insert into tb_telefone "
                       + "(ddd,numero,id_cliente, fg_ativo) values (?,?,?,?,?)";
            
            cmd = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            cmd.setInt(1, obj.getDdd());
            cmd.setInt(2, obj.getNumero());
            cmd.setInt(2, obj.getId_cliente() );
            cmd.setInt(4,obj.getFg_ativo());
            
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
     public int atualizar(Telefone obj){
        try {
            String SQL = "update tb_telefone set ddd=?, numero=?, id_cliente, fg_ativo=? where id_cliente=?";

            cmd.setInt(1, obj.getDdd());
            cmd.setInt(2, obj.getNumero());
            cmd.setInt(2, obj.getId_cliente() );
            cmd.setInt(4,obj.getFg_ativo());
            
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
    public List<Telefone> listar(){
        try {
            String SQL = "select * from tb_telefone order by id";
            cmd = con.prepareStatement(SQL);
            
            //executar a consulta
            List<Telefone> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()){
                Telefone tel= new Telefone();
                tel.setDdd(rs.getInt("ddd"));
                tel.setNumero(rs.getInt("numero"));
                tel.setFg_ativo(rs.getInt("fg_ativo"));
                lista.add(tel);
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
    public List<Telefone> pesquisarPorNome(String nome){
        try {
            String SQL = "select * from tb_cliente where nome ilike ? order by id";
            cmd = con.prepareStatement(SQL);
            cmd.setString(1,"%"+nome+"%");
            
            //executar a consulta
            List<Telefone> lista = new ArrayList<>();
            ResultSet rs = cmd.executeQuery();
            while (rs.next()){
                Telefone tel = new Telefone();
                tel.setDdd(rs.getInt("ddd"));
                tel.setNumero(rs.getInt("numero"));
                tel.setFg_ativo(rs.getInt("fg_ativo"));
                lista.add(tel);
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
    public Telefone pesquisarPorId(String id){
        try {
            String SQL = "select * from tb_cliente where id = ? order by id";
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, Integer.parseInt(id));
            
            //executar a consulta
            ResultSet rs = cmd.executeQuery();
            if (rs.next()){
                Telefone tel = new Telefone();
                tel.setDdd(rs.getInt("ddd"));
                tel.setNumero(rs.getInt("numero"));
                tel.setId_cliente(rs.getInt("id_cliente"));
                tel.setFg_ativo(rs.getInt("fg_ativo"));
                return tel;
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
