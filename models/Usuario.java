package models;

public abstract class Usuario {
    private int id;
    private String nome;
    private TipoUsuario TipoUsuario;
    
    public Usuario(String nome, models.TipoUsuario tipoUsuario) {
        this.nome = nome;
        TipoUsuario = tipoUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoUsuario getTipoUsuario() {
        return TipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        TipoUsuario = tipoUsuario;
    }

    
    
}
