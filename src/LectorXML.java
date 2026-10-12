import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

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

        } catch (Exception e) {
            System.out.println("ERROR: No se pudo procesar tu archivo XML. " + e.getMessage());
        }
        return valoresExtraidos;
    }

}
