import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 给定一组字符，使用原地算法将其压缩。
 * 压缩后的长度必须始终小于或等于原数组长度。
 * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
 * 在完成原地修改输入数组后，返回数组的新长度。
 * <p>
 * 进阶：
 * 你能否仅使用O(1) 空间解决问题？
 * <p>
 * 示例 1：
 * 输入：
 * ["a","a","b","b","c","c","c"]
 * 输出：
 * 返回6，输入数组的前6个字符应该是：["a","2","b","2","c","3"]
 * 说明：
 * "aa"被"a2"替代。"bb"被"b2"替代。"ccc"被"c3"替代。
 * <p>
 * 示例 2：
 * 输入：
 * ["a"]
 * 输出：
 * 返回1，输入数组的前1个字符应该是：["a"]
 * 说明：
 * 没有任何字符串被替代。
 * <p>
 * 示例 3：
 * 输入：
 * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * 输出：
 * 返回4，输入数组的前4个字符应该是：["a","b","1","2"]。
 * <p>
 * 说明：
 * 由于字符"a"不重复，所以不会被压缩。"bbbbbbbbbbbb"被“b12”替代。
 * 注意每个数字在数组中都有它自己的位置。
 * 注意：
 * <p>
 * 所有字符都有一个ASCII值在[35, 126]区间内。
 * 1 <= len(chars) <= 1000。
 * --------------------------------------
 * @ClassName: test_443.java
 * @Date: 2019/6/10 18:16
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_443 {
    public static void main(String[] args) {
        char[] chars = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        Solution_443 solution = new Solution_443();
        System.out.println(solution.compress(chars));
    }
}

class Solution_443 {
    /**
     * @Description:
     * 双指针，一前一后，对应两个字符不同时更新指针；
     * 构建双数组，记录不同字符与对应个数；
     * @Date:        2019/6/10 21:02
     * @Params:
     * @ReturnType:
     **/
    public int compress(char[] chars) {
        int start = 0;
        int nowIndex = 1;
        // 构建顺序遍历不同字符的列表
        char[] list = new char[chars.length];
        // 构建顺序遍历不同字符对应个数的列表
        int[] num = new int[chars.length];

        // 添加首个字符，设置个数
        list[0] = chars[0];
        num[0] = 1;

        // 顺序遍历不同字符，累加相同字符的次数
        while (nowIndex < chars.length) {
            if (chars[start] != chars[nowIndex]) {
                list[nowIndex] = chars[nowIndex];
                num[nowIndex] = 1;
                // 更新当前位置索引
                start = nowIndex;
                nowIndex++;
            } else {
                num[start] = num[start] + 1;
                nowIndex++;
            }
        }

        // 构建原地算法更新
        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            if (num[i] == 1) {
                list1.add(String.valueOf(list[i]));
            } else if (1 < num[i] && num[i] < 10) {
                list1.add(String.valueOf(list[i]));
                list1.add(String.valueOf(num[i]));
            } else if (10 <= num[i] && num[i] < 100) {
                list1.add(String.valueOf(list[i]));
                list1.add(String.valueOf(num[i] / 10));
                list1.add(String.valueOf(num[i] % 10));
            } else if (100 <= num[i] && num[i] < 1000) {
                list1.add(String.valueOf(list[i]));
                list1.add(String.valueOf(num[i] / 100));
                list1.add(String.valueOf(num[i] % 100 / 10));
                list1.add(String.valueOf(num[i] % 100 % 10));
            } else if (num[i] == 1000) {
                list1.add(String.valueOf(list[i]));
                list1.add("1");
                list1.add("0");
                list1.add("0");
                list1.add("0");
            }
        }
        // 更细chars数组
        for (int i = 0; i < list1.size(); i++) {
            chars[i] = list1.get(i).toCharArray()[0];
        }
        return list1.size();
    }
}
