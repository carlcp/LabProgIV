package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Usuario;
import java.sql.SQLException;
public class UsuarioDAO {
    
    private final Connection con;
    private PreparedStatement cmd;
    
    public UsuarioDAO(){
        this.con = Conexao.conectar();
    }
        
    public boolean login(Usuario u){
        try {
            
            String SQL="select * from tb_usuario where "
                    + "usuario=? and senha=md5(?)";
            
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, u.getUsuario());
            cmd.setString(2, u.getSenha());
           
            ResultSet rs = cmd.executeQuery();
            if (rs.next()){
                return true;
            }else{
                return false;
            }

        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return false;
        }
    }
    
    public int cadastro(Usuario u){
        try {
            
            String SQL="insert into tb_usuario "
                    + "(usuario, senha) values(?,md5(?)) ";
            
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, u.getUsuario());
            cmd.setString(2, u.getSenha());
           
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
    
    public int atualizar(Usuario obj){
        try{
            String SQL = "update tb_usuario, usuario=?, senha=md5(?) where id = ? ";
                       
            
            cmd = con.prepareStatement(SQL);
            cmd.setString(2, obj.getUsuario());
            cmd.setString(3, obj.getSenha());          
            cmd.setInt(7, obj.getId());
            
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
