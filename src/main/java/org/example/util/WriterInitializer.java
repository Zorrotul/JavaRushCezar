package org.example.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class WriterInitializer {

    public static BufferedWriter getWriter(Path path) {
        try (FileWriter out = new FileWriter(path.toString());
             BufferedWriter bw = new BufferedWriter(out)) {
            return bw;// TODO: роверить так ли работает записывание в файл
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
