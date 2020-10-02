package wednesday.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyExceptions {

	public static void readFile(String location) throws Exception {
		File file = new File(location);

		try (FileReader fr = new FileReader(file)) {
			int content;
			while ((content = fr.read()) != -1) {
				System.out.print((char) content);
			}
		} catch (FileNotFoundException e) {
			System.out.println("catch clause: File not found!");
			//throw new Exception("I throwed this exception!");
			throw new CustomException("I throwed this exception!");
			//e.getStackTrace();

		} catch (IOException e) {
			System.out.println("Something went wrong!");
		} finally {
			System.out.println("\n" + file.getAbsolutePath());

		}
	}
}
