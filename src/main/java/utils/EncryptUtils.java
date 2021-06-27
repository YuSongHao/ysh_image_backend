package utils;

/**
 * @author ：yusonghao
 * @date ：Created in 2021/6/27 16:42
 * @description：
 */
public class EncryptUtils {

    private static final byte XOR_KEY = 0x5a;

    /**
     * 亦或加解密方法
     * @param src, 字节数组
     */
    public static byte[] encryptOrDecryptByXor(byte[] src){
        for (int i = 0; i < src.length; i++) {
            src[i] = (byte)(src[i] ^ XOR_KEY);
        }
        return src;
    }
}
