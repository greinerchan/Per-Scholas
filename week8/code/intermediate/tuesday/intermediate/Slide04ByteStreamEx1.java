package tuesday.intermediate;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Slide04ByteStreamEx1 {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try
		{
			fis = new FileInputStream("sample5.txt");
			fos = new FileOutputStream("sampleTo5.txt");
			int temp;
			
			while ((temp = fis.read()) != -1) { // read byte by byte
				fos.write((byte)temp); // write byte by byte
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			if (fis != null) {
				fis.close();
			}
			if (fos != null) {
				fos.close();
			}
		}
	}


}
