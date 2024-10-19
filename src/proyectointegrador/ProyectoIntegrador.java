package proyectointegrador;

import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.UIManager;

/**
 *
 * @author JohanPuentes
 */
public class ProyectoIntegrador {

    public static void main(String[] args) {
        try {
            String optionMessage = """
                    Seleccione el proceso a realizar:
                    0.Estadistica.
                    1.Fisica.
                    """;
            int option = Integer.parseInt(JOptionPane.showInputDialog(optionMessage));
            while (!(option >= 0 && option <= 1)) {
                option = Integer.parseInt(JOptionPane.showInputDialog(optionMessage));
            }
            if (option == 0) {
                estadistica();
            } else {
                fisica();
            }
        } catch (HeadlessException | NumberFormatException e) {
            System.err.println(e);
        }
    }

    public static void estadistica() {
        UIManager.put("OptionPane.background", new Color(0x0F0F0F));
        UIManager.put("Panel.background", new Color(0x0F0F0F));
        String optionMessage = """
                <html>
                     <p style="color:white;">
                     Seleccione el proceso a realizar:
                     </p>
                     <ul style="color:#7359F8">
                         <li style="color:white">
                             0.Moda.
                         </li>

                         <li style="color:white">
                             1.Media.
                         </li>

                         <li style="color:white">
                             2.Mediana.
                         </li>

                         <li style="color:white">
                            3.Quartiles.
                         </li>
                     </ul>
                </html>
                """;
        int option = Integer.parseInt(JOptionPane.showInputDialog(optionMessage));
        while (!(option >= 0 && option <= 3)) {
            option = Integer.parseInt(JOptionPane.showInputDialog(optionMessage));
        }
        String datos = input(
                "<html><p style='color:white'>Ingresa el conjunto de numeros a evaluar separados por una</p></html>");
        String[] asArr = datos.split(",");
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        for (String asArr1 : asArr) {
            numeros.add(Integer.valueOf(asArr1));
        }
        Estadistica estadistica = new Estadistica(numeros);
        switch (option) {
            case 0 -> {
                int moda = estadistica.moda();
                message("La moda es igual a " + moda);
            }
            case 1 -> {
                int media = estadistica.media();
                message("La media es igual a " + media);
            }
            case 2 -> {
                int mediana = estadistica.mediana();
                message("La mediana es igual a " + mediana);
            }
            case 3 -> {
                double[] quartiles = estadistica.quartiles();
                message("Los cuartiles son:\n" + Arrays.toString(quartiles));
            }
        }
    }

    static void message(String msg) {
        UIManager.put("OptionPane.background", new Color(0x0F0F0F));
        UIManager.put("Panel.background", new Color(0x0F0F0F));
        JOptionPane.showMessageDialog(null, "<html><h1 style='color:white'>" + msg + "</h1></html>");
    }

    static String input(String msg) {
        UIManager.put("OptionPane.background", new Color(0x0F0F0F));
        UIManager.put("Panel.background", new Color(0x0F0F0F));
        return JOptionPane.showInputDialog(msg);
    }

    static int InputPanel(String msg, int min, int max) {
        UIManager.put("OptionPane.background", new Color(0x0F0F0F));
        UIManager.put("Panel.background", new Color(0x0F0F0F));
        int value = Integer.parseInt(JOptionPane.showInputDialog(msg));
        if (value >= min && value <= max) {
            return value;
        }
        message("Opcion Incorrecta");
        return InputPanel(msg, min, max);
    }

    public static void fisica() {

        String[] longuitudes = { "m", "km", "cm", "mm", "in", "ft", "yd", "mi" };
        String[] masas = { "g", "lb", "oz" };
        String[] fuerzas = { "kgf", "lbf" };
        String[] energias = { "cal", "kcal", "wh" };
        String[] velocidades = { "km/h", "mph", "ft/s" };
        String[] temperaturas = { "c", "k", "f" };

        HashMap<Integer, String[]> conversionOptions = new HashMap<Integer, String[]>();
        conversionOptions.put(2, longuitudes);
        conversionOptions.put(3, temperaturas);
        conversionOptions.put(4, velocidades);
        conversionOptions.put(5, energias);
        conversionOptions.put(6, masas);
        conversionOptions.put(7, fuerzas);

        UIManager.put("OptionPane.background", new Color(0x0F0F0F));
        UIManager.put("Panel.background", new Color(0x0F0F0F));
        String optionMessage = """
                <html>
                     <p style="color:white;">
                     Seleccione el proceso a realizar:
                     </p>
                     <ul style="color:#7359F8">
                         <li style="color:white">
                             0.Movimiento Rectilineo Uniforme.
                         </li>

                         <li style="color:white">
                             1.Movimiento Rectilineo Uniformememente Acelerado.
                         </li>

                         <li style="color:white">
                             2.Conversion De Longuitudes.
                         </li>

                         <li style="color:white">
                             3.Conversion De Temperatura.
                        </li>

                        <li style="color:white">
                             4.Velocidad.
                        </li>

                        <li style="color:white">
                             5.Energia.
                        </li>

                        <li style="color:white">
                             6.Masa.
                        </li>

                        <li style="color:white">
                             7.Fuerza.
                        </li>
                     </ul>
                </html>
                """;
        int option = InputPanel(optionMessage, 0, 7);
        HashMap<Integer, String> optionsMessages = new HashMap<Integer, String>();
        optionsMessages.put(0, """
                                               <html>
                                                    <p style="color:white;">
                                                    Movimiento Rectilineo Uniforme:
                                                    </p>
                                                    <ul style="color:#7359F8">
                                                        <li style="color:white">
                                                            0.Velocidad.
                                                        </li>

                                                        <li style="color:white">
                                                            1.Distancia.
                                                        </li>

                                                        <li style="color:white">
                                                            2.Tiempo.
                                                        </li>
                                                    </ul>
                                               </html>
                """);

        optionsMessages.put(1, """
                                               <html>
                                                    <p style="color:white;">
                                                    Movimiento Rectilineo Uniformemente Acelerado:
                                                    </p>
                                                    <ul style="color:#7359F8">
                                                        <li style="color:white">
                                                            0.VelocidadFinal.
                                                        </li>

                                                        <li style="color:white">
                                                            1.Distancia Recorrida.
                                                        </li>

                                                        <li style="color:white">
                                                            2.Aceleración.
                                                        </li>

                                                        <li style="color:white">
                                                         3.Velocidad Final Por Distancia.
                                                        </li>
                                                    </ul>
                                               </html>
                """);

        optionsMessages.put(2, """
                                               <html>
                                                    <p style="color:white;">
                                                    Conversiones, escribe el valor de
                                                    la medida a convertir:
                                                    </p>
                                               </html>
                """);
        int min = 0;
        int max = option == 0 ? 2 : option == 1 ? 3 : Integer.MAX_VALUE;
        String message = option >= 2 || option <= 7 ? optionsMessages.get(2) : optionsMessages.get(option);
        int process = InputPanel(message, min, max);
        if (option == 0) {
            switch (process) {
                case 0 -> {
                    double distancia = Double.parseDouble(input("Ingresa la distancia en metros:"));
                    double tiempo = Double.parseDouble(input("Ingresa el tiempo en segundos"));
                    message("El resultado de la velocidad es igual a " + Fisica.mru.velocidad(distancia, tiempo));
                }
                case 1 -> {
                    double velocidad = Double.parseDouble(input("Ingresa la velocidad en metros:"));
                    double tiempo = Double.parseDouble(input("Ingresa el tiempo en segundos"));
                    message("El resultado de la distancia es igual a " + Fisica.mru.distancia(velocidad, tiempo) + "m");
                }
                case 2 -> {
                    double distancia = Double.parseDouble(input("Ingresa la distancia en metros:"));
                    double velocidad = Double.parseDouble(input("Ingresa la velocidad en metros"));
                    message("El resultado del tiempo es igual a " + Fisica.mru.tiempo(distancia, velocidad)
                            + " segundos");
                }
            }
        } else if (option == 1) {
            switch (process) {
                case 0 -> {
                    double velocidadInicial = Double
                            .parseDouble(input("Ingresa la velocidad Inicial por su valor en metros"));
                    double aceleracionMetros = Double.parseDouble(input("Introduce la aceleracion en metros"));
                    double tiempoSegundos = Double.parseDouble(input("Ingresa el tiempo en segundos"));
                    message("La velocidad final es igual a "
                            + Fisica.mrua.velocidadFinal(velocidadInicial, aceleracionMetros, tiempoSegundos) + "m/s");
                }
                case 1 -> {
                    double velocidadInicial = Double
                            .parseDouble(input("Ingresa la velocidad Inicial por su valor en metros"));
                    double aceleracionMetros = Double.parseDouble(input("Introduce la aceleracion en metros"));
                    double tiempoSegundos = Double.parseDouble(input("Ingresa el tiempo en segundos"));
                    message("La distancia recorrida es igual a "
                            + Fisica.mrua.distanciaRecorrida(velocidadInicial, aceleracionMetros, tiempoSegundos)
                            + "m/s");
                }
                case 2 -> {
                    double velocidadInicial = Double
                            .parseDouble(input("Ingresa la velocidad Inicial por su valor en metros"));
                    double velocidadFinal = Double.parseDouble(input("Introduce la velocidad final en metros"));
                    double tiempoSegundos = Double.parseDouble(input("Ingresa el tiempo en segundos"));
                    message("La aceleracion es igual a"
                            + Fisica.mrua.aceleracion(velocidadInicial, velocidadFinal, tiempoSegundos) + "m/s2");
                }
                case 3 -> {
                    double velocidadInicial = Double.parseDouble(input("Ingresa la velocidad inicial en metros"));
                    double aceleracionMetros = Double.parseDouble(input("Ingresa la aceleracion en metros"));
                    double distanciaMetros = Double.parseDouble("Ingresa la distancia en metros");
                    message("La velocidad final calculada por medio de distancia es igual a " + Fisica.mrua
                            .velocidadFinalConDistancia(velocidadInicial, aceleracionMetros, distanciaMetros) + "m/s");
                }
            }
        } else {
            int value = process;
            String from = input("<html><p style='color:white'>Ingresa la unidad de medida de origen:\n<br/>"
                    + splitArray("<br/>", conversionOptions.get(option)) + "</p></html>");
            String to = input("<html><p style='color:white'>Ingresa la unidad de medida de destino:\n<br/>"
                    + splitArray("<br/>", conversionOptions.get(option)) + "</p></html>");

            switch (option) {
                case 2:
                    message(value + " " + from + " es igual a " + Fisica.conversiones.convertirLongitud(value, from, to)
                            + "" + to);
                    break;
                case 3:
                    message(value + " " + from + " es igual a "
                            + Fisica.conversiones.convertirTemperatura(value, from, to) + "" + to);
                    break;
                case 4:
                    message(value + " " + from + " es igual a "
                            + Fisica.conversiones.convertirVelocidad(value, from, to) + "" + to);
                    break;
                case 5:
                    message(value + " " + from + " es igual a "
                            + Fisica.conversiones.convertirEnergia(value, from, to) + "" + to);
                    break;
                case 6:
                    message(value + " " + from + " es igual a "
                            + Fisica.conversiones.convertirMasa(value, from, to) + "" + to);
                    break;
                case 7:
                    message(value + " " + from + " es igual a "
                            + Fisica.conversiones.convertirFuerza(value, from, to) + "" + to);
                    break;
            }
        }
    }

    static String splitArray(String separator, String[] arr) {
        String result = "";
        for (String element : arr) {
            result = result.concat(element + separator);
        }
        return result;
    }
}