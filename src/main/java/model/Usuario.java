package model;

public class Usuario {
    
    private int id;
    private String usuario;
    private String senha;
    private int fg_ativo;

    public Usuario() {
    }

    public Usuario(int id, String usuario, String senha, int fg_ativo) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
    }

    public int getFg_ativo() {
        return fg_ativo;
    }

    public void setFg_ativo(int fg_ativo) {
        this.fg_ativo = fg_ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
