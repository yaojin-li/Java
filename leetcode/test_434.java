import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * <p>
 * 示例:
 * 输入: "Hello, my name is John"
 * 输出: 5
 * --------------------------------------
 * @ClassName: test_434.java
 * @Date: 2019/5/20 17:28
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_434 {
    public static void main(String args[]) {
        String s = "   Hello, my name is John";
        Solution_434 solution = new Solution_434();
//        System.out.println(solution.countSegments(s));
        System.out.println(solution.countSegmentsTwo(s));
    }
}

class Solution_434 {
    /**
     * @Description: index位的元素是非空格，前一个是空格
     * @Date: 2019/5/20 17:42
     * @Params:
     * @ReturnType:
     **/
    public int countSegments(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder(" " + s);
        for (int i = 1; i < sb.length(); i++) {
            if (sb.charAt(i) != ' ' && sb.charAt(i - 1) == ' ') {
                count++;
            }
        }
        return count;
    }

    /**
     * @Description: 分割遍历判断，list.size()
     * @Date: 2019/5/20 19:45
     * @Params:
     * @ReturnType:
     **/
    public int countSegmentsTwo(String s) {
        if (s.length() == 0 || s.isEmpty()) {
            return 0;
        }
        List<String> list = new ArrayList<>();
        for (String str : s.split(" ")) {
            if (!str.isEmpty()){
                list.add(str);
            }
        }
        return list.size();
    }
}