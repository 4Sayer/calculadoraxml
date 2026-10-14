import java.util.ArrayList;

public class CalculadoraEstadistica {

    public double calcularMedia(ArrayList<Double> valores) {
        if (valores == null || valores.isEmpty()) return 0.0;
        double suma = 0.0;
        for (Double v : valores) suma += v;
        return suma / valores.size();
    }

    public double calcularMaximo(ArrayList<Double> valores) {
        if (valores == null || valores.isEmpty()) return 0.0;
        double max = valores.get(0);
        for (Double v : valores) {
            if (v > max) max = v;
        }
        return max;
    }

    public double calcularMinimo(ArrayList<Double> valores) {
        if (valores == null || valores.isEmpty()) return 0.0;
        double min = valores.get(0);
        for (Double v : valores) {
            if (v < min) min = v;
        }
        return min;
    }

    public double calcularVarianza(ArrayList<Double> valores) {
        if (valores == null || valores.size() < 2) return 0.0;
        double media = calcularMedia(valores);
        double sumaDiferenciasCuadrado = 0.0;
        for (Double v : valores) {
            sumaDiferenciasCuadrado += Math.pow(v - media, 2);
        }
        return sumaDiferenciasCuadrado / valores.size();
    }

    public double calcularDesviacionEstandar(ArrayList<Double> valores) {
        return Math.sqrt(calcularVarianza(valores));
    }

    public double calcularCorrelacion(ArrayList<Double> v1, ArrayList<Double> v2) {
        if (v1 == null || v2 == null || v1.size() != v2.size() || v1.isEmpty()) {
            throw new IllegalArgumentException("Las variables deben tener la misma cantidad de datos.");
        }
        double media1 = calcularMedia(v1);
        double media2 = calcularMedia(v2);
        double covarianza = 0.0;
        double varianza1 = 0.0;
        double varianza2 = 0.0;

        for (int i = 0; i < v1.size(); i++) {
            double dif1 = v1.get(i) - media1;
            double dif2 = v2.get(i) - media2;
            covarianza += dif1 * dif2;
            varianza1 += Math.pow(dif1, 2);
            varianza2 += Math.pow(dif2, 2);
        }

        if (varianza1 == 0 || varianza2 == 0) return 0.0;
        return covarianza / Math.sqrt(varianza1 * varianza2);
    }
}