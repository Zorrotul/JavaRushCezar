package org.example.configuration;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public enum OperatingMode {
    ENCRYPTION("-e", args->args[1]),
    ENCRYPTION_WITH_KEY("-ek",args->args[2]),
    BRUTEFORCE("-bf",args->args[2]),
    STATISTICAL_ANALYSIS("-sa",args->args[2]),
    DECODER("-d",args->args[2]);

    final String code;
    public Function<String[], String> getMyInputFile;

    OperatingMode(String code,Function<String[], String> getMyInputFile) {
        this.code = code;
        this.getMyInputFile = getMyInputFile;
    }

    public static OperatingMode getOperatingMode(String code) {
        return Stream.of(OperatingMode.values())
                .filter(operatingMode -> operatingMode.code.equals(code))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("no supported mode " + code));
    }

}
