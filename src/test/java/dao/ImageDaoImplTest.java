package dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pojo.Image;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ImageDaoImplTest {
    private static final Log LOG = LogFactory.getLog(ImageDaoImplTest.class);

    private Image imageA = new Image("证件照","ysh","C:\\Users\\user\\Desktop\\简历2寸蓝底.jpg");
    private Image imageB = new Image("驾照","ysh","C:\\Users\\user\\Desktop\\驾照1.jpg");
    private ImageDaoImpl  imageDaoImpl = new ImageDaoImpl();

    @Test
    void insert() {
        imageDaoImpl.insert(imageA);
        showTable();
    }

    @Test
    void delete() {
        imageDaoImpl.delete(imageA.getImageName());
        showTable();
    }

    @Test
    void update() {
        imageDaoImpl.update(imageA.getImageName(), imageB);
        showTable();
    }

    @Test
    void selectByName() {
        imageDaoImpl.selectByName(imageB.getImageName());
        showTable();
    }

    void showTable(){
        List<Image> list = imageDaoImpl.selectByGroup("ysh");
        for (int i = 0; i < list.size(); i++) {
            LOG.info(list.get(i).toString());
        }
    }
}