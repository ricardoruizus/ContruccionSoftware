package proyectocajero.Modelo;

public class Cuenta {
    private final String numeroCuenta;
    private final Nombre nombreUsuario;
    private final String pinSeguridad;
    private double saldoCuenta;

    public Cuenta(String numeroCuenta, Nombre nombreUsuario, String pinSeguridad, double saldoCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.nombreUsuario = nombreUsuario;
        this.pinSeguridad = pinSeguridad;
        this.saldoCuenta = saldoCuenta;
    }
    
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    
    public Nombre getNombresUsuario() {
        return nombreUsuario;
    }

    public double getSaldoCuenta() {
        return saldoCuenta;
    }
    
    public void setSaldoCuenta(double saldo_cuenta) {
        this.saldoCuenta = saldo_cuenta;
    }
    
    public String getPinSeguridad() {
        return this.pinSeguridad;
    }

    private boolean esMayorCero(double valor) {
        return valor > 0;
    }
    
    public void depositar(double monto) {
        if (esMayorCero(monto)) {
            setSaldoCuenta(getSaldoCuenta() + monto);
        } else {
            System.out.println("Monto de deposito invalido o insuficiente");
        }
    }
    
    public void retirar(double monto) {
        if (esMayorCero(monto)) {
            if (getSaldoCuenta() > monto) {
                setSaldoCuenta(getSaldoCuenta() - monto);
            } else {
                System.out.println("Fondos insuficientes");
            }
        } else {
            System.out.println("Monto de retiro invalido");
        }
    }
    
    public void transferir(double monto, Cuenta cuenta) {
        Cuenta cuentaDestino = cuenta;
        if (esMayorCero(monto)) {
            if (getSaldoCuenta() > monto) {
                setSaldoCuenta(getSaldoCuenta() - monto);
                cuentaDestino.setSaldoCuenta(cuentaDestino.getSaldoCuenta() + monto);
            } else {
                System.out.println("Fondos insuficientes para realizar la tranferencia");
            }
        } else {
            System.out.println("Monto invalido para realizar la tranferencia");
        }
    }
}