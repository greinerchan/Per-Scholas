import java.io.*;
import java.util.Scanner;

public class ScannerEx1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = null;
        File readin = new File("sample.txt");
        BufferedReader bufferStream = null;
        FileReader inputStream = null;

        //InputStream is;
        //is = new FileInputStream(readin);
        //BufferedReader br = new BufferedReader (is);

        try {
        	inputStream = new FileReader(readin);
        	bufferStream = new BufferedReader(inputStream);
        	s = new Scanner(bufferStream);

        	while(s.hasNext()) {
        		System.out.println(s.next());
        	}
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
        	if (s != null) {
        		s.close();
        	}
        }
    }
}
