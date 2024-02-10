package br.com.wmjc.model.game;

public class GameGeneralModel
{
    private int id;
    private String texto;
    private String op1;
    private int ref1;
    private String op2;
    private int ref2;
    private String op3;
    private int ref3;
    private String image;

    public GameGeneralModel() {}

    public GameGeneralModel(int id, String texto, String op1, int ref1, String op2, int ref2, String op3, int ref3, String image)
    {
        this.id = id;
        this.texto = texto;
        this.op1 = op1;
        this.ref1 = ref1;
        this.op2 = op2;
        this.ref2 = ref2;
        this.op3 = op3;
        this.ref3 = ref3;
        this.image = image;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTexto()
    {
        return texto;
    }

    public void setTexto(String texto)
    {
        this.texto = texto;
    }

    public String getOp1()
    {
        return op1;
    }

    public void setOp1(String op1)
    {
        this.op1 = op1;
    }

    public int getRef1()
    {
        return ref1;
    }

    public void setRef1(int ref1)
    {
        this.ref1 = ref1;
    }

    public String getOp2()
    {
        return op2;
    }

    public void setOp2(String op2)
    {
        this.op2 = op2;
    }

    public int getRef2()
    {
        return ref2;
    }

    public void setRef2(int ref2)
    {
        this.ref2 = ref2;
    }

    public String getOp3()
    {
        return op3;
    }

    public void setOp3(String op3)
    {
        this.op3 = op3;
    }

    public int getRef3()
    {
        return ref3;
    }

    public void setRef3(int ref3)
    {
        this.ref3 = ref3;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }
}
