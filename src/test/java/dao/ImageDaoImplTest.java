package dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import pojo.Image;

import java.util.List;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ImageDaoImplTest {
    private static final Log LOG = LogFactory.getLog(ImageDaoImplTest.class);

    private Image imageA = new Image("ysh","C:\\Users\\jasonyu\\Desktop\\wallpaper_ext.jpg");
    private Image imageB = new Image("ysh","C:\\Users\\jasonyu\\Desktop\\1-3.jpg");
    private ImageDaoImpl  imageDaoImpl = new ImageDaoImpl();

    @Test
    @Order(1)
    void insert() {
        imageDaoImpl.insert(imageA);
        showTable();
    }

    @Test
    @Order(4)
    void delete() {
        imageDaoImpl.delete(imageA.getImageName());
        showTable();
    }

    @Test
    @Order(2)
    void update() {
        imageDaoImpl.update(imageA.getImageName(), imageB);
        showTable();
    }

    @Test
    @Order(3)
    void selectByName() {
        imageDaoImpl.selectByName(imageB.getImageName());
        showTable();
    }

    void showTable(){
        List<Image> list = imageDaoImpl.selectByGroup("ysh");
        try {
            for (int i = 0; i < list.size(); i++) {
                LOG.info(list.get(i).toString());
            }
        } catch (Throwable t) {
            LOG.error(t.getMessage(), t);
        }
    }
}