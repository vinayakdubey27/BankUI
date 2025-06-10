package io;

import java.io.*;
import java.util.*;

public class FileHandler {
    private static final String FILE_PATH = "data/accounts.txt";

    public List<String> readLines() throws IOException {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
            return new ArrayList<>();
        }

        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while((line = br.readLine()) != null) {
                if(!line.trim().isEmpty())
                    lines.add(line.trim());
            }
        }
        return lines;
    }

    public void writeLines(List<String> lines) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for(String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        }
    }
}
