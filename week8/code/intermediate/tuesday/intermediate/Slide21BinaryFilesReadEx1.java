package tuesday.intermediate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Slide21BinaryFilesReadEx1 {

	public static void main(String[] args) throws IOException {
		// The name of the file to open
		String fileName = "slide18bufferedmethods.txt";
		FileInputStream inputStream = null;
		try
		{
			// Use this array for reading the data
			byte[] buffer = new byte[1000];
			inputStream = new FileInputStream(fileName);
			/* The read() method fills the buffer with data and returns the number of bytes read 
			 * which may be less than the buffer size, but never more. */
			int total = 0;
			int nRead = 0;
			while ((nRead = inputStream.read(buffer)) != -1) {
				// This statement converts the buffer to a string for displaying the results
				String display = new String(buffer);
				System.out.println(display); 
				total += nRead;
			}
			System.out.println("Total: " + total);
		}
		catch (FileNotFoundException ex)
		{
			System.out.println("Unable to open file \"" + fileName + "\"");
		}
		catch (IOException ex)
		{
			System.out.println("Error reading file \"" + fileName + "\"");
		}
		finally
		{
			inputStream.close();
		}

	}

}
