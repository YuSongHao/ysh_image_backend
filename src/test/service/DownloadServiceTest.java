package service;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class DownloadServiceTest {

    @Test
    void downloadImage() throws IOException {
        DownloadService.downloadImage("C:\\Users\\jasonyu\\Desktop\\wallpaper_ext.jpg", "C:\\Users\\jasonyu\\Desktop\\123.jpg");
    }

    @Test
    void downloadImageAndDecrypt() throws IOException {
        DownloadService.downloadImage("C:\\Users\\jasonyu\\Desktop\\wallpaper_ext.jpg", "C:\\Users\\jasonyu\\Desktop\\123.jpg");
    }
}