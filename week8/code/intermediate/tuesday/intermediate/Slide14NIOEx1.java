package tuesday.intermediate;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class Slide14NIOEx1 {
	public static void main(String[] args) throws IOException {
		FileInputStream input = new FileInputStream("sample5.txt");
		ReadableByteChannel source = input.getChannel();
		
		FileOutputStream output = new FileOutputStream("sampleTo6.txt");
		WritableByteChannel destination = output.getChannel();
		
		copyData(source, destination);
		
		destination.close();
		output.close();
		source.close();
		input.close();
	}
	
	private static void copyData(ReadableByteChannel src, WritableByteChannel dest) throws IOException {
		ByteBuffer buffer = ByteBuffer.allocateDirect(20 * 1024);
		
		while (src.read(buffer) != -1) {
			buffer.flip(); // The buffer is used to drain
			
			while (buffer.hasRemaining()) { // Make sure that buffer is fully drained
				dest.write(buffer);
			}
			buffer.clear();
		} // Now the buffer is empty, ready for filling
	}
}
