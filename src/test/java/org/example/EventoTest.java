package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventoTest {
    private Evento criarReuniao() {
        return new Evento("Reunião de equipe", "Segunda 09:00", new Local("Escritório central", "Sala 3"));
    }

    @Test
    void deveSerCloneable() {
        assertInstanceOf(Cloneable.class, criarReuniao());
    }

    @Test
    void deveDescreverEvento() {
        assertEquals("Reunião de equipe | Segunda 09:00 | Escritório central, Sala 3", criarReuniao().descrever());
    }

    @Test
    void cloneDeveSerOutroObjetoComOsMesmosValores() throws CloneNotSupportedException {
        Evento original = criarReuniao();
        Evento copia = original.clone();

        assertNotSame(original, copia);
        assertEquals(original.getTitulo(), copia.getTitulo());
        assertEquals(original.getHorario(), copia.getHorario());
        assertEquals(original.descrever(), copia.descrever());
    }

    @Test
    void cloneDeveCopiarTambemOLocal() throws CloneNotSupportedException {
        Evento original = criarReuniao();
        Evento copia = original.clone();

        assertNotSame(original.getLocal(), copia.getLocal());
        assertEquals(original.getLocal().getNome(), copia.getLocal().getNome());
        assertEquals(original.getLocal().getSala(), copia.getLocal().getSala());
    }

    @Test
    void alterarTituloEHorarioDoCloneNaoDeveAlterarOriginal() throws CloneNotSupportedException {
        Evento original = criarReuniao();
        Evento copia = original.clone();
        copia.setTitulo("Retrospectiva da semana");
        copia.setHorario("Sexta 16:00");

        assertEquals("Reunião de equipe", original.getTitulo());
        assertEquals("Segunda 09:00", original.getHorario());
    }

    @Test
    void alterarLocalDoCloneNaoDeveAlterarOriginal() throws CloneNotSupportedException {
        Evento original = criarReuniao();
        Evento copia = original.clone();
        copia.getLocal().setSala("Sala 5");

        assertEquals("Sala 3", original.getLocal().getSala());
        assertEquals("Sala 5", copia.getLocal().getSala());
    }

    @Test
    void clonesDoMesmoEventoDevemSerIndependentes() throws CloneNotSupportedException {
        Evento original = criarReuniao();
        Evento primeira = original.clone();
        Evento segunda = original.clone();
        primeira.setHorario("Quarta 09:00");

        assertNotSame(primeira, segunda);
        assertNotSame(primeira.getLocal(), segunda.getLocal());
        assertEquals("Segunda 09:00", segunda.getHorario());
    }
}
