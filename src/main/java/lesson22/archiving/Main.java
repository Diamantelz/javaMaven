package lesson22.archiving;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) {
        try {
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream("archive.zip"));
            pack("data.txt", out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ZipInputStream in = new ZipInputStream(new BufferedInputStream(new FileInputStream("archive.zip")));
            ZipEntry entry;
            while ((entry = in.getNextEntry()) != null) {
                unpack(in, entry.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // упаковка по названию
    public static void pack(String fin, ZipOutputStream out) throws IOException {
        FileInputStream in = new FileInputStream(fin);
        out.putNextEntry(new ZipEntry(fin));
        // сжатие
        int c;
        while((c = in.read()) != -1)
            out.write(c);
        in.close();
    }

    public static void unpack(ZipInputStream in, String out) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(out)); // выходной поток
        int c;
        while((c = in.read()) != -1) {
            bos.write(c);
        }
        bos.close();
    }
}
