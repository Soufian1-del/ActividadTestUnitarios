package es.fplumara.dam1.facturacion;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FacturaServiceTest {
    @Mock
        private Calculadora calculadora;

    @Test
    public void totalConIva(){
        FacturaService service = new FacturaService(calculadora);
        when(calculadora.sumar(100,21)).thenReturn(121);
        int resultado = service.totalConIva(100);
        assertEquals(121, resultado);
        verify(calculadora,times(1)).sumar(100,21);
        verifyNoMoreInteractions(calculadora);
    }


}
