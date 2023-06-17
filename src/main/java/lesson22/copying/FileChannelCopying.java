package lesson22.copying;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelCopying implements Copy {
    private static final int BSIZE = 1024;

    @Override
    public void copy(String from, String to) throws IOException {
        FileChannel in = new FileInputStream(from).getChannel(),
                out = new FileOutputStream(to).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        while (in.read(buffer) != -1) {
            buffer.flip(); // Подготовим для записи
            out.write(buffer);
            buffer.clear(); // Подготовим для чтения
        }
        in.close();
        out.close();
    }
}
