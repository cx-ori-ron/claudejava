package claudejava;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HelloWorld {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Main <file-path>");
            return;
        }

        String inputPath = args[0];
        Path filePath = Paths.get(inputPath);

        try {
            String content = Files.readString(Paths.get("./sqlite-migrations/" + filePath));

            System.out.println("File content:");
            System.out.println(content);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

    }

}

