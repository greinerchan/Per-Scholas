import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class numGen {
    public static void main(String[] args)
    {
        String filepath = System.getProperty("/Users/greinerchan/OneDrive\\ -\\ mail.buffalostate.edu/per\\ scholas/Per-Scholas/week6/code/Calc/out/production/Calc");
        filepath +="\\data.txt";
        System.out.println(filepath);

        try
        {
            File file = new File(filepath);
            if(!file.exists())
            {   //如果不存在data.txt文件则创建
                file.createNewFile();
                System.out.println("data.txt创建完成");
            }
            FileWriter fw = new FileWriter(file);       //创建文件写入
            BufferedWriter bw = new BufferedWriter(fw);

            //产生随机数据，写入文件
            Random random = new Random();
            for(int i=0;i<3000;i++)
            {
                int randint =(int)Math.floor((random.nextDouble()*1000.0));   //产生0-10000之间随机数
                bw.write(String.valueOf(randint));      //写入一个随机数
                bw.write(",");
                //bw.newLine();       //新的一行
            }
            bw.close();
            fw.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
