package service;

import dao.ImageDaoImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import pojo.Image;
import utils.FileUtils;

import java.io.IOException;

/**
 * @author ：yusonghao
 * @date ：Created in 2021/6/27 15:47
 * @description：downLoad images service
 */
@YshService
public class DownloadService {

    private static final Log log = LogFactory.getLog(DownloadService.class);
    private static final ImageDaoImpl yshImageTable = new ImageDaoImpl();

    public static void downloadImage(String srcPath, String desPath) throws IOException {
        Image srcImage = yshImageTable.selectByName(srcPath);
        FileUtils.saveImage(srcImage, desPath);
    }
}
