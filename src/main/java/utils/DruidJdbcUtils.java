package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import pojo.Image;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * @author : yusonghao
 * @description : 获取properties中的配置信息
 * @create : 2021-06-24
 */
public class DruidJdbcUtils {

    private static final Log LOG = LogFactory.getLog(DruidJdbcUtils.class);
    private static final String PROPERTIES_NAME = "druid.properties";
    private static Properties properties;

    static {
        try {
            properties = new Properties();
            InputStream input = DruidJdbcUtils.class.getClassLoader().getResourceAsStream(PROPERTIES_NAME);
            properties.load(input);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    public static Connection getConnection(){
        try {
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection connection = dataSource.getConnection();
            return connection;
        }catch (Exception e) {
            LOG.error(e.getMessage(),e);
        }
        return null;
    }

    public static int insert(Image image) {
        Connection connection = getConnection();
        String sql = "insert into ysh_image_tb(image_name, image_group, upload_date, image) values(?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,image.getImageName());
            ps.setString(2, image.getImageGroup());
            ps.setDate(3,image.getDate());
            ps.setBytes(4,image.getImageByteArray());
            return ps.executeUpdate();
        } catch (Throwable t){
            LOG.error(t.getMessage(), t);
        } finally {
            DruidJdbcUtils.close(connection, ps, null);
        }
        return 0;
    }

    public static int delete(String name) {
        Connection connection = getConnection();
        String sql = "delete from ysh_image_tb where image_name=\"" + name + "\" ";
        LOG.info(sql);
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            return ps.executeUpdate();
        } catch (Throwable t){
            LOG.error(t.getMessage(), t);
        } finally {
            DruidJdbcUtils.close(connection, ps, null);
        }
        return 0;
    }

    public static int update(String name, Image image) {
        delete(name);
        return insert(image);
    }

    public static Image selectByName(String name){
        Connection connection = getConnection();
        String sql = "select * from ysh_image_tb where image_name=\"" + name + "\"";
        LOG.info(sql);
        PreparedStatement ps = null;
        ResultSet rs = null;
        Image result = null;
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()){
                result = new Image(rs.getString(2),rs.getString(3),rs.getDate(4),rs.getBytes(5));
            }
        } catch (Throwable t){
            LOG.error(t.getMessage(), t);
        } finally {
            DruidJdbcUtils.close(connection, ps, null);
        }
        return result;
    }

    public static List<Image> selectByGroup(String group){
        Connection connection = getConnection();
        String sql = "select * from ysh_image_tb where image_group=\"" + group + "\"";
        LOG.info(sql);
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Image> result = new LinkedList<>();
        try {
            assert connection != null;
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                result.add(new Image(rs.getString(2),rs.getString(3),rs.getDate(4), rs.getBytes(5)));
            }
        } catch (Throwable t){
            LOG.error(t.getMessage(), t);
        } finally {
            DruidJdbcUtils.close(connection, ps, null);
        }
        return result;
    }


    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
