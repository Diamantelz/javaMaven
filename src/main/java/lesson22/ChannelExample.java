package lesson22;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelExample {
    public static final int BSIZE = 1024;
    public static void main(String[] args) {
        try {
            // Запись в файл:
            FileChannel fc = new FileOutputStream("data.txt").getChannel();
            fc.write(ByteBuffer.wrap("a little bit of text ".getBytes()));
            fc.close();

            // Добавление в конец файла:
            fc = new RandomAccessFile("data.txt", "rw").getChannel();
            fc.position(fc.size()); // переходим в конец
            fc.write(ByteBuffer.wrap("some more text".getBytes()));
            fc.close();

            // Чтение файла:
            fc = new FileInputStream("data.txt").getChannel();
            ByteBuffer buff = ByteBuffer.allocate(BSIZE); // задается размер буферу
            fc.read(buff);
            buff.flip(); //
            while(buff.hasRemaining()) {
                System.out.print((char) buff.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
