package br.com.wmjc.model.user.profile.Comments;

import br.com.wmjc.model.user.UserModel;

import java.math.BigInteger;

public class ProfileComments {
    private BigInteger id;
    private String comment;
    private Integer idPerfil;
    private Integer idUser;

    public ProfileComments(ProfileComments id, UserModel idPerfil) {
    }

    public ProfileComments(BigInteger id, String comment) {
        this.id = id;
        this.comment = comment;
    }

    public ProfileComments(Integer idPerfil, String comment, Integer idUser) {
        this.idUser = idUser;
        this.comment = comment;
        this.idPerfil = idPerfil;
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

}

