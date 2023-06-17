package lesson22.copying;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtilsCopying implements Copy {
    @Override
    public void copy(String from, String to) throws IOException {
        File fileToCopy = new File(from);
        File newFile = new File(to);

        FileUtils.copyFile(fileToCopy, newFile);

        IOUtils.copy(new FileInputStream(fileToCopy), new FileOutputStream(newFile));
    }
}
