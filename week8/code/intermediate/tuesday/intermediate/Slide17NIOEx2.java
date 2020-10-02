package tuesday.intermediate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Slide17NIOEx2 {
	public static void main(String[] args) throws IOException {
		Path file = null;
		BufferedReader bufferedReader = null;
		try
		{
			file = Paths.get("sample5.txt");
			InputStream inputStream = Files.newInputStream(file);
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			System.out.println("Reading the first line of sample5.txt file: " + bufferedReader.readLine());
			System.out.println("Reading the second line of sample5.txt file: " + bufferedReader.readLine());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				bufferedReader.close();
			}
			catch (IOException ioe)
			{
				ioe.printStackTrace();
			}
		}
	}
}
