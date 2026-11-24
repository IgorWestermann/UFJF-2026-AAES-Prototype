package org.example;

public class Local implements Cloneable {
    private String nome;
    private String sala;

    public Local(String nome, String sala) {
        this.nome = nome;
        this.sala = sala;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    @Override
    public Local clone() throws CloneNotSupportedException {
        return (Local) super.clone();
    }
}
