package lesson22.copying;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        CopyBufferIO bufferIO = new CopyBufferIO();
        FileChannelCopying channelCopying = new FileChannelCopying();
        FileCopyingNIO copyingNIO = new FileCopyingNIO();
        FileChannelTransferCopying transferCopying = new FileChannelTransferCopying();
        FileUtilsCopying fileUtilsCopying = new FileUtilsCopying();
        GuavaCopying guavaCopying = new GuavaCopying();
        try {
            long start1 = System.currentTimeMillis();
            bufferIO.copy("/Users/diamantelz/Desktop/Files/Meeting_20221105.mp4", "CopiedFile.zip");
            long end1 = System.currentTimeMillis();
            System.out.println("CopyBufferIO: " + (end1 - start1));

            long start2 = System.currentTimeMillis();
            channelCopying.copy("/Users/diamantelz/Desktop/Files/Meeting_20221105.mp4", "CopiedFile.zip");
            long end2 = System.currentTimeMillis();
            System.out.println("FileChannelCopying: " + (end2 - start2));

            long start3 = System.currentTimeMillis();
            transferCopying.copy("/Users/diamantelz/Desktop/Files/Meeting_20221105.mp4", "CopiedFile.zip");
            long end3 = System.currentTimeMillis();
            System.out.println("FileChannelTransferCopying: " + (end3 - start3));

            long start4 = System.currentTimeMillis();
            copyingNIO.copy("/Users/diamantelz/Desktop/Files/Meeting_20221105.mp4", "CopiedFile.zip");
            long end4 = System.currentTimeMillis();
            System.out.println("FileCopyingNIO: " + (end4 - start4));

            long start5 = System.currentTimeMillis();
            fileUtilsCopying.copy("/Users/diamantelz/Desktop/Files/Meeting_20221105.mp4", "CopiedFile.zip");
            long end5 = System.currentTimeMillis();
            System.out.println("FileUtilsCopying: " + (end5 - start5));

            long start6 = System.currentTimeMillis();
            guavaCopying.copy("/Users/diamantelz/Desktop/Files/Meeting_20221105.mp4", "CopiedFile.zip");
            long end6 = System.currentTimeMillis();
            System.out.println("GuavaCopying: " + (end6 - start6));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
