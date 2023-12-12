package org.example.encryptor;

import org.example.configuration.Configuration;
import org.example.configuration.OperatingMode;

import java.util.List;
import java.util.function.Consumer;

public interface CezarConsumer extends Consumer<Configuration> {
    List<OperatingMode> myOperationMode();
}
