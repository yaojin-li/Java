package aesUtil;

/**
 * @Description:
 * --------------------------------------
 * @ClassName: SecurityUtil.java
 * @Date: 2020/10/30 16:18
 * @SoftWare: IntelliJ IDEA
 **/
import java.io.UnsupportedEncodingException;

public class SecurityUtil {
    public SecurityUtil() {
    }

    public static String encodeMessage(String messageToEncode, String password) {
        if (isValid(messageToEncode) && isValid(password)) {
            AES aes = new AES();

            byte[] resultbyte;
            try {
                resultbyte = aes.encrypt(messageToEncode.getBytes("utf-8"), password.getBytes("utf-8"));
            } catch (UnsupportedEncodingException var5) {
                var5.printStackTrace();
                return null;
            }

            return HexByteConvertUtil.bytesToHexString(resultbyte);
        } else {
            return null;
        }
    }

    public static String decodeMessage(String messageToDecode, String password) {
        if (isValid(messageToDecode) && isValid(password)) {
            AES aes = new AES();
            String result = null;

            try {
                byte[] resultByte = aes.decrypt(HexByteConvertUtil.hexStringToBytes(messageToDecode), password.getBytes("utf-8"));
                result = new String(resultByte, "utf-8");
                return result;
            } catch (UnsupportedEncodingException var6) {
                var6.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }
    public static boolean isValid(String checkMessage) {
        return checkMessage != null && checkMessage != "";
    }

    public static void main(String[] args) {
        String test = "test";
        String pass = "aescodespassword";
        System.out.println("明文："+ test);

        String enRes = SecurityUtil.encodeMessage(test, pass);
        System.out.println("密文：" + enRes);

        String deRes = SecurityUtil.decodeMessage(enRes, pass);
        System.out.println("解密：" + deRes);

    }

}
