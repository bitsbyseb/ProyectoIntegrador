package proyectointegrador;

/**
 *
 * @author puent
 */
class Conversiones {

    public double convertirTemperatura(double valor, String unidadOrigen, String unidadDestino) {
        // Convertir a Celsius
        if (unidadOrigen.equalsIgnoreCase("f")) {
            valor = (valor - 32) * 5 / 9;
        } else if (unidadOrigen.equalsIgnoreCase("k")) {
            valor = valor - 273.15;
        }

        // Convertir desde Celsius a la unidad de destino
        if (unidadDestino.equalsIgnoreCase("f")) {
            return (valor * 9 / 5) + 32;
        } else if (unidadDestino.equalsIgnoreCase("k")) {
            return valor + 273.15;
        }

        return valor; // Si la unidad de destino es Celsius
    }

    // Conversión de Velocidad
    public  double convertirVelocidad(double valor, String unidadOrigen, String unidadDestino) {
        // Convertir a metros por segundo (m/s)
        if (unidadOrigen.equalsIgnoreCase("km/h")) {
            valor = valor / 3.6;
        } else if (unidadOrigen.equalsIgnoreCase("mph")) {
            valor = valor * 0.44704;
        } else if (unidadOrigen.equalsIgnoreCase("ft/s")) {
            valor = valor * 0.3048;
        }

        // Convertir desde metros por segundo a la unidad de destino
        if (unidadDestino.equalsIgnoreCase("km/h")) {
            return valor * 3.6;
        } else if (unidadDestino.equalsIgnoreCase("mph")) {
            return valor / 0.44704;
        } else if (unidadDestino.equalsIgnoreCase("ft/s")) {
            return valor / 0.3048;
        }

        return valor; // Si la unidad de destino es m/s
    }

    // Conversión de Energía
    public double convertirEnergia(double valor, String unidadOrigen, String unidadDestino) {
        // Convertir a Joules (J)
        if (unidadOrigen.equalsIgnoreCase("cal")) {
            valor = valor * 4.184;
        } else if (unidadOrigen.equalsIgnoreCase("kcal")) {
            valor = valor * 4184;
        } else if (unidadOrigen.equalsIgnoreCase("wh")) {
            valor = valor * 3600;
        }

        // Convertir desde Joules a la unidad de destino
        if (unidadDestino.equalsIgnoreCase("cal")) {
            return valor / 4.184;
        } else if (unidadDestino.equalsIgnoreCase("kcal")) {
            return valor / 4184;
        } else if (unidadDestino.equalsIgnoreCase("wh")) {
            return valor / 3600;
        }

        return valor; // Si la unidad de destino es Joules
    }

    // Conversión de Fuerza
    public double convertirFuerza(double valor, String unidadOrigen, String unidadDestino) {
        // Convertir a Newtons (N)
        if (unidadOrigen.equalsIgnoreCase("kgf")) {
            valor = valor * 9.80665;
        } else if (unidadOrigen.equalsIgnoreCase("lbf")) {
            valor = valor * 4.44822;
        }

        // Convertir desde Newtons a la unidad de destino
        if (unidadDestino.equalsIgnoreCase("kgf")) {
            return valor / 9.80665;
        } else if (unidadDestino.equalsIgnoreCase("lbf")) {
            return valor / 4.44822;
        }

        return valor; // Si la unidad de destino es Newtons
    }

    // Conversión de Masa
    public double convertirMasa(double valor, String unidadOrigen, String unidadDestino) {
        // Convertir a Kilogramos (kg)
        if (unidadOrigen.equalsIgnoreCase("g")) {
            valor = valor * 0.001;
        } else if (unidadOrigen.equalsIgnoreCase("lb")) {
            valor = valor * 0.453592;
        } else if (unidadOrigen.equalsIgnoreCase("oz")) {
            valor = valor * 0.0283495;
        }

        // Convertir desde Kilogramos a la unidad de destino
        if (unidadDestino.equalsIgnoreCase("g")) {
            return valor / 0.001;
        } else if (unidadDestino.equalsIgnoreCase("lb")) {
            return valor / 0.453592;
        } else if (unidadDestino.equalsIgnoreCase("oz")) {
            return valor / 0.0283495;
        }

        return valor; // Si la unidad de destino es Kilogramos
    }

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
            default ->
                throw new IllegalArgumentException("Unidad de origen no soportada: " + unidad);
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

    String velocidad(double distanciaKM, double tiempo) {
        return (distanciaKM + " m" + "/" + tiempo + " s");
    }

    double distancia(double velocidad, double tiempo) {
        return velocidad * tiempo;
    }

    double tiempo(double distancia, double velocidadEnKM) {
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

    double aceleracion(double velocidadInicial, double velocidadFinal, double tiempo) {
        return (velocidadFinal - velocidadInicial) / tiempo;
    }

    double velocidadFinalConDistancia(double velocidadInicial, double aceleracionMetros, double distanciaMetros) {
        return Math.sqrt(Math.pow(velocidadInicial, 2) + 2 * aceleracionMetros * distanciaMetros);
    }
}

public class Fisica extends Conversiones {
    static MRUA mrua = new MRUA();
    static MRU mru = new MRU();
    static Conversiones conversiones = new Conversiones();
}