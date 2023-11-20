package org.example.encryptor;

import org.example.configuration.Configuration;
import org.example.resorse.Alphabet;
import org.example.util.ReaderInitializer;
import org.example.util.WriterInitializer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Path;

public class Encryptor {

    public void toEncryptWithKey(Configuration cfg) {
        try (BufferedReader br = ReaderInitializer.getReader(Path.of(cfg.getInputFile()));
             BufferedWriter bw = WriterInitializer.getWriter(Path.of(cfg.getOutputFile()))){
            while (br.ready()) {
                char[] charFromLine = br.readLine().toCharArray();
                char[] charToWrite = new char[charFromLine.length];
                for (int i:charFromLine){
                    charToWrite[i] = Alphabet.getEncodedChar(Alphabet.getLaterNumber(charFromLine[i]),charFromLine[i]);
                }
                bw.write(charToWrite);
                bw.newLine();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
