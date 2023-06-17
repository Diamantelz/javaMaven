package lesson22.copying;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileCopyingNIO implements Copy {
    @Override
    public void copy(String from, String to) throws IOException {
        Path sourceFile = Paths.get(from);
        Path targetFile = Paths.get(to);
        try {
            Files.copy(sourceFile, targetFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
