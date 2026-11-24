package org.example;

public class Evento implements Cloneable {
    private String titulo;
    private String horario;
    private Local local;

    public Evento(String titulo, String horario, Local local) {
        this.titulo = titulo;
        this.horario = horario;
        this.local = local;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public String descrever() {
        return titulo + " | " + horario + " | " + local.getNome() + ", " + local.getSala();
    }

    @Override
    public Evento clone() throws CloneNotSupportedException {
        Evento copia = (Evento) super.clone();
        copia.local = local.clone();
        return copia;
    }
}
