/**
 * @Description:
 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，
 * 并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 *
 * 示例 1：
 * 输入: "Hello"
 * 输出: "hello"
 *
 * 示例 2：
 * 输入: "here"
 * 输出: "here"
 *
 * 示例 3：
 * 输入: "LOVELY"
 * 输出: "lovely"
 * --------------------------------------
 * @ClassName: test_709.java
 * @Date: 2019/4/18 16:53
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/


public class test_709 {
    public static void main(String args[]) {
        String str = "hEllO WorLd";
        Solution_709 solution = new Solution_709();
//        System.out.println(solution.toLowerCaseOne(str));
        System.out.println(solution.toLowerCaseTwo(str));

    }
}

class Solution_709 {
    /**
     * @Description: toLowerCase()
     * @Date: 2019/4/18 17:00
     * @Params:
     * @ReturnType:
     **/
    public String toLowerCaseOne(String str) {
        return str.toLowerCase();
    }


    /**
     * @Description: (char) str.charAt(i)+32
     * @Date: 2019/4/18 17:00
     * @Params:
     * @ReturnType:
     **/
    public String toLowerCaseTwo(String str) {
        String string = "";
        for (int i = 0, len = str.length(); i < len; i++) {
            if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
                //str.charAt(i)---大写字母，str.charAt(i)+32 --- ascii码
                string += (char) (str.charAt(i) + 32);  //对应的ascii码前加(char)，强转成对应的字符串
            } else {
                string += str.charAt(i);
            }
        }
        return string;
    }

}
