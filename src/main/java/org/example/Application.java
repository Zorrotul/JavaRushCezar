package org.example;

import org.example.configuration.Configuration;
import org.example.encryptor.CezarConsumer;
import org.example.encryptor.Encryptor;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        List<CezarConsumer> consumers = List.of(new Encryptor());
        String[] testString = new String[4];
        testString[0] = "-ek";
        testString[1] = "10";
        testString[2] = "inputFile.txt";
        testString[3] = "outputFile.txt";
        Configuration cfg = new Configuration(testString);
        consumers.stream()
                .filter(cezarConsumer -> cezarConsumer.myOperationMode().contains(cfg.getMode()))
                .findFirst()
                .ifPresentOrElse(
                        cezarConsumer -> cezarConsumer.accept(cfg),
                        () -> {
                            throw new RuntimeException("нет реализации для " + cfg.getMode().name());
                        }
                );
        //encryptor.toEncryptWithKey(cfg);
        //String[] decodeString = new String[4];
        //decodeString[0] = "-d";
        //decodeString[1] = "10";
        //decodeString[2] = "outputFile.txt";
        //decodeString[3] = "outputFileDecode.txt";
        //Configuration decodeCfg = new Configuration(decodeString);
        //Encryptor encryptor2 = new Encryptor();
        //encryptor2.toEncryptWithKey(decodeCfg);
    }
}