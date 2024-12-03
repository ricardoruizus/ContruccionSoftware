package proyectocajero.Modelo;

import java.sql.SQLException;
import java.util.Random;

public class DatosCuenta {
    private final String noCuenta;
    private final Nombre nombreBeneficiario;
    private final Fecha fechaNacimiento;
    private final String rfc;
    private final String pinSeguridad;

    public DatosCuenta(
            Nombre nombreBeneficiario, 
            Fecha fechaNacimiento, 
            String rfc, 
            String pinSeguridad) throws SQLException {
        this.noCuenta = generarNoCuenta();
        this.nombreBeneficiario = nombreBeneficiario;
        this.fechaNacimiento = fechaNacimiento;
        this.rfc = rfc;
        this.pinSeguridad = pinSeguridad;
    }

    public String getNoCuenta() {
        return noCuenta;
    }

    public Nombre getNombreBeneficiario() {
        return nombreBeneficiario;
    }

    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getRfc() {
        return rfc;
    }

    public String getPinSeguridad() {
        return pinSeguridad;
    }
    
    private String generarNoCuenta() throws SQLException {
        String cadenaId;
        int LONGITUD_ID = 8;
        Random random = new Random();
        ConexionSql conexion = ConexionSql.nuevaConexion();
        do {
            cadenaId = "";
            for (int i = 1; i <= LONGITUD_ID; i++) {
                int numeroAgregado = random.nextInt(10);
                cadenaId = cadenaId + Integer.toString(numeroAgregado);
            }
        } while (conexion.existeUsuario(cadenaId));
        return cadenaId;
    }
}
