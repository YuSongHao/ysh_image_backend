package utils;

import pojo.Image;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ：yusonghao
 * @date ：Created in 2021/6/27 15:56
 * @description：file utils for write and read
 */
public class FileUtils {

    public static void saveImage(Image image, String savePath) throws IOException {
        try(FileOutputStream fileOutputStream = new FileOutputStream(new File(savePath))) {
            fileOutputStream.write(image.getImageByteArray());
        }
    }
}
