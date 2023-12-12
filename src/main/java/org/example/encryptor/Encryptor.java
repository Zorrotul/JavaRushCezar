package org.example.encryptor;

import org.example.configuration.Configuration;
import org.example.configuration.OperatingMode;
import org.example.resourse.Alphabet;
import org.example.file.ReaderInitializer;
import org.example.file.WriterInitializer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Encryptor implements CezarConsumer {

    @Override
    public void accept(Configuration cfg) {// передавать толь
        try (BufferedReader br = ReaderInitializer.getReader(Path.of(cfg.getInputFile()));
             BufferedWriter bw = WriterInitializer.getWriter(Path.of(cfg.getOutputFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                char[] charFromLine = line.toCharArray();
                char[] charToWrite = new char[charFromLine.length];
                for (int i = 0; i < charFromLine.length; i++) {
                    charToWrite[i] = Alphabet.getEncodedChar(cfg.getKey(), charFromLine[i]);
                }
                bw.write(charToWrite);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OperatingMode> myOperationMode() {
        return List.of(OperatingMode.ENCRYPTION_WITH_KEY,OperatingMode.DECODER);
    }
}
