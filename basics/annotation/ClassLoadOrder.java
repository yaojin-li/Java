package annotation;

/**
 * @Description: --------------------------------------
 * @ClassName: ClassLoadOrder.java
 * @Date: 2021/5/13 21:20
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class ClassLoadOrder {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取系统的类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2

        //获取系统类加载器的父类加载器-->扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);//sun.misc.Launcher$ExtClassLoader@4554617c

        //获取扩展类加载器的父类加载器- ->根加载器(C/c++)
        ClassLoader grantparent = parent.getParent();
        System.out.println(grantparent);//null

        //测试当前类是哪个加载器加载的
        ClassLoader classLoader = Class.forName("reflection.ClassLoadOrder").getClassLoader();
        System.out.println(classLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2

        //测试JDK内置的类是谁加载的
        ClassLoader classLoader1 = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader1);//null

        //如何获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));
        /*
         * D:\Environment\java\jre\lib\charsets.jar;
         * D:\Environment\java\jre\lib\deploy.jar;
         * D:\Environment\java\jre\lib\ext\access-bridge-64.jar;
         * D:\Environment\java\jre\lib\ext\cldrdata.jar;
         * D:\Environment\java\jre\lib\ext\dnsns.jar;
         * D:\Environment\java\jre\lib\ext\jaccess.jar;
         * D:\Environment\java\jre\lib\ext\jfxrt.jar;
         * D:\Environment\java\jre\lib\ext\localedata.jar;
         * D:\Environment\java\jre\lib\ext\nashorn.jar;
         * D:\Environment\java\jre\lib\ext\sunec.jar;
         * D:\Environment\java\jre\lib\ext\sunjce_provider.jar;
         * D:\Environment\java\jre\lib\ext\sunmscapi.jar;
         * D:\Environment\java\jre\lib\ext\sunpkcs11.jar;
         * D:\Environment\java\jre\lib\ext\zipfs.jar;
         * D:\Environment\java\jre\lib\javaws.jar;
         * D:\Environment\java\jre\lib\jce.jar;
         * D:\Environment\java\jre\lib\jfr.jar;
         * D:\Environment\java\jre\lib\jfxswt.jar;
         * D:\Environment\java\jre\lib\jsse.jar;
         * D:\Environment\java\jre\lib\management-agent.jar;
         * D:\Environment\java\jre\lib\plugin.jar;
         * D:\Environment\java\jre\lib\resources.jar;
         * D:\Environment\java\jre\lib\rt.jar;
         * D:\project\java-design\out\production\design02;
         * D:\IDEA\IntelliJ IDEA 2020.1.1\lib\idea_rt.jar
         */
    }
}

