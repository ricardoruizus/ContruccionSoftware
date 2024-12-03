package proyectocajero.Modelo;

import java.sql.SQLException;

public interface DaoClass {
    boolean existeUsuario(String numeroUsuario) throws SQLException;
    Cuenta cuentaEncontrada(String numeroCuenta) throws SQLException;
    void actualizarSaldo(Cuenta cuenta) throws SQLException;
    void insertarUsuario(DatosCuenta datos);
}
