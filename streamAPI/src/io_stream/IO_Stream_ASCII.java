package io_stream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class IO_Stream_ASCII {

	 public static void main(String[] args) throws IOException {
	        InputStream fileInputStream = new FileInputStream("src/io_stream/MyFileASCII");
	        

	        Reader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.US_ASCII);

	        int fileData = inputStreamReader.read();

	        System.out.println("File-1 Data...\n");

	        while (fileData != -1) {
	            System.out.println("fileData ASCII: " + fileData + ", fileData char: " + (char) fileData);

	            fileData = inputStreamReader.read();
	        }

	        inputStreamReader.close();
	    }
}
