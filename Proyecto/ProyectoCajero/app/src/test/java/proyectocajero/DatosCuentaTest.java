package proyectocajero;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DatosCuentaTest {
    @Test
    void generarNoCuentaTest() {
        String noCuenta = "12345678"; // Ejemplo de número de cuenta
        assertEquals(8, noCuenta.length(), "La longitud del numero de cuenta debe ser 8");
    }

}
