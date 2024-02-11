package br.com.wmjc.model.user.profile.Comments;

import br.com.wmjc.model.user.UserModel;

import java.math.BigInteger;

public class ProfileComments {
    private BigInteger id;
    private String comment;
    private Integer idPerfil;
    private Integer idUser;

    public ProfileComments(){}

    public ProfileComments(BigInteger id, Integer idUser, Integer idPerfil, String comment)
    {
        this.id = id;
        this.idUser = idUser;
        this.idPerfil = idPerfil;
        this.comment = comment;
    }

    public ProfileComments(Integer idUser, Integer idPerfil, String comment) {
        this.idUser = idUser;
        this.idPerfil = idPerfil;
        this.comment = comment;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getComment() {
        return comment;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "ProfileComments{id=" + this.id + ", idUser=" + this.idUser + ", idPerfil=" + this.idPerfil + ", comment='" + this.comment + '\'' + '}';
    }
}

