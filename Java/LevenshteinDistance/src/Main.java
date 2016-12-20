import java.io.File;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by antonaks on 12.11.16.
 */

public class Main{
		
    public static void main(String[] args) throws Exception {    	
    	runAalogithm();  
    }  
    
   
    private static void runAalogithm() throws Exception{
        Date Start = new Date();      // Must be delete
        String ResultFileName = "Result.csv"; 
        
        File FileCSV = new File(CONSTANT.FilePath + ResultFileName);
         
        Algorithm algorithm = new Algorithm(CONSTANT.FileIN_1,CONSTANT.FileIN_2, CONSTANT.accuracy);
        
        ArrayList<String> resultList = algorithm.start();					
//        FileCreatorXML.createFile(resultList, FileOUT);      // Write results into xml file
        FileCreatorCSV.createCsvFile(resultList, FileCSV);	 // Write results into csv file       
        System.out.println("START: " + Start +"\n"+"FINISH: " + new Date());      // Must be deleted
    }
}