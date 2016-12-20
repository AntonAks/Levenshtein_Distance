import java.io.File;

public interface CONSTANT {
	static float accuracy = 0.60f;	
	String FilePath = "C:/Users/a.aksenov/eclipse/LevenshteinDistance/src/datafiles/";	
	String FirstFileName = "data_1.xml";
	String SecondFileName = "data_2.xml";	
    File FileIN_1 = new File(FilePath + FirstFileName);
    File FileIN_2 = new File(FilePath + SecondFileName);
//    static File FileOUT = new File(FilePath + "WriteTest.xml");	
}
