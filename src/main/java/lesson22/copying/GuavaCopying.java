package lesson22.copying;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

public class GuavaCopying implements Copy {
    @Override
    public void copy(String from, String to) throws IOException {
        File fileToCopy = new File(from);
        File newFile = new File(to);

        Files.copy(fileToCopy, newFile);
    }
}
