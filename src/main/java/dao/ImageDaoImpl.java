package dao;

import pojo.Image;
import utils.DruidJdbcUtils;

import java.util.List;

/**
 * @author : yusonghao
 * @description :
 * @create : 2021-06-24
 */
public class ImageDaoImpl implements ImageDao{
    @Override public int insert(Image image) {
        return DruidJdbcUtils.insert(image);
    }

    @Override public int delete(String name) {
        return DruidJdbcUtils.delete(name);
    }

    @Override public int update(String name, Image newImage) {
        return DruidJdbcUtils.update(name, newImage);
    }

    @Override public Image selectByName(String name) {
        return DruidJdbcUtils.selectByName(name);
    }

    @Override public List<Image> selectByGroup(String group) {
        return DruidJdbcUtils.selectByGroup(group);
    }
}
