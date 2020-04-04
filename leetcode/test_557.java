import com.sun.deploy.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description: 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 示例 1:
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 * <p>
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * --------------------------------------
 * @ClassName: test_557.java
 * @Date: 2019/4/27 16:34
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_557 {
    public static void main(String args[]) {
        String s = "Let's take LeetCode contest";
        Solution_557 solution = new Solution_557();
//        System.out.println(solution.reverseWordsOne(s));
//        System.out.println(solution.reverseWordsTwo(s));
//        System.out.println(solution.reverseWordsThree(s));
        System.out.println(solution.reverseWordsFore(s));
    }
}

class Solution_557 {
    /**
     * @Description: 分割、遍历互换、拼接。使用 StringBuilder
     * @Date: 2019/4/27 16:57
     * @Params:
     * @ReturnType:
     **/
    public String reverseWordsOne(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] strings = s.split(" ");
        for (int i = 0; i < strings.length; i++) {
            char[] oneStrChar = strings[i].toCharArray();
            for (int j = 0; j < oneStrChar.length / 2; j++) {
                char temp;
                temp = oneStrChar[j];
                oneStrChar[j] = oneStrChar[oneStrChar.length - j - 1];
                oneStrChar[oneStrChar.length - j - 1] = temp;
            }
            stringBuilder.append(String.valueOf(oneStrChar) + " ");
        }
        return stringBuilder.toString().trim();
    }


    /**
     * @Description: StringUtils.join() 方法。使用 Arrays.asList, Collections.reverse(), StringBuilder
     * @Date: 2019/4/27 16:58
     * @Params:
     * @ReturnType:
     **/
    public String reverseWordsTwo(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] strings = s.split(" ");
        for (int i = 0; i < strings.length; i++) {
            String[] str = strings[i].split("");
            List list = Arrays.asList(str);
            Collections.reverse(list);

            //StringUtils.join(list, "")的效果
            //stringBuilder.append(StringUtils.join(list, "") + " ");
            StringBuilder stringBuilder1 = new StringBuilder();
            for (int j = 0; j < list.size(); j++) {
                stringBuilder1.append(list.get(j));
            }
            stringBuilder.append(stringBuilder1.toString() + " ");
        }
        return stringBuilder.toString().trim();
    }


    /**
     * @Description: 字符交换
     * @Date: 2019/4/27 17:22
     * @Params:
     * @ReturnType:
     **/
    public String reverseWordsThree(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] strings = s.split(" ");
        for (int i = 0; i < strings.length; i++) {
            char[] oneStrChar = strings[i].toCharArray();
            for (int j = 0; j < oneStrChar.length / 2; j++) {
                char temp;
                temp = oneStrChar[j];
                oneStrChar[j] = oneStrChar[oneStrChar.length - j - 1];
                oneStrChar[oneStrChar.length - j - 1] = temp;
            }
            stringBuilder.append(String.valueOf(oneStrChar) + " ");
        }
        return stringBuilder.toString().trim();
    }


    /**
     * @Description: 双指针
     * 1.转成char数组，2.遍历s中空格的位置，3.反转非空格到空格之间的字符
     * @Date: 2019/4/27 17:31
     * @Params:
     * @ReturnType:
     **/
    public String reverseWordsFore(String s) {
        char[] chars = s.toCharArray();
        int nowIndex = 0;
        while (nowIndex < s.length()) {
            int spaceIndex = s.indexOf(" ", nowIndex + 1);
            if (spaceIndex == -1) {
                spaceIndex = s.length();
            }
            swap(chars, nowIndex, spaceIndex);
            nowIndex = spaceIndex + 1;//!! 在空格之后的一个位置为当前的索引
        }
        return String.valueOf(chars);//!! 字符数组转字符串
    }

    public void swap(char[] chars, int left, int right) {
        int len = right - left;
        int mid = left + len / 2;
        for (int i = left; i < mid; i++) {
            char temp;
            temp = chars[i];
            chars[i] = chars[right - 1];
            chars[right - 1] = temp;
            left++;
            right--;
        }
    }

}
