import java.util.HashMap;

/**
 * @Description: 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 案例:
 * s = "leetcode"
 * 返回 0.
 * <p>
 * s = "loveleetcode",
 * 返回 2.
 *
 * 总结：
 * 1. 对原始数据不做处理（截取、替换等，可能情况很多，容易出现多数的if-else判断），
 *    仅通过数据结构与API进行算法设计。
 * 2. 构建字符数组运算在算法中耗时最短。
 * --------------------------------------
 * @ClassName: test_387.java
 * @Date: 2019/5/18 8:36
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_387 {
    public static void main(String args[]) {
        String s = "loveleetcode";
        Solution_387 solution = new Solution_387();
        System.out.println(solution.firstUniqCharOne(s));
        System.out.println(solution.firstUniqCharTwo(s));
    }
}

class Solution_387 {
    /**
     * @Description: hashMap
     * @Date: 2019/5/18 8:46
     * @Params:
     * @ReturnType:
     **/
    public int firstUniqCharOne(String s) {
        HashMap<Character, Integer> map = new HashMap();
        StringBuilder sb = new StringBuilder(s);
        //先放入hashmap中统计个数
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (map.keySet().contains(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(sb.charAt(i), 1);
            }
        }
        //遍历最开始个数为一的字符，返回index
        for (int i = 0; i < sb.length(); i++) {
            if (map.get(sb.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }


    /**
     * @Description: 双数组，一个记录出现的次数，效率高于hashmap重置value
     * @Date:        2019/5/18 8:47
     * @Params:
     * @ReturnType:
     **/
    public int firstUniqCharTwo(String s) {
        char[] chars = s.toCharArray();

        //构建长度为'z'+1的字符数组，包含'z'在内所有字母
        /*
         * char[] res = new char[26]
         * for (char ch:chars){
         *     res[ch - 'a']++;
         * }
         * */
        char[] res = new char['z'+1];

        //只设置chars中的字符，所以采用foreach循环方式
        for (char ch:chars) {
            //将当前字符对应的res位置++；
            res[ch]++;
        }

        //由于要返回索引，所以采用fori循环方式
        for (int i = 0; i < chars.length; i++) {
            if (res[chars[i]] == 1){
                return i;
            }
        }
        return -1;
    }
}
