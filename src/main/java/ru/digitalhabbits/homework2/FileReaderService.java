package ru.digitalhabbits.homework2;

import lombok.SneakyThrows;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReaderService implements FileReader {
    @Override
    @SneakyThrows
    public Stream<String> readLines(File file) {
        Stream<String> lines = Files.lines(Paths.get(file.toURI()), StandardCharsets.UTF_8);
        return lines;
    }
}
