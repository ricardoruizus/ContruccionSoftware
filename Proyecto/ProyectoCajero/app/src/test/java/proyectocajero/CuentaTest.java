package proyectocajero;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import proyectocajero.Modelo.Nombre;
import proyectocajero.Modelo.Cuenta;

class CuentaTest {
    @Test
    void transferirTest() {
        Nombre nombre = new Nombre("marco santiago canche may");
        Cuenta cuenta = new Cuenta("1212",nombre, "3602", 100.0);

        Cuenta cuentaDeposito = new Cuenta("2121",nombre, "3602", 0.0);
        cuenta.transferir(50.0, cuentaDeposito);

        assertEquals(50.0, cuentaDeposito.getSaldoCuenta(), "El saldo de la cuenta debe ser 50");
    }

    @Test
    void transferirFondosInsuficientesTest() {
        Nombre nombre = new Nombre("marco santiago canche may");
        Cuenta cuenta = new Cuenta("1212",nombre, "3602", 30.0);

        Cuenta cuentaDeposito = new Cuenta("2121",nombre, "3602", 0.0);
        cuenta.transferir(50.0, cuentaDeposito);

        assertEquals(30.0, cuenta.getSaldoCuenta(), "El saldo de la cuenta debe ser 30");
        assertEquals(0.0, cuentaDeposito.getSaldoCuenta(), "El saldo de la cuenta de destino debe ser 0");
    }

    @Test
    void transferirMontoInvalidoTest() {
        Nombre nombre = new Nombre("marco santiago canche may");
        Cuenta cuenta = new Cuenta("1212",nombre, "3602", 100.0);

        Cuenta cuentaDeposito = new Cuenta("2121",nombre, "3602", 0.0);
        cuenta.transferir(-50.0, cuentaDeposito);

        assertEquals(100.0, cuenta.getSaldoCuenta(), "El saldo de la cuenta debe ser 100");
        assertEquals(0.0, cuentaDeposito.getSaldoCuenta(), "El saldo de la cuenta de destino debe ser 0");
    }

    @Test
    void transferirMontoCeroTest() {
        Nombre nombre = new Nombre("marco santiago canche may");
        Cuenta cuenta = new Cuenta("1212",nombre, "3602", 100.0);

        Cuenta cuentaDeposito = new Cuenta("2121",nombre, "3602", 0.0);
        cuenta.transferir(0.0, cuentaDeposito);

        assertEquals(100.0, cuenta.getSaldoCuenta(), "El saldo de la cuenta debe ser 100");
        assertEquals(0.0, cuentaDeposito.getSaldoCuenta(), "El saldo de la cuenta de destino debe ser 0");
    }

    @Test
    void depositarTest() {
        Nombre nombre = new Nombre("marco santiago canche may");
        Cuenta cuenta = new Cuenta("1212",nombre, "3602", 100.0);

        cuenta.depositar(50.0);

        assertEquals(150.0, cuenta.getSaldoCuenta(), "El saldo de la cuenta debe ser 150");
    }

    @Test
    void depositarMontoInvalidoTest() {
        Nombre nombre = new Nombre("marco santiago canche may");
        Cuenta cuenta = new Cuenta("1212",nombre, "3602", 100.0);

        cuenta.depositar(-50.0);

        assertEquals(100.0, cuenta.getSaldoCuenta(), "El saldo de la cuenta debe ser 100");
    }

    @Test
    void retirarTest() {
        Nombre nombre = new Nombre("marco santiago canche may");
        Cuenta cuenta = new Cuenta("1212",nombre, "3602", 100.0);

        cuenta.retirar(50.0);

        assertEquals(50.0, cuenta.getSaldoCuenta(), "El saldo de la cuenta debe ser 50");
    }

    @Test
    void retirarFondosInsuficientesTest() {
        Nombre nombre = new Nombre("marco santiago canche may");
        Cuenta cuenta = new Cuenta("1212",nombre, "3602", 30.0);

        cuenta.retirar(50.0);

        assertEquals(30.0, cuenta.getSaldoCuenta(), "El saldo de la cuenta debe ser 30");
    }

    @Test
    void retirarMontoInvalidoTest() {
        Nombre nombre = new Nombre("marco santiago canche may");
        Cuenta cuenta = new Cuenta("1212",nombre, "3602", 100.0);

        cuenta.retirar(-50.0);

        assertEquals(100.0, cuenta.getSaldoCuenta(), "El saldo de la cuenta debe ser 100");
    }

}