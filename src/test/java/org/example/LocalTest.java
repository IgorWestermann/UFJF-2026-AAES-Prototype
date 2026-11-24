package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocalTest {
    @Test
    void deveSerCloneable() {
        assertInstanceOf(Cloneable.class, new Local("Escritório central", "Sala 3"));
    }

    @Test
    void cloneDeveSerOutroObjetoComOsMesmosValores() throws CloneNotSupportedException {
        Local original = new Local("Escritório central", "Sala 3");
        Local copia = original.clone();

        assertNotSame(original, copia);
        assertEquals("Escritório central", copia.getNome());
        assertEquals("Sala 3", copia.getSala());
    }

    @Test
    void alterarCloneNaoDeveAlterarOriginal() throws CloneNotSupportedException {
        Local original = new Local("Escritório central", "Sala 3");
        Local copia = original.clone();
        copia.setNome("Filial");
        copia.setSala("Sala 8");

        assertEquals("Escritório central", original.getNome());
        assertEquals("Sala 3", original.getSala());
    }
}
