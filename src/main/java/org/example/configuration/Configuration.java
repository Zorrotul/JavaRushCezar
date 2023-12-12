package org.example.configuration;

import static org.example.resourse.Alphabet.ALPHABET_LENGTH;

public class Configuration {
    private final OperatingMode mode;
    private final short key;
    private final String inputFile;
    private final String outputFile;

    public Configuration(String[] args) {
        this.mode = OperatingMode.getOperatingMode(args[0]);
        this.inputFile = mode.getMyInputFile.apply(args);
        if (mode == OperatingMode.ENCRYPTION) {
            this.key = 4;
      //      this.inputFile = args[1];
            this.outputFile = args[2];
        } else if (mode == OperatingMode.ENCRYPTION_WITH_KEY) {
            this.key = Short.parseShort(args[1]);
        //    this.inputFile = args[2];
            this.outputFile = args[3];
        } else if (mode == OperatingMode.BRUTEFORCE) {
            this.key = 0;
      //      this.inputFile = args[1];
            this.outputFile = args[2];
        } else if (mode == OperatingMode.STATISTICAL_ANALYSIS) {
            this.key = 0;
     //       this.inputFile = args[1];
            this.outputFile = args[2];
        } else if (mode == OperatingMode.DECODER) {
            this.key = (short) (Math.abs(Short.parseShort(args[1]) - ALPHABET_LENGTH));
        //    this.inputFile = args[2];
            this.outputFile = args[3];
        } else throw new RuntimeException("wrong operating mode");

        //switch (mode) {
        //    case ENCRYPTION:
        //        this.key = 4;
        //    case BRUTEFORCE:
        //        this.key = 5;
        //    case ENCRYPTIONWITHKEY:
        //        this.key = Short.parseShort(args[0]);
        //}
    }

    public short getKey() {
        return key;
    }

    public String getInputFile() {
        return inputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public OperatingMode getMode() {
        return this.mode;
    }
}

