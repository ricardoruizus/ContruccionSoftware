package proyectocajero.Modelo;

import java.util.Arrays;
import java.util.List;

public class Fecha {
    private int dia;
    private int mes;
    private int anio;

    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }
    
    public Fecha(String fechaStr) {
        List<String> elementosFecha = Arrays.asList(fechaStr.split("-"));
        if (elementosFecha.size() == 3) {
            this.dia = Integer.parseInt(elementosFecha.get(2));
            this.mes = Integer.parseInt(elementosFecha.get(1));
            this.anio = Integer.parseInt(elementosFecha.get(0));
        }
    }
    
    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }

    @Override
    public String toString() {
        return getAnio() + "-" + getMes() + "-" + getDia();
    }
}
