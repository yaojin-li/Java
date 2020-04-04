package commonFunctions;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

/**
 * @Description: 文件相关
 * 1. 将图片文件转化为字节数组字符串
 * 2. 对字符数组进行 Base64 编码处理
 * 3. 对加密字符串进行 Base64 解码处理
 * 4.
 * --------------------------------------
 * @ClassName: commonFunctions.TestFile.java
 * @Date: 2019/11/11 14:14
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/

public class TestFile {
    public static void main(String[] args) {
        // ##################################################################
        String inputImgFile = "e:\\test.png";
        String outputImgFile = "d:\\result.jpg";

        // 1. get image bytes
        byte[] imageBytes = getImageBytes(inputImgFile);

        // 2. base64 encode
        String encodeImageStr = base64Encode(imageBytes);

        // 3. base64 decode
        byte[] decodeImageBytes = decodeImageBytes(encodeImageStr);

        // 4. generate image file
        genImgFile(decodeImageBytes, outputImgFile);
        // ##################################################################



    }

    /**
     * @Description: 将图片文件转化为字节数组
     * @Date: 2019/12/9 21:16
     * @param: inputImgFile 输入文件  eg: "e:\\3.png";
     * @ReturnType: byte[] data 输入文件对应的字符数组
     **/
    public static byte[] getImageBytes(String inputImgFile) {
        InputStream in = null;
        byte[] data = null;
        // 读取图片字节数组
        try {
            in = new FileInputStream(inputImgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }


    /**
     * @Description: 对字符数组进行 Base64 编码处理
     * @Date: 2019/12/9 21:15
     * @param: data 待加密的字符数组
     * @ReturnType: java.lang.String base64 编码后的字符串
     **/
    public static String base64Encode(byte[] data) {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }


    /**
     * @Description: 对加密字符串进行 Base64 解码处理
     * @Date: 2019/12/9 21:12
     * @param: encodeImgStr 加密字符串
     * @ReturnType: byte[] 解码输出的字节数组
     **/
    public static byte[] decodeImageBytes(String encodeImgStr) {
        if (encodeImgStr == null) {
            return new byte[]{};
        }
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] data = decoder.decodeBuffer(encodeImgStr);
            for (int i = 0; i < data.length; ++i) {
                // 调整异常数据
                if (data[i] < 0) {
                    data[i] += 256;
                }
            }
            return data;
        } catch (Exception e) {
            return new byte[]{};
        }
    }


    /**
     * @Description: 将字节数组转化为图片文件
     * @Date: 2019/12/9 21:14
     * @param: data 二进制数据
     * @param: outImgFilePath 输出图片 eg: "d:\\new.jpg"
     * @ReturnType: void
     **/
    public static void genImgFile(byte[] data, String outImgFilePath) {
        try {
            OutputStream out = new FileOutputStream(outImgFilePath);
            out.write(data);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}