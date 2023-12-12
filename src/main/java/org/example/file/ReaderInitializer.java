package org.example.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class ReaderInitializer {

    public static BufferedReader getReader(Path path) throws IOException {
        FileReader in = new FileReader(path.toString());
        return new BufferedReader(in);
    }
}
