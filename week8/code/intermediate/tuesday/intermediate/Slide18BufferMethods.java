package tuesday.intermediate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Slide18BufferMethods {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("slide18bufferedmethods.txt");
		BufferedReader br = new BufferedReader(fr);
		char[] c = new char[21];
		
		// Illustrating markSupported() method
		if (br.markSupported()) {
			System.out.println("mark() method is supported.");
			// Illustrating mark() method - marks the present position in the stream
			// Also sets a limit on the number of characters that may be read while preserving the mark
			br.mark(100);
		}
		
		// Skip 8 characters
		br.skip(8);
		
		// Illustrating ready() method - tells whether the stream is ready to be read
		if (br.ready()) {
			System.out.println("Read line after skipping 8: " + br.readLine());
			br.read(c);
			for (int i = 0; i < c.length; i++) {
				System.out.println(c[i]);
			}
			System.out.println();
			
			/* Illustrating the reset() method - resets the stream to the most recent mark which in 
			 * this case is back to the beginning. */
			br.reset();
			for (int i = 0; i < 9; i++) {
				/* Illustrating the read() method - should print out the characters of first word 
				 * in the passage. */
				System.out.println((char)br.read());
			}
		}
		br.close();
	}
}
