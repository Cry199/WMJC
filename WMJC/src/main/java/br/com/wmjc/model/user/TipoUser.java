package br.com.wmjc.model.user;

public enum TipoUser
{
    ADMINISTRADOR("admin"),
    USUARIO("user");

    private String tipo;

    TipoUser(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
