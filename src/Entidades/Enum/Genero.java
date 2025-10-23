package Entidades.Enum;

public enum Genero {
    FICCAO("FICÇÃO"),
    ROMANCE("ROMANCE"),
    FANTASIA("FANTASIA"),
    MISTERIO("MISTÉRIO"),
    POESIA("POESIA"),
    TERROR("TERROR"),
    AVENTURA("AVENTURA");

    private final String nome;


    Genero(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
