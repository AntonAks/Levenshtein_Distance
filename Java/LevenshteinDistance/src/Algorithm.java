import java.io.File;
import java.util.*;

/**
 * Created by antonaks on 12.11.16.
 */
public class Algorithm {

    private File file1 = null;
    private File file2 = null;
    private float accuracy = 0;
    private ArrayList<ArrayList> arrayList1;
    private ArrayList<ArrayList> arrayList2;
    private ArrayList<String> ResultList;

    public Algorithm(File file1, File file2, float accuracy) {
        this.file1 = file1;
        this.file2 = file2;
        this.accuracy = accuracy;
    }

    private int getLevDistanse(Object Obj1, Object Obj2) {

        String S1 = Obj1.toString();
        String S2 = Obj2.toString();

        int length1 = S1.toString().length();
        int length2 = S2.toString().length();

        int[] D1;
        int[] D2 = new int[length2 + 1];

        for(int i = 0; i <= length2; i ++)
            D2[i] = i;
        for(int i = 1; i <= length1; i ++) {
            D1 = D2;
            D2 = new int[length2 + 1];
            for(int j = 0; j <= length2; j ++) {
                if(j == 0) D2[j] = i;
                else {
                    int cost = (S1.charAt(i - 1) != S2.charAt(j - 1)) ? 1 : 0;
                    if(D2[j - 1] < D1[j] && D2[j - 1] < D1[j - 1] + cost)
                        D2[j] = D2[j - 1] + 1;
                    else if(D1[j] < D1[j - 1] + cost)
                        D2[j] = D1[j] + 1;
                    else
                        D2[j] = D1[j - 1] + cost;
                }
            }
        }
        return D2[length2];
    }

    public ArrayList<String> start() throws Exception {

        arrayList1 = FileXMLParser.readXML(this.file1);
        arrayList2 = FileXMLParser.readXML(this.file2);
        ResultList = new ArrayList<>();
        StringBuffer sb;

        ResultList.add("ID 1; String 1; ID 2; String 2; Levenshtein Distance; Similar Result");     // Header in result table
        float count = 0;
        float RowsInFirstArray = arrayList1.get(1).size();
        		
        // Start loop
        for(int i = 0; i < arrayList1.get(1).size(); i++){     	
        	count++;
        	System.out.println((float) count / RowsInFirstArray);        	
        	for(int j = 0; j < arrayList2.get(1).size(); j++){ 
                int LD = getLevDistanse(arrayList1.get(1).get(i).toString().toLowerCase(), arrayList2.get(1).get(j).toString().toLowerCase());
                float result = 1.0f - (float) LD / arrayList1.get(1).get(i).toString().length();

                    if(result >= accuracy) {
                        sb = new StringBuffer();
                        sb
                                .append(arrayList1.get(0).get(i))
                                .append(";")
                                .append(arrayList1.get(1).get(i))
                                .append(";")
                                .append(arrayList2.get(0).get(j))
                                .append(";")
                                .append(arrayList2.get(1).get(j))
                                .append(";")
                                .append(LD)
                                .append(";")
                                .append(String.valueOf(result));

                        ResultList.add(sb.toString());
                        //System.out.println(sb.toString());
                    }
            }
        }
        return ResultList;
    }
}
