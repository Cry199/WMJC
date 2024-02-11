package br.com.wmjc.model.game;

public class GameGeneralModel
{
    private int id;
    private String texto;
    private String op1;
    private String ref1;
    private String op2;
    private String ref2;
    private String op3;
    private String ref3;
    private String image;

    public GameGeneralModel() {}

    public GameGeneralModel(int id, String texto, String op1, String ref1, String op2, String ref2, String op3, String ref3, String image)
    {
        this.texto = texto;
        this.op1 = op1;
        this.ref1 = ref1;
        this.op2 = op2;
        this.ref2 = ref2;
        this.op3 = op3;
        this.ref3 = ref3;
        this.image = image;
    }

    public GameGeneralModel(String texto, String op1, String ref1, String op2, String ref2, String op3, String ref3, String image)
    {
        this.texto = texto;
        this.op1 = op1;
        this.ref1 = ref1;
        this.op2 = op2;
        this.ref2 = ref2;
        this.op3 = op3;
        this.ref3 = ref3;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getOp1() {
        return op1;
    }

    public void setOp1(String op1) {
        this.op1 = op1;
    }

    public String getRef1() {
        return ref1;
    }

    public void setRef1(String ref1) {
        this.ref1 = ref1;
    }

    public String getOp2() {
        return op2;
    }

    public void setOp2(String op2) {
        this.op2 = op2;
    }

    public String getRef2() {
        return ref2;
    }

    public void setRef2(String ref2) {
        this.ref2 = ref2;
    }

    public String getOp3() {
        return op3;
    }

    public void setOp3(String op3) {
        this.op3 = op3;
    }

    public String getRef3() {
        return ref3;
    }

    public void setRef3(String ref3) {
        this.ref3 = ref3;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString()
    {
        return "GameGeneralModel{" +
                "id=" + id +
                ", texto='" + texto + '\'' +
                ", op1='" + op1 + '\'' +
                ", ref1='" + ref1 + '\'' +
                ", op2='" + op2 + '\'' +
                ", ref2='" + ref2 + '\'' +
                ", op3='" + op3 + '\'' +
                ", ref3='" + ref3 + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
