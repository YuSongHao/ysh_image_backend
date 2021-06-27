package dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import pojo.Image;
import utils.DruidJdbcUtils;

@TestMethodOrder(OrderAnnotation.class)
class ImageDaoImplTest {

    private Image imageA = new Image("ysh","C:\\Users\\jasonyu\\Desktop\\wallpaper_ext.jpg");
    private Image imageB = new Image("ysh","C:\\Users\\jasonyu\\Desktop\\1-3.jpg");
    private ImageDaoImpl  imageDaoImpl = new ImageDaoImpl();

    @Test
    @Order(1)
    void insert() {
        imageDaoImpl.insert(imageA);
        DruidJdbcUtils.showTable("ysh");
    }

    @Test
    @Order(4)
    void delete() {
        imageDaoImpl.delete(imageA.getImageName());
        DruidJdbcUtils.showTable("ysh");
    }

    @Test
    @Order(2)
    void update() {
        imageDaoImpl.update(imageA.getImageName(), imageB);
        DruidJdbcUtils.showTable("ysh");
    }

    @Test
    @Order(3)
    void selectByName() {
        imageDaoImpl.selectByName(imageB.getImageName());
        DruidJdbcUtils.showTable("ysh");
    }

    @Test
    @Order(5)
    void insertAndEncrypt(){
        imageDaoImpl.insertAndEncrypt(imageA);
    }

}