package es.fplumara.dam1.operaciones;

import es.fplumara.dam1.operaciones.Operaciones;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

public class OperacionesTest {

    @ParameterizedTest
    @CsvSource({
            "0.0, INSUFICIENTE",
            "4.99, INSUFICIENTE",
            "5.0, APROBADO",
            "6.99, APROBADO",
            "7.0, NOTABLE",
            "8.99, NOTABLE",
            "9.0, SOBRESALIENTE",
            "10.0, SOBRESALIENTE"
    })
    @DisplayName("Test para verificar las notas validas")
    public void clasificacionNotasValidas(double nota, String resultadoEsperado){
        String resultado = Operaciones.calificacion(nota);
        assertEquals(resultado, resultadoEsperado);
    }

    @Test
    @DisplayName("Test para verificar las notas invalidas")
    public void clasificacionNotasInvalidas(){
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> Operaciones.calificacion(-0.01));
        assertEquals("Nota fuera de rango", ex.getMessage());
    }
}


