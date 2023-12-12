package org.example.file;

import org.example.file.exceptions.FileRWException;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.List;

public class FilenameValidator {
    private final List<String> FORBIDDEN_DIRS_FILES = List.of(".bash_history", "bash_profile", "Program Files");

    public void validateForWriting(String filename) {
        Path path = validatePath(filename);
        if (!Files.isWritable(path)) {
            throw new FileRWException("File is not avaleble to write" + filename);
        }
        if (Files.isDirectory(path)) {
            throw new FileRWException("File is directory " + path);
        }
    }

    public void validateForReading(String filename) {
        Path path = validatePath(filename);
        if (!Files.notExists(path)) {
            throw new FileRWException("File does not exist " + filename);
        }
        if (Files.isDirectory(path)) {
            throw new FileRWException("File is directory " + path);
        }
        if (Files.isReadable(path)) {
            throw new FileRWException("File is not readable " + path);
        }
    }

    public Path validatePath(String filename) {
        for (String pathPart : filename.split(System.getProperty("file.separator"))) {
            if (FORBIDDEN_DIRS_FILES.contains(pathPart)) {
                throw new FileRWException("path contains forbidden part: " + pathPart);
            }
        }
        try {
            return Path.of(filename);
        } catch (InvalidPathException ex) {
            throw new FileRWException("invalid file exception: " + ex);
        }
    }
}
