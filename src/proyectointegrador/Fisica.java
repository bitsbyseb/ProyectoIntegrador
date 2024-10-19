package proyectointegrador;

/**
 *
 * @author puent
 */

class Conversiones {
    
    public double convertirLongitud(double valor, String unidadOrigen, String unidadDestino) {
        double valorEnMetros = valor * factorConversionAmetros(unidadOrigen.toLowerCase());
        return valorEnMetros * factorConversionDesdeMetros(unidadDestino.toLowerCase());
    }
    
    private double factorConversionAmetros(String unidad) {
        switch (unidad.toLowerCase()) {
            case "m" -> {
                return 1;
            }
            case "km" -> {
                return 1000;
            }
            case "cm" -> {
                return 0.01;
            }
            case "mm" -> {
                return 0.001;
            }
            case "in" -> {
                return 0.0254;
            }
            case "ft" -> {
                return 0.3048;
            }
            case "yd" -> {
                return 0.9144;
            }
            case "mi" -> {
                return 1609.34;
            }
            default -> throw new IllegalArgumentException("Unidad de origen no soportada: " + unidad);
        }
    }
    
    private double factorConversionDesdeMetros(String unidad) {
        switch (unidad.toLowerCase()) {
            case "m": // metros
                return 1;
            case "km": // kilómetros
                return 0.001;
            case "cm": // centímetros
                return 100;
            case "mm": // milímetros
                return 1000;
            case "in": // pulgadas
                return 39.3701;
            case "ft": // pies
                return 3.28084;
            case "yd": // yardas
                return 1.09361;
            case "mi": // millas
                return 0.000621371;
            default:
                throw new IllegalArgumentException("Unidad de destino no soportada: " + unidad);
        }
    }
}


class MRU {

    String MRUVelocidad(double distanciaKM, double tiempo) {
        return (distanciaKM + "/" + tiempo);
    }

    double MRUDistancia(double velocidad, double tiempo) {
        return velocidad * tiempo;
    }

    double MRUTiempo(double distancia, double velocidadEnKM) {
        return distancia / velocidadEnKM;
    }
}

class MRUA {

    double velocidadFinal(double velocidadInicial, double aceleracionMetros, double tiempo) {
        return (velocidadInicial + aceleracionMetros + tiempo);
    }

    double distanciaRecorrida(double velocidadInicial, double aceleracionMetros, double tiempo) {
        return (velocidadInicial * tiempo) + 1 / 2 * aceleracionMetros * (Math.pow(tiempo, 2));
    }

    double aceleracion (double velocidadInicial,double velocidadFinal, double tiempo) {
        return (velocidadFinal-velocidadInicial)/tiempo;
    }
    
    double velocidadFinalConDistancia(double velocidadInicial,double aceleracionMetros,double distanciaMetros) {
        return Math.sqrt(Math.pow(velocidadInicial,2)+2*aceleracionMetros*distanciaMetros);
    }
}

public class Fisica extends Conversiones {
    static MRUA mrua = new MRUA();
    static MRU mru = new MRU();
    static Conversiones conversiones = new Conversiones();
    static void main() {
       
    }
}
