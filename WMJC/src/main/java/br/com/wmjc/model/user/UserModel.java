package br.com.wmjc.model.user;

public class UserModel
{
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private TipoUser tipoUser;

    public UserModel() {
    }

    public UserModel(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }
    public UserModel(String nome, String sobrenome, String email,  String senha, TipoUser tipoUser) {
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

    public void setSenha(final String senha) {
        this.senha = senha;
    }
}
