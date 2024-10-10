package proyectointegrador;
import java.util.ArrayList;
/**
 *
 * @author puent
 */
public class Estadistica {
    private final ArrayList<Integer> datos;
    Estadistica(ArrayList<Integer> datos) {
        this.datos = datos;
    }
    
    public int media() {
        int promedio = 0;
        for (int elemento : this.datos) {
            promedio += elemento;
        }
        return promedio;
    }
    public int mediana() {
        datos.sort((a,b) -> a.compareTo(b));
        if (datos.size() % 2 != 0) {
            int indice = (int) datos.size()/2;
            return ((datos.get(indice)+datos.get(indice+1))/2);
        }
        return (datos.get(datos.size()/2));
    }
    public int  moda() {
        int moda = 0;
        int maxRepeticiones = 0;
        for (int i = 0;i<datos.size();i++) {
            int repeticiones = 0;
            for (int e = 0;e<datos.size();e++) {
                if (datos.get(i) == datos.get(e)) repeticiones++;
            }
            if (repeticiones > maxRepeticiones) {
                moda = datos.get(i);
                maxRepeticiones = repeticiones;
            }
        }
        return moda;
    }
    public double[] quartiles () {
        double[] quartiles = new double[3];
        for (int i = 1;i<4;i++) {
            quartiles[i-1] = (i*(this.datos.size()+(this.datos.size()%2 == 0 ? 1 : 0)))/4;
        }
        return quartiles;
    }
}
