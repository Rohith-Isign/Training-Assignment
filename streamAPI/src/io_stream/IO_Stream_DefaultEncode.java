package io_stream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class IO_Stream_DefaultEncode {
	public static void main(String[] args) throws IOException {
		InputStream fileInputStream = new FileInputStream("src/io_stream/myFile1");
		Reader inputStreamReader = new InputStreamReader(fileInputStream);
		int fileData = inputStreamReader.read();
		System.out.println("File-1 Data...\n");
		while(fileData!=-1) {
			System.out.println("fileData integer representation : " +fileData+", filedata char : "+(char)fileData);
			fileData = inputStreamReader.read();
		}
		 inputStreamReader.close();
	}
}
