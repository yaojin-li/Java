import java.util.HashMap;

/**
 * @Description: 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。
 * <p>
 * 这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * <p>
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * 输入: "III"
 * 输出: 3
 * <p>
 * 示例 2:
 * 输入: "IV"
 * 输出: 4
 * <p>
 * 示例 3:
 * 输入: "IX"
 * 输出: 9
 * <p>
 * 示例 4:
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * <p>
 * 示例 5:
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * --------------------------------------
 * @ClassName: test_13.java
 * @Date: 2019/5/4 22:02
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_13 {
    public static void main(String[] args) {
        String s = "III";
        Solution_13 solution = new Solution_13();
        System.out.println(solution.romanToIntOne(s));
    }
}

class Solution_13 {
    /**
     * @Description: 构建字典；两次遍历替换，累加sum
     * @Date:        2019/5/4 22:46
     * @Params:
     * @ReturnType:
     **/
    public int romanToIntOne(String s) {
        int sum = 0;

        //定义12种的字典
        HashMap<String, Integer> map1 = new HashMap<String, Integer>();
        map1.put("IV", 4);
        map1.put("IX", 9);
        map1.put("XL", 40);
        map1.put("XC", 90);
        map1.put("CD", 400);
        map1.put("CM", 900);

        HashMap<String, Integer> map2 = new HashMap<String, Integer>();
        map2.put("I", 1);
        map2.put("V", 5);
        map2.put("X", 10);
        map2.put("L", 50);
        map2.put("C", 100);
        map2.put("D", 500);
        map2.put("M", 1000);

        if (s.length() == 0) return sum;

        // 循环遍历字典的key，若s中存在，则替换为空继续遍历，sum累加key对应的value
        for (String key : map1.keySet()) {
            while (s.contains(key)){
                s=s.replaceFirst(key,"");
                sum+=map1.get(key);
            }
        }
        for (String key : map2.keySet()) {
            while (s.contains(key)){
                s=s.replaceFirst(key,"");
                sum+=map2.get(key);
            }
        }
        return sum;
    }
}
