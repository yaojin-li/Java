
/**
 * @Description:
 * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，
 * 你想知道你拥有的石头中有多少是宝石。
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例 1:
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 *
 * 示例 2:
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 *
 * 注意:
 * S 和 J 最多含有50个字母。
 * J 中的字符不重复。
 * --------------------------------------
 * @ClassName: test_711.java
 * @Date: 2019/4/16 15:00
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/

public class test_711 {
    public static void main(String args[]) {
        String J = "aA";
        String S = "aAAbbbb";

        Solution_711 solution = new Solution_711();
//        System.out.println(solution.numJewelsInStonesOne(J, S));
//        System.out.println(solution.numJewelsInStonesTwo(J, S));
        System.out.println(solution.numJewelsInStonesThree(J, S));
    }
}

class Solution_711 {
    /**
     * @Description: 双重for()循环
     * @Date: 2019/4/16 16:00
     * @Params:
     * @ReturnType:
     **/
    public int numJewelsInStonesOne(String J, String S) {
        int num = 0;
        for (int i = 0, jLen = J.length(); i < jLen; i++) {
            for (int j = 0, sLen = S.length(); j < sLen; j++) {
                if (J.charAt(i) == S.charAt(j)) {
                    num++;
                }
            }
        }
        return num;
    }


    /**
     * @Description: 字符串indexof()方法
     * @Date: 2019/4/16 15:59
     * @Params:
     * @ReturnType:
     **/
    public int numJewelsInStonesTwo(String J, String S) {
        int num = 0;
        for (int i = 0, len = S.length(); i < len; i++) {
            if (J.indexOf(S.charAt(i)) > -1) {
                num++;
            }
        }
        return num;
    }


    /**
     * @Description: 字符数组判断
     * @Date: 2019/4/17 18:05
     * @Params:
     * @ReturnType:
     **/
    public int numJewelsInStonesThree(String J, String S) {
        char[] A = J.toCharArray();
        char[] B = S.toCharArray();
        boolean[] map = new boolean[128];
        for (int i = 0; i < A.length; ++i) {
            map[A[i]] = true;
        }
        int num = 0;
        for (int i = 0; i < B.length; i++) {
            if (map[B[i]]) {
                ++num;
            }
        }
        return num;
    }
}
