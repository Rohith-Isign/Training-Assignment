package io_stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class FileCopyExample {
    public static void main(String[] args) {
        String sourceFile = "src/io_stream/myFile1";
        String destinationFileASCII = "src/io_stream/destination.txt";
        String destinationFileUTF8 = "src/io_stream/destination_utf8.txt";
        Reader reader = null;
        Writer writerASCII = null;
        Writer writerUTF8 = null;

        try {
            reader = new InputStreamReader(new FileInputStream(sourceFile), StandardCharsets.UTF_8);

            writerASCII = new OutputStreamWriter(new FileOutputStream(destinationFileASCII), StandardCharsets.US_ASCII);

            writerUTF8 = new OutputStreamWriter(new FileOutputStream(destinationFileUTF8), StandardCharsets.UTF_8);

            char[] buffer = new char[1024];
            int charsRead;

            while ((charsRead = reader.read(buffer)) != -1) {
                writerASCII.write(buffer, 0, charsRead);
                writerUTF8.write(buffer, 0, charsRead);

                for (int i = 0; i < charsRead; i++) {
                	
                    System.out.println("ASCII value: " +  buffer[i] + ", Character: " + buffer[i] +
                                       "\t UTF-8 value: " +  buffer[i] + ", Character: " + buffer[i]);
                }
            }

            System.out.println("\nFile copied successfully with ASCII and UTF-8 encoding!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) reader.close();
                if (writerASCII != null) writerASCII.close();
                if (writerUTF8 != null) writerUTF8.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
