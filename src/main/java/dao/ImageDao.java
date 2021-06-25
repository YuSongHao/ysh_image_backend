package dao;

import pojo.Image;

import java.util.List;

public interface ImageDao {

    public int insert(Image image);

    public int delete(String name);

    public int update(String name, Image newImage);
    
    public Image selectByName(String name);

    public List<Image> selectByGroup(String group);
}
