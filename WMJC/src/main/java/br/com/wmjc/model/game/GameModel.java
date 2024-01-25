package br.com.wmjc.model.game;
import java.math.BigInteger;

public class GameModel {

    private BigInteger idUser;
    private String nameGame;
    private String nameTable;
    private String descGame;
    private String bannerGamer;

    public GameModel(){

    }

    public GameModel(String nameGame, String nameTable, String descGame, String bannerGamer ){
        this.nameGame = nameGame;
        this.nameTable = nameTable;
        this.descGame = descGame;
        this.bannerGamer = bannerGamer;;
    }


    public GameModel(BigInteger idUser,String nameGame, String nameTable, String descGame, String bannerGamer ){
        this.idUser = idUser;
        this.nameGame = nameGame;
        this.nameTable = nameTable;
        this.descGame = descGame;
        this.bannerGamer = bannerGamer;;
    }
    public BigInteger getIdUser() {
        return idUser;
    }

    public void setIdUser(BigInteger idUser) {
        this.idUser = idUser;
    }

    public String getNameGame() {
        return nameGame;
    }

    public void setNameGame(String nameGame) {
        this.nameGame = nameGame;
    }

    public String getNameTable() {
        return nameTable;
    }

    public void setNameTable(String nameTable) {
        this.nameTable = nameTable;
    }

    public String getDescGame() {
        return descGame;
    }

    public void setDescGame(String descGame) {
        this.descGame = descGame;
    }

    public String getBannerGamer() {
        return bannerGamer;
    }

    public void setBannerGamer(String bannerGamer) {
        this.bannerGamer = bannerGamer;
    }






}
