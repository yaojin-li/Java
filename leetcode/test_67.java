/**
 * @Description: 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * <p>
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * --------------------------------------
 * @ClassName: test_67.java
 * @Date: 2019/5/5 17:26
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_67 {
    public static void main(String args[]) {
        String a = "1010";
        String b = "1011";
        Solution_67 solution = new Solution_67();
        System.out.println(solution.addBinary(a, b));
    }
}

class Solution_67 {
    public String addBinary(String a, String b) {

        int temp = 0;//记录进位数字

        StringBuilder aBuilder = new StringBuilder(a);
        StringBuilder bBuilder = new StringBuilder(b);

        //缺位补0，保证长度相同
        if (aBuilder.length()>bBuilder.length()){
            StringBuilder tempB = new StringBuilder();
            int countOfZero = aBuilder.length()-bBuilder.length();
            for (int i = 0; i < countOfZero; i++) {
                tempB.append('0');
            }
            bBuilder=tempB.append(bBuilder);
        }
        if (aBuilder.length()<bBuilder.length()){
            StringBuilder tempA = new StringBuilder();
            int countOfZero = bBuilder.length()-aBuilder.length();
            for (int i = 0; i < countOfZero; i++) {
                tempA.append('0');
            }
            aBuilder=tempA.append(aBuilder);
        }

        //
        char[] result = new char[aBuilder.length()];

        //从高往低累加
        for (int i = aBuilder.length()-1; i >= 0; i--) {
            //最后一位都为1
            int aChar = aBuilder.charAt(i)-'0';
            int bChar = bBuilder.charAt(i)-'0';

            if (aChar==1 && bChar==1 && temp==0){
                //进位加一，本位至0
                temp=1;
                result[i]='0';
            }else if (aChar==1 && bChar==1 && temp==1){
                //进位加一，本位至1
                temp=1;
                result[i]='1';
            }else if (aChar==0 && bChar==0 && temp==0){
                temp=0;
                result[i]='0';
            }else if (aChar==0&& bChar==0 && temp==1){
                temp=0;
                result[i]='1';
            }else if (aChar==0 && bChar==1 && temp==0){
                temp=0;
                result[i]='1';
            }else if (aChar==0 && bChar==1 && temp==1){
                temp=1;
                result[i]='0';
            }else if (aChar==1 && bChar==0 && temp==0){
                temp=0;
                result[i]='1';
            }else if (aChar==1 && bChar==0 && temp==1){
                temp=1;
                result[i]='0';
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        if (temp==1){
            stringBuilder.append('1');
        }

        for (int i = 0; i < result.length; i++) {
            stringBuilder.append(result[i]);
        }
        return stringBuilder.toString();
    }
}
