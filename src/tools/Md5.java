package tools;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5 {

    public String Encode(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(str.getBytes());
        String newStr = new BigInteger(1,messageDigest.digest()).toString(16);
        return newStr;
    }
}
