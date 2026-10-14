import java.util.ArrayList;

public class CalculadoraXML {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Error: Faltan argumentos.");
            System.out.println("Uso: java CalculadoraXML <archivo.xml> <variable1> [variable2]");
            return;
        }

        String archivo = args[0];
        String var1 = args[1];
        String var2 = args.length >= 3 ? args[2] : null;

        LectorXML lector = new LectorXML();
        CalculadoraEstadistica calc = new CalculadoraEstadistica();

        try {
            ArrayList<Double> datos1 = lector.extraerValores(archivo, var1);
            imprimirEstadisticas(var1, datos1, calc);

            if (var2 != null) {
                ArrayList<Double> datos2 = lector.extraerValores(archivo, var2);
                imprimirEstadisticas(var2, datos2, calc);

                double correlacion = calc.calcularCorrelacion(datos1, datos2);
                System.out.println("\n--- Correlación ---");
                System.out.println("Coeficiente entre " + var1 + " y " + var2 + ": " + correlacion);
            }

        } catch (Exception e) {
            System.out.println("Error en la ejecución: " + e.getMessage());
        }
    }

    private static void imprimirEstadisticas(String nombre, ArrayList<Double> datos, CalculadoraEstadistica calc) {
        System.out.println("\n--- Estadísticas para: " + nombre + " ---");
        System.out.println("Media: " + calc.calcularMedia(datos));
        System.out.println("Desviación estándar: " + calc.calcularDesviacionEstandar(datos));
        System.out.println("Varianza: " + calc.calcularVarianza(datos));
        System.out.println("Valor máximo: " + calc.calcularMaximo(datos));
        System.out.println("Valor mínimo: " + calc.calcularMinimo(datos));
    }
}