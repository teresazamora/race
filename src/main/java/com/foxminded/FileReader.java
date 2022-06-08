package com.foxminded;

import static java.nio.file.Files.lines;
import static java.nio.file.Paths.get;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {

    public List<String> readFile(String filename) {
        List<String> content;
        try {
            content = lines(get(getClass().getClassLoader().getResource(filename).toURI())).collect(Collectors.toList());
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return content;
    }
}
