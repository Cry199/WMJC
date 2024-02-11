package br.com.wmjc.model.game.historico;

import java.util.Date;

public class GameHistoricoModel
{
    private int id;
    private int idUser;
    private int idGame;
    private Date data;

    public GameHistoricoModel() {}

    public GameHistoricoModel(int id, int idUser, int idGame, Date data)
    {
        this.id = id;
        this.idUser = idUser;
        this.idGame = idGame;
        this.data = data;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getIdUser()
    {
        return idUser;
    }

    public void setIdUser(int idUser)
    {
        this.idUser = idUser;
    }

    public int getIdGame()
    {
        return idGame;
    }

    public void setIdGame(int idGame)
    {
        this.idGame = idGame;
    }

    public Date getData()
    {
        return data;
    }

    public void setData(Date data)
    {
        this.data = data;
    }

    @Override
    public String toString()
    {
        return "GameHistoricoModel{" + "id=" + id + ", idUser=" + idUser + ", idGame=" + idGame + ", data=" + data + '}';
    }
}
