package utils;

import java.io.File;

/**
 * @author ：yusonghao
 * @date ：Created in 2021/6/27 16:32
 * @description：
 */
public class MysqlQueryUtils {

    public static String formatPathname(String input){
        String pattern = File.separator + File.separator;
        String[] strings = input.split(pattern);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length - 1; i++) {
            stringBuilder.append(strings[i]).append(pattern);
        }
        stringBuilder.append(strings[strings.length - 1]);
        return stringBuilder.toString();
    }
}
