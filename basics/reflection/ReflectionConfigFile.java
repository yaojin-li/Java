package reflection;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @Description: 通过反射运行配置文件内容
 * 我们利用反射和配置文件，可以使应用程序更新时，对源码无需进行任何修改。
 * 我们只需要将新类发送给客户端，并修改配置文件即可。
 * --------------------------------------
 * @ClassName: ReflectionConfigFile.java
 * @Date: 2020/2/22 16:51
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class ReflectionConfigFile {

    public static void main(String[] args) throws Exception {
        // 1. 通过反射获取Class对象
        Class stuClass = Class.forName(getValue("className"));  //"cn.fanshe.Student"
        // 2. 获取show()方法
        Method m = stuClass.getMethod(getValue("methodName"));  //show
        // 3. 调用show()方法
        m.invoke(stuClass.getConstructor().newInstance());

    }

    /**
     * 此方法接收一个key，在配置文件中获取相应的value
     */
    public static String getValue(String key) throws IOException {
        // 获取配置文件的对象
        Properties pro = new Properties();
        // 获取输入流
        FileReader in = new FileReader("D:\\ZX_workspace\\Java\\basics\\reflection\\config.txt");
        // 将流加载到配置文件对象中
        pro.load(in);
        in.close();
        // 返回根据key获取的value值
        return pro.getProperty(key);
    }

}
