package models;

public class Mensagem{
    public String texto;

    public Object dados;

    public Mensagem(String texto) {

        this(texto, null);
    }

    public Mensagem(String texto, Object dados) {

        this.texto = texto;
        this.dados = dados;
    }

}
