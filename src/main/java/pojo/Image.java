package pojo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.sql.Date;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author : yusonghao
 * @description : presonal images
 * @create : 2021-06-24
 */
public class Image {


    private String imageName;
    private String imageGroup;
    private Date date;
    private byte[] imageByteArray;

    public Image(String imageName, String imageGroup, Date date,
            byte[] imageByteArray) {
        this.imageName = imageName;
        this.imageGroup = imageGroup;
        this.date = date;
        this.imageByteArray = imageByteArray;
    }

    public Image(String imageName, String imageGroup, String imagePath){
        this.imageName = imageName;
        this.imageGroup = imageGroup;
        this.date = new Date(System.currentTimeMillis());

        try(FileInputStream fileInputStream = new FileInputStream(new File(imagePath))) {
            File file = new File(imagePath);
            ByteBuffer nbf = ByteBuffer.allocate((int) file.length());
            byte[] arr = new byte[1024];
            int length = 0;
            while((length = fileInputStream.read(arr)) > 0){
                nbf.put(arr, 0, length);
            }
            imageByteArray = nbf.array();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageGroup() {
        return imageGroup;
    }

    public void setImageGroup(String imageGroup) {
        this.imageGroup = imageGroup;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public byte[] getImageByteArray() {
        return imageByteArray;
    }

    public void setImageByteArray(byte[] imageByteArray) {
        this.imageByteArray = imageByteArray;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Image image = (Image) o;
        return Objects.equals(imageName, image.imageName) && Objects
                .equals(imageGroup, image.imageGroup) && Objects
                .equals(date, image.date) && Arrays
                .equals(imageByteArray, image.imageByteArray);
    }

    @Override public int hashCode() {
        int result = Objects.hash(imageName, imageGroup, date);
        result = 31 * result + Arrays.hashCode(imageByteArray);
        return result;
    }

    @Override public String toString() {
        return "Image{" + "imageName='" + imageName + '\'' + ", imageGroup='"
                + imageGroup + '\'' + ", date=" + date + ", imageByteArray="
                + imageByteArray.length + '}';
    }
}
