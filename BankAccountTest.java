package actividaddeintroduccion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    // Test para comprobar el depósito válido
    @Test
    void testDepositValidAmount() {
        BankAccount  cuenta1 = new BankAccount(1000);
        cuenta1.deposit(500);
        double balance = cuenta1.getBalance();
        double resultado = 1500;

        assertEquals(resultado, balance);
    }

    // Test para comprobar la excepción al depositar una cantidad negativa
    @Test
    void testDepositNegativeAmountThrowsException() {
        BankAccount cuenta1 = new BankAccount(1000);
        cuenta1.deposit(-500);
        double balance = cuenta1.getBalance();
        double resultado = 1500;
        assertEquals(resultado,balance);
    }

    // Test para comprobar el retiro válido
    @Test
    void testWithdrawValidAmount() {
        // ......
    }

    // Test para comprobar la excepción cuando el saldo es insuficiente
    @Test
    void testWithdrawInsufficientFundsThrowsException() {
        // ......
    }

    // Test para comprobar la excepción al retirar una cantidad negativa
    @Test
    void testWithdrawNegativeAmountThrowsException() {
        // ......
    }

    // Test para comprobar el saldo inicial no negativo
    @Test
    void testInitialBalanceCannotBeNegative() {
        // ......
    }

    // Test para comprobar la obtención del saldo después de múltiples operaciones
    @Test
    void testBalanceAfterMultipleOperations() {
        // ......
    }
}
