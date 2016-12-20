import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by antonaks on 13.11.16.
 */
public class FileCreatorCSV {

	static public void createCsvFile(ArrayList<String> arrayList,File file) throws IOException{
            
        	FileWriter fileWriter = new FileWriter(file,false);
          
            for(int i = 0; i < arrayList.size(); i++){
            	fileWriter.write(arrayList.get(i)+"\n");
            	}           
            fileWriter.flush();
            fileWriter.close();
            System.out.println("CSV File saved!");
        }
    }
