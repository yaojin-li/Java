import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 * <p>
 * 示例 1：
 * 输入：name = "alex", typed = "aaleex"
 * 输出：true
 * 解释：'alex' 中的 'a' 和 'e' 被长按。
 * <p>
 * 示例 2：
 * 输入：name = "saeed", typed = "ssaaedd"
 * 输出：false
 * 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
 * <p>
 * 示例 3：
 * 输入：name = "leelee", typed = "lleeelee"
 * 输出：true
 * <p>
 * 示例 4：
 * 输入：name = "laiden", typed = "laiden"
 * 输出：true
 * 解释：长按名字中的字符并不是必要的。
 * <p>
 * 提示：
 * name.length <= 1000
 * typed.length <= 1000
 * name 和 typed 的字符都是小写字母。
 * --------------------------------------
 * @ClassName: test_925.java
 * @Date: 2019/5/12 13:24
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_925 {
    public static void main(String args[]) {
        String name = "ikcxmvzi";
        String typed = "iikcxxmmvvzz";
        Solution_925 solution = new Solution_925();
        System.out.println(solution.isLongPressedNameOne(name, typed));
        System.out.println(solution.isLongPressedNameTwo(name, typed));
    }
}

class Solution_925 {
    /**
     * @Description: 更新stringbuilder
     * @Date: 2019/5/12 17:29
     * @Params:
     * @ReturnType:
     **/
    public boolean isLongPressedNameOne(String name, String typed) {
        StringBuilder nameSb = new StringBuilder(name);
        StringBuilder typedSb = new StringBuilder(typed);

        //若name临近字母的个数大于typed，说明name无法通过typed构造
        if (countStr(name) > countStr(typed)) {
            return false;
        }

        int start = 0;
        int count = countStr(name);
        for (int i = 0; i < count; i++) {
            List nameList = delCharOne(nameSb, nameSb.charAt(start));
            List typedList = delCharOne(typedSb, typedSb.charAt(start));
            if (nameList.size() == 0 || typedList.size() == 0) break;
            if ((int) nameList.get(0) > (int) typedList.get(0)) {
                return false;
            }
            nameSb = (StringBuilder) nameList.get(1);
            typedSb = (StringBuilder) typedList.get(1);
        }
        return true;
    }

    //统计每位临近不同字母的个数
    public int countStr(String string) {
        int count = 0;
        char one = string.charAt(0);
        if (string.length() == 1) return 1;
        for (int i = 1; i < string.length(); i++) {
            if (one != string.charAt(i)) {
                count++;
            }
            one = string.charAt(i);
        }
        return count + 1;
    }

    //删除stringbuilder中等于ch的开始字符
    public List delCharOne(StringBuilder sb, char ch) {
        List<Object> result = new ArrayList();
        int len = sb.length();
        int count = 0;
        int start = 0;
        for (int i = 0; i < len; i++) {
            if (sb.charAt(start) == ch) {
                sb.deleteCharAt(start);
                count++;
            } else {
                result.add(0, count);
                result.add(1, sb);
                return result;
            }
        }
        return result;
    }


    public boolean isLongPressedNameTwo(String name, String typed) {
        if (name.charAt(0) != typed.charAt(0)) return false;
        int index = 1;//name的索引
        char temp = name.charAt(0);
        for (int i = 0; i < typed.length(); i++) {
            //当索引小于name的长度并且对应位置的值相同
            if (index < name.length() && name.charAt(index) == typed.charAt(i)) {
                temp = name.charAt(index++);//取name的下一个值
                continue;
            } else if (temp == typed.charAt(i)) {
                continue;
            } else {
                return false;
            }
        }
        return index == name.length();
    }
}
