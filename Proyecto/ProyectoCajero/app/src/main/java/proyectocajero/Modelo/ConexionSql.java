package proyectocajero.Modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionSql implements DaoClass{
    private static final String URL = "jdbc:mysql://localhost:3306/usuarios";
    private static final String USUARIO = "root";
    private Connection conexion;
    private static ConexionSql instancia;
    
    private ConexionSql() throws SQLException {
        try {
            this.conexion = DriverManager.getConnection(ConexionSql.URL, ConexionSql.USUARIO, "");
        } catch (SQLException expected) {
            System.out.println("Error al conectar: " + expected.getMessage());
        } finally {
            
        }
    }
    
    public static ConexionSql nuevaConexion() throws SQLException {
        if (instancia == null) {
            instancia = new ConexionSql();
        }
        return instancia;
    }

    private Connection getConexion() {
        return conexion;
    }
    
    public void terminarConexion() throws SQLException{
        getDeclaracion().close();
        getConexion().close();
    }
    
    private Statement getDeclaracion() throws SQLException {
        return getConexion().createStatement();
    }
    
    @Override
    public boolean existeUsuario(String numeroUsuario) throws SQLException {
        String sentenciaSQL =  "SELECT no_cuenta"
                + "             FROM datos_cuenta "
                + "             WHERE no_cuenta = " + numeroUsuario + ";";
        ResultSet consultaSQL = getDeclaracion().executeQuery(sentenciaSQL);
        return consultaSQL.next();
    }
    
    @Override
    public Cuenta cuentaEncontrada(String numeroCuenta) throws SQLException {
        if (existeUsuario(numeroCuenta)) {
            String sentenciaSql = "SELECT no_cuenta, "
                    + "                    nombre, "
                    + "                    AES_DECRYPT(pin_seguridad, 'Katniss') AS pin_seguridad, "
                    + "                    saldo_cuenta "
                    + "             FROM datos_cuenta "
                    + "             WHERE no_cuenta = ?;";
            
            try(PreparedStatement consultaSql = getConexion().prepareStatement(sentenciaSql)){
                consultaSql.setString(1, numeroCuenta);
                ResultSet resultadoConsulta = consultaSql.executeQuery();
                if(resultadoConsulta.next()){
                    Cuenta cuenta = new Cuenta(resultadoConsulta.getString("no_cuenta"), 
                                                         new Nombre(resultadoConsulta.getString("nombre")), 
                                               resultadoConsulta.getString("pin_seguridad"), 
                                                resultadoConsulta.getDouble("saldo_cuenta"));
                    return cuenta;
                }
                return null;
            } 
        } else {
            System.out.println("Número de cuenta desconocido");
            return null;
        }
    }
    
    @Override
    public void actualizarSaldo(Cuenta cuenta) throws SQLException{
        String sentenciaSQL = "UPDATE datos_cuenta "
                + "             SET saldo_cuenta = ?"
                + "             WHERE no_cuenta = ?;";
        try (PreparedStatement editarSQL = getConexion().prepareStatement(sentenciaSQL)){
            editarSQL.setFloat(1, (float) cuenta.getSaldoCuenta());
            editarSQL.setString(2, cuenta.getNumeroCuenta());
            editarSQL.executeUpdate();
        }
    }
    
    @Override
    public void insertarUsuario(DatosCuenta datos) {
        String sentenciaSql = "INSERT INTO datos_cuenta (no_cuenta, nombre, fecha_nacimiento, rfc, pin_seguridad, saldo_cuenta) VALUES"
                + "             (?, ?, ?, AES_ENCRYPT(?, 'Katniss'), AES_ENCRYPT(?, 'Katniss'), 0.00)";
        try {
            PreparedStatement editarSql;
            editarSql = getConexion().prepareStatement(sentenciaSql);
            editarSql.setString(1, datos.getNoCuenta());
            editarSql.setString(2, datos.getNombreBeneficiario().toString());
            editarSql.setString(3, datos.getFechaNacimiento().toString());
            editarSql.setString(4, datos.getRfc());
            editarSql.setString(5, datos.getPinSeguridad());
            editarSql.executeUpdate();
        } catch (SQLException ok) {
            Logger.getLogger(ConexionSql.class.getName()).log(Level.SEVERE, null, ok);
        }
    }
}
