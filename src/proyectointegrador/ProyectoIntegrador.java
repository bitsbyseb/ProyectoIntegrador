package proyectointegrador;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Arrays;
import proyectointegrador.Estadistica;

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
        String optionMessage = """
                               Seleccione el proceso a realizar:
                               0.Moda.
                               1.Media.
                               2.Mediana.
                               3.quartiles.
                               """;
        int option = Integer.parseInt(JOptionPane.showInputDialog(optionMessage));
        while (!(option >= 0 && option <= 2)) {
            option = Integer.parseInt(JOptionPane.showInputDialog(optionMessage));
        }
        String datos = JOptionPane.showInputDialog("Ingresa el conjunto de numeros a evaluar separados por una ", "");
        String[] asArr = datos.split(",");
        ArrayList<Integer> numeros = new ArrayList();
        for (String asArr1 : asArr) {
            numeros.add(Integer.valueOf(asArr1));
        }
        Estadistica estadistica = new Estadistica(numeros);
        switch (option) {
            case 0 -> {
                int moda = estadistica.moda();
                JOptionPane.showMessageDialog(null, "La moda es igual a " + moda);
            }
            case 1 -> {
                int media = estadistica.media();
                JOptionPane.showMessageDialog(null, "La media es igual a " + media);
            }
            case 2 -> {
                int mediana = estadistica.mediana();
                JOptionPane.showMessageDialog(null, "La mediana es igual a " + mediana);
            }
            case 3 -> {
                double[] quartiles = estadistica.quartiles();
                JOptionPane.showMessageDialog(null,"Los cuartiles son:\n"+Arrays.toString(quartiles));
            }
        }
    }

    public static void fisica() {
    }

}
