package org.example.file;


import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class WriterInitializer {

    public static StandardOpenOption[] FILE_WRITE_OPTIONS = {StandardOpenOption.CREATE};

    public static BufferedWriter getWriter(Path path) throws IOException {

        return Files.newBufferedWriter(path, FILE_WRITE_OPTIONS);

    }
}
