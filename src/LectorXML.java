import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class LectorXML{
    public ArrayList<Double> extraerValores(String rutaArchivo, String nombreVariable){
        ArrayList<Double> valoresExtraidos = new ArrayList<>();
        try {
            File archivoXML = new File(rutaArchivo);
            DocumentBuilderFactory agencia = DocumentBuilderFactory.newInstance();
            DocumentBuilder detective = agencia.newDocumentBuilder();

            Document documentoDOM = detective.parse(archivoXML);
            documentoDOM.getDocumentElement().normalize();
            System.out.println("Archivo XML procesado correctamente en la RAM");

            NodeList listaDeNodos = documentoDOM.getElementsByTagName(nombreVariable);
            if (listaDeNodos.getLength() == 0) {
                throw new IllegalArgumentException("La variable " + nombreVariable + " no existe");
            }
            for (int i = 0; i < listaDeNodos.getLength(); i++) {
                Node nodoActual = listaDeNodos.item(i);
                if (nodoActual.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodoActual;
                    String textoDelNumero = elemento.getTextContent();
                    try {
                        double numeroReal = Double.parseDouble(textoDelNumero);
                        valoresExtraidos.add(numeroReal);
                    } catch (NumberFormatException errorDeLetras ) {
                        throw new IllegalArgumentException("El archivo XML tiene texto en lugar de numeros");
                    }
                }
            }
            System.out.println("Se extrajeron los " + valoresExtraidos.size() + " valores correctamente");

        } catch (Exception e) {
            System.err.println("ERROR: No se pudo procesar tu archivo XML. " + e.getMessage());
        }
        return valoresExtraidos;
    }

}
