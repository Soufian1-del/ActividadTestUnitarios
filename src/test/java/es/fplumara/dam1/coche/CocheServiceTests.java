package es.fplumara.dam1.coche;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CocheServiceTests {

    //BLOQUE A

    @ParameterizedTest
    @ValueSource(strings = {
            "1234ABC",
            "0000ZZZ",
            "9876QWE"
    })
     void validadorMatricula(String Matricula){
        CocheService servicio = new CocheService();
        Boolean resultado = servicio.validaMatricula(Matricula);
        Boolean resultadoEsperado = true;
        assertEquals(resultadoEsperado, resultado);
    }
    @ParameterizedTest
    @CsvSource({
            "123ABC",
            "12345ABC",
            "1234AB",
            "1234A1C",
            "1234-ABC",
            "1234 ABC",
            "1234abc"
    })
    public void validadorIlegales(String Matriculas){
        CocheService servicio = new CocheService();
        Boolean resultado = servicio.validaMatricula(Matriculas);
        Boolean resultadoEsperado = false;
        assertEquals(resultadoEsperado, resultado);
    }
}


