package commonFunctions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Description:
 * 测试 Collections.sort()
 * --------------------------------------
 * @ClassName: commonFunctions.TestCollectionsSort.java
 * @Date: 2019/5/28 17:32
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class TestCollectionsSort {
    public static void main(String[] args) {

        //1. Bean中实现Comparator接口；
        List<BeanClass> list = new ArrayList<BeanClass>();
        BeanClass bean1 = new BeanClass();
        BeanClass bean2 = new BeanClass();
        bean1.para = 1;
        bean2.para = 2;
        list.add(bean1);
        list.add(bean2);

        Collections.sort(list, new Comparator<BeanClass>() {
            @Override
            public int compare(BeanClass o1, BeanClass o2) {
                return o1.para - o2.para;  //升序
//                return o2.para - o1.para;  //降序
            }
        });
        System.out.println(list.get(0).para);
        System.out.println(list.get(1).para);


        // 2. 自定义比较器
        List<BeanClass> list1 = new ArrayList<BeanClass>();
        BeanClass bean3 = new BeanClass();
        BeanClass bean4 = new BeanClass();
        bean3.para = 1;
        bean4.para = 2;
        list1.add(bean3);
        list1.add(bean4);
        Collections.sort(list1, new MyComparator());
        System.out.println(list1.get(0).para);
        System.out.println(list1.get(1).para);


        // 3. 使用匿名类
        List<BeanClass> list2 = new ArrayList<BeanClass>();
        BeanClass bean5 = new BeanClass();
        BeanClass bean6 = new BeanClass();
        bean5.para = 1;
        bean6.para = 2;
        list.add(bean5);
        list.add(bean6);
        Collections.sort(list2, new Comparator<BeanClass>() {
            @Override
            public int compare(BeanClass o1, BeanClass o2) {
                // return o1.para - o2.para;  //升序
                return o2.para - o1.para;  //降序
            }
        });
        System.out.println(list.get(0).para);
        System.out.println(list.get(1).para);
    }
}


class BeanClass implements Comparable<BeanClass> {
    int para;
    @Override
    public int compareTo(BeanClass bc) {
        // return this.para - bc.para; //升序
        return bc.para - this.para; //降序
    }
}

class MyComparator implements Comparator<BeanClass> {
    @Override
    public int compare(BeanClass bean1, BeanClass bean2) {
        //return bean1.para-bean2.para; //升序
        return bean2.para - bean1.para; //降序
    }
}

