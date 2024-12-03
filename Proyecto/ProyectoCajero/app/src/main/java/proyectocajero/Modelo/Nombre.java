package proyectocajero.Modelo;

import java.util.Arrays;
import java.util.List;

public final class Nombre {
    private String primer_nombre;
    private String segundo_nombre;
    private String apellido_p;
    private String apellido_m;

    public Nombre(
            String primer_nombre,
            String segundo_nombre,
            String apellido_p,
            String apellido_m) {

        this.primer_nombre = primer_nombre;
        this.segundo_nombre = segundo_nombre;
        this.apellido_p = apellido_p;
        this.apellido_m = apellido_m;
    }

    public Nombre(String nombreStr) {
        List<String> elementosNombre = Arrays.asList(nombreStr.split(" "));
        if (elementosNombre.size() != 4) {
            throw new IllegalArgumentException("El nombre debe ser de dos nombres y dos apellidos");
        }
        validarNombre(elementosNombre.get(0));
        validarNombre(elementosNombre.get(1));
        validarNombre(elementosNombre.get(2));
        validarNombre(elementosNombre.get(3));
        this.primer_nombre = elementosNombre.get(0);
        this.segundo_nombre = elementosNombre.get(1);
        this.apellido_p = elementosNombre.get(2);
        this.apellido_m = elementosNombre.get(3);
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    public String getApellido_p() {
        return apellido_p;
    }

    public String getApellido_m() {
        return apellido_m;
    }

    private boolean soloLetras(String cadena) {
        return cadena.matches("[a-zA-Záéíóú�?É�?ÓÚñÑ]+");
    }
    
    private void validarNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException(nombre + " no puede ser nulo o vac�o");
        }
        if (!soloLetras(nombre)) {
            throw new IllegalArgumentException(nombre + " solo puede contener letras");
        }
    }
}
