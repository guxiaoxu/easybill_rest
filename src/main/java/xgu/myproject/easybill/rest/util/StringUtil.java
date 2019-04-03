package xgu.myproject.easybill.rest.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class StringUtil {

    private static final byte[] HEX_CHAR_TABLE = { (byte) '0', (byte) '1', (byte) '2', (byte) '3', (byte) '4', (byte) '5',
            (byte) '6', (byte) '7', (byte) '8', (byte) '9', (byte) 'a', (byte) 'b', (byte) 'c', (byte) 'd', (byte) 'e',
            (byte) 'f' };

    public static final String METHOD_MD5 = "MD5";
    public static final String METHOD_SHA = "SHA-256";

    public static String generateUUID() {
        String uuid = UUID.randomUUID().toString();
        return getHashString(uuid, METHOD_SHA);
    }

    public static String getMD5String(String str) {
        return getHashString(str, METHOD_MD5);
    }

    public static String getHashString(String str, String method) {
        try {
            MessageDigest digest = MessageDigest.getInstance(method);
            digest.reset();
            digest.update(str.getBytes(Charset.forName("UTF8")));
            return getHexString(digest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }


    public static String getHexString(byte[] raw) {
        byte[] hex = new byte[2 * raw.length];
        int index = 0;

        for (byte b : raw) {
            int v = b & 0xFF;
            hex[index++] = HEX_CHAR_TABLE[v >>> 4];
            hex[index++] = HEX_CHAR_TABLE[v & 0xF];
        }
        return new String(hex, Charset.forName("UTF8"));
    }

    public static boolean isEmpty(String str){
        if(str == null){
            return true;
        }
        return "".equals(str);
    }
}
