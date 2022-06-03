package com.foxminded;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReaderFile {

    public List<String> readFile(String fileName) {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL url = classLoader.getResource(fileName);
        File file = new File(url.getFile());
        List<String> text = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(file.getAbsolutePath()))) {
            text = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}
