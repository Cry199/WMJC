package br.com.wmjc.model.game.commentsGame;

import java.math.BigInteger;

public class GameCommentsModel
{
    private BigInteger id;
    private BigInteger idUser;
    private BigInteger idGame;
    private String commentGame;

    public GameCommentsModel(){}

    public GameCommentsModel(BigInteger idUser, BigInteger idGame, String commentGame)
    {
        this.idUser = idUser;
        this.idGame = idGame;
        this.commentGame = commentGame;
    }

    public GameCommentsModel(BigInteger id, BigInteger idUser, BigInteger idGame, String commentGame)
    {
        this.id = id;
        this.idUser = idUser;
        this.idGame = idGame;
        this.commentGame = commentGame;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getIdUser() {
        return idUser;
    }

    public void setIdUser(BigInteger idUser) {
        this.idUser = idUser;
    }

    public BigInteger getIdGame() {
        return idGame;
    }

    public void setIdGame(BigInteger idGame) {
        this.idGame = idGame;
    }

    public String getCommentGame() {
        return commentGame;
    }

    public void setCommentGame(String commentGame) {
        this.commentGame = commentGame;
    }

    @Override
    public String toString() {
        return "GameCommentsModel{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", idGame=" + idGame +
                ", commentGame='" + commentGame + '\'' +
                '}';
    }
}
