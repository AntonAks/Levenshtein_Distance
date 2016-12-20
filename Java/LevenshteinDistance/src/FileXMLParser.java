import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by antonaks on 12.11.16.
 */
public class FileXMLParser {

    public static ArrayList<ArrayList> readXML(File file) throws Exception {

        ArrayList<String> arrayList_ID = new ArrayList<>();
        ArrayList<String> arrayList_Name = new ArrayList<>();
        ArrayList<ArrayList> arrayTable = new ArrayList<>();

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);

        NodeList nList = doc.getElementsByTagName("Data");

        for (int i = 0; i < nList.getLength(); i++) {
            if (i % 2 == 0) {
                arrayList_ID.add(nList.item(i).getTextContent());
            } else {
                arrayList_Name.add(nList.item(i).getTextContent());
            }
        }

            arrayTable.add(arrayList_ID);
            arrayTable.add(arrayList_Name);

        return arrayTable;
    }

}
