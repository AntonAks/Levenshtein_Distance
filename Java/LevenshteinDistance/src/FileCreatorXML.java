import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Created by antonaks on 12.11.16.
 */
public class FileCreatorXML {

    static public void createFile(ArrayList<String> stringArrayList, File fileOUT) throws ParserConfigurationException {

        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // ROOT elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("SKU");
            doc.appendChild(rootElement);

            // Data elements
            Element Data = doc.createElement("Data");
            rootElement.appendChild(Data);


            for (int i = 0; i < stringArrayList.size(); i++) {
                Element sku = doc.createElement("row");
                sku.appendChild(doc.createTextNode(stringArrayList.get(i)));
                Data.appendChild(sku);
            }

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(fileOUT);

            transformer.transform(source, result);

            System.out.println("XML File saved!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }

}
