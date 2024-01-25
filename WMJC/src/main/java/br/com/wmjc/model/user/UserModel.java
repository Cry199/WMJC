package br.com.wmjc.model.user;

public class UserModel
{
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private String tipoUser;

    public UserModel() {
    }
    public UserModel(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }
    public UserModel(String username, String password, String tipoUser) {
        this.email = username;
        this.senha = password;
        this.tipoUser = tipoUser;
    }
    public UserModel(String nome, String sobrenome, String email,  String senha, String tipoUser) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.tipoUser = tipoUser;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return this.sobrenome;
    }

    public void setSobrenome(final String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public String getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }

    public void setSenha(final String senha) {
        this.senha = senha;
    }
}


