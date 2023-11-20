package org.example.configuration;

import java.util.stream.Stream;

public enum OperatingMode {
    ENCRYPTION("-e"),
    ENCRYPTIONWITHKEY("-ek"),
    BRUTEFORCE("-bf"),
    STATISTICALANALYSIS("-sa");

    final String code;

    OperatingMode(String code){
    this.code= code;
    }

    public static OperatingMode getOperatingMode(String code) {
        return Stream.of(OperatingMode.values())
                .filter(fileContentType -> fileContentType.code.equals(code))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("no supported mode " + code));
    }
}
