package br.com.wmjc.model.game.historico;

public class GameContadorModel
{
    private int id;
    private int idJogo;
    private int contador;

    public GameContadorModel(){}

    public GameContadorModel(int id, int idJogo, int contador)
    {
        this.id = id;
        this.idJogo = idJogo;
        this.contador = contador;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getIdJogo()
    {
        return idJogo;
    }

    public void setIdJogo(int idJogo)
    {
        this.idJogo = idJogo;
    }

    public int getContador()
    {
        return contador;
    }

    public void setContador(int contador)
    {
        this.contador = contador;
    }

    @Override
    public String toString()
    {
        return "GameContadorModel{" + "id=" + id + ", idJogo=" + idJogo + ", contador=" + contador + '}';
    }
}
