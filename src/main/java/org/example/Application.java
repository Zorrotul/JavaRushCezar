package org.example;

import org.example.configuration.Configuration;
import org.example.encryptor.Encryptor;

public class Application {
    public static void main(String[] args) {

        String[] testString =new String[2];
        testString[0]= "1";
        testString[1] = "inputFile.txt";
        testString[2] = "outputFile.txt";
        Configuration cfg = new Configuration(testString);
        Encryptor encryptor = new Encryptor();
        encryptor.toEncryptWithKey(cfg);
    }
}