package org.example.util;

import java.io.*;
import java.nio.file.Path;

public class ReaderInitializer {

    public static BufferedReader getReader (Path path){
        try (FileReader in = new FileReader(path.toString());
             BufferedReader br = new BufferedReader(in)) {
            return br;
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
