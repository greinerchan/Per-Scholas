package tuesday.intermediate;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Slide23BinaryFilesWriteEx2 {
	public static void main(String[] args) throws IOException {
		String fileName = "slide23binaryfileswrite.txt";
		BufferedWriter bufferedWriter = null;
		try
		{
			FileWriter fileWriter = new FileWriter(fileName);
			// Always wrap FileWriter in BufferedWriter
			bufferedWriter = new BufferedWriter(fileWriter);
			// Note that write() does not automatically append a newline character
			bufferedWriter.write("Hello there,");
			bufferedWriter.write(" here is some text.");
			bufferedWriter.newLine();
			bufferedWriter.write("We are writing");
			bufferedWriter.write(" the text to the file.");
			
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if (bufferedWriter != null) {
				bufferedWriter.close();
			}
		}
	}
}