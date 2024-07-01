package io_stream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

public class IO_Stream_UTF {
	public static void main(String[] args) throws IOException {
		InputStream fileInputStream2 = new FileInputStream("src/io_stream/myFile2");
		Reader inputStreamReader2 = new InputStreamReader(fileInputStream2, Charset.forName("UTF-8"));
		int fileData2 = inputStreamReader2.read();
		System.out.println("\nFile-1 Data...\n");
		while (fileData2 != -1) {
			System.out.println("fileData integer representation : " + fileData2 + ", filedata char : " + (char) fileData2);
			fileData2 = inputStreamReader2.read();
		}
		inputStreamReader2.close();
	}
}
