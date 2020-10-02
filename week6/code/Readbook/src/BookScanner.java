import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class BookScanner {
    public static void main(String[] args) throws Exception {
        // option 1 is hashMap, option 2 is treeMap
        int option = 1;
        new BookScanner().wordFreq(option);
    }
    public void wordFreq(int option) throws Exception{
        Scanner sc = new Scanner(new File("MobyDick.txt"));
        Map<String, Integer> bookMap = null;
        if (option == 1) {
            bookMap = new HashMap<>();
        } else if (option == 2) {
            bookMap = new TreeMap<>();
        }
        while(sc.hasNextLine()){
            String line=sc.nextLine();
            String[] words=line.split("\\s");
            Set<String> map=bookMap.keySet();
            for(int i=0;i<words.length;i++){
                if(map.contains(words[i])){
                    Integer count=bookMap.get(words[i]);
                    count++;
                    bookMap.put(words[i],count);
                }else{
                    bookMap.put(words[i],1);
                }
            }
        }
        Iterator<String> iterator=bookMap.keySet().iterator();
        String fileName="output.txt";
        BufferedWriter out=new BufferedWriter(new FileWriter(fileName));
        while(iterator.hasNext()){
            String word=iterator.next();
            Path path = Paths.get("output.txt");
           try {
            out.write(word + "\t" + bookMap.get(word) + "\n");
            }  catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            }
        }
        out.close();
    }
}

