package es.fplumara.dam1.operaciones;

import es.fplumara.dam1.operaciones.Operaciones;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

public class MediaTest {

    public static Stream<Arguments> notasAcalcular() {
        return Stream.of(
                Arguments.of(new double[]{2.5, 3.5, 2, 4}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("notasAcalcular")
    @DisplayName("Prueba de calculo de las notas con methodSource")
    public void mediaTest(double[] notasAcalcular, double mediaEsperada){
        double resultado = Operaciones.media(notasAcalcular);
        assertEquals(resultado,resultado, 0.0001);
    }

    @Test
    @DisplayName("Prueba de calculo de las notas con assertAll")
    public void tresMedias(){
        assertAll(
                () -> assertEquals(5, Operaciones.media(new double[]{5, 5}), 0.0001),
                () -> assertEquals(6, Operaciones.media(new double[]{6, 6}), 0.0001),
                () -> assertEquals(7, Operaciones.media(new double[]{7, 7}), 0.0001)
        );
    }

    @Test
    @DisplayName("prueba de ilegales")
    public void Ilegales(){
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> Operaciones.media(null));
        assertEquals("No hay notas", ex.getMessage());
        IllegalArgumentException ex2 = assertThrows(IllegalArgumentException.class, () -> Operaciones.media((double[]) null));
        assertEquals("No hay notas", ex2.getMessage());
    }
}

