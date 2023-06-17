package lesson22.copying;

import java.io.*;

public class CopyBufferIO implements Copy {

    @Override
    public void copy(String from, String to) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(from));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(to));
        int c;
        while (true) {
            c = bis.read();
            if (c != -1) {
                bos.write(c);
            } else {
                break;
            }
        }
        bis.close();
        bos.flush();
        bos.close();
    }
}
