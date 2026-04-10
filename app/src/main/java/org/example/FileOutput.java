package org.example;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutput {
    private String fileName;

    public FileOutput(String fileName) {
        this.fileName = fileName;
    }

    public void write(String scores) {
         try (FileOutputStream fos = new FileOutputStream(fileName)) {
            byte[] dataBytes = scores.getBytes();
            fos.write(dataBytes);
            System.out.println("Data successfully written to the file.");
        }
        catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } 
    }
}
