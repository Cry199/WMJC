package br.com.wmjc.model.user;

import java.math.BigInteger;

public class UserModel
{
    private BigInteger id;
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private String tipoUser;

    private String username;

    public UserModel(String username, String password, String tipoUser) {
        this.email = username;
        this.senha = password;
        this.tipoUser = tipoUser;
    }

    public UserModel(BigInteger id, String email, String senha, String tipoUser, String username) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.tipoUser = tipoUser;
        this.username = username;
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

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}


