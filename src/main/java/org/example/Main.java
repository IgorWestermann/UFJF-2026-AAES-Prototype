package org.example;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Evento reuniao = new Evento("Reunião de equipe", "Segunda 09:00", new Local("Escritório central", "Sala 3"));

        Evento copiaQuarta = reuniao.clone();
        copiaQuarta.setHorario("Quarta 09:00");
        copiaQuarta.getLocal().setSala("Sala 5");

        Evento copiaSexta = reuniao.clone();
        copiaSexta.setTitulo("Retrospectiva da semana");
        copiaSexta.setHorario("Sexta 16:00");

        System.out.println("Original: " + reuniao.descrever());
        System.out.println("Cópia 1:  " + copiaQuarta.descrever());
        System.out.println("Cópia 2:  " + copiaSexta.descrever());
        System.out.println("O original continua na " + reuniao.getLocal().getSala());
    }
}
