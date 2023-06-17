package lesson22.copying;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class FileChannelTransferCopying implements Copy {

    @Override
    public void copy(String from, String to) throws IOException {
        File fileToCopy = new File(from);
        FileInputStream inputStream = new FileInputStream(fileToCopy);
        FileChannel inChannel = inputStream.getChannel();

        File newFile = new File(to);
        FileOutputStream outputStream = new FileOutputStream(newFile);
        FileChannel outChannel = outputStream.getChannel();

        inChannel.transferTo(0, fileToCopy.length(), outChannel);

        inputStream.close();
        outputStream.close();
    }
}
