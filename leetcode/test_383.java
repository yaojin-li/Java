import java.util.ArrayList;
import java.util.HashSet;

/**
 * @Description: 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
 * 判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。
 * 如果可以构成，返回 true ；否则返回 false。
 * <p>
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
 * <p>
 * 注意：
 * 你可以假设两个字符串均只含有小写字母。
 * <p>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * --------------------------------------
 * @ClassName: test_383.java
 * @Date: 2019/5/7 20:26
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_383 {
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "ab";
        Solution_383 solution = new Solution_383();
        System.out.println(solution.canConstructOne(ransomNote, magazine));
        System.out.println(solution.canConstructTwo(ransomNote, magazine));
        System.out.println(solution.canConstructThree(ransomNote, magazine));
    }
}

class Solution_383 {
    /**
     * @Description: magazine逐个字符替换为空，若余下的magazine中不存在ransomNote的字符，则无法拼接构成
     * @Date: 2019/5/7 21:07
     * @Params:
     * @ReturnType:
     **/
    public boolean canConstructOne(String ransomNote, String magazine) {
        boolean flag = true;
        for (char ch : ransomNote.toCharArray()) {
            //包含字母
            if (magazine.indexOf(ch) > -1) {
                magazine = magazine.replaceFirst(String.valueOf(ch), "");
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }


    /**
     * @Description: 相比第一个方法替换，此方法直接删除stringbuilder对应位置的char
     * @Date: 2019/5/7 21:08
     * @Params:
     * @ReturnType:
     **/
    public boolean canConstructTwo(String ransomNote, String magazine) {
        boolean flag = true;
        StringBuilder stringBuilder = new StringBuilder(magazine);
        for (char ch : ransomNote.toCharArray()) {
            int index = stringBuilder.indexOf(String.valueOf(ch));
            //若索引存在，则删除；不存在（index==-1），则返回false
            if (index >= 0) {
                stringBuilder.deleteCharAt(index);
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }


    /**
     * @Description:
     * @Date: 2019/5/7 21:28
     * @Params:
     * @ReturnType:
     **/
    public boolean canConstructThree(String ransomNote, String magazine) {
        int[] ints = new int[128];//初始化128大小的数组
        for (char ch : magazine.toCharArray()) {
            ints[ch]++;//将字符对应位置的数据自增1
        }
        for (char ch : ransomNote.toCharArray()) {
            ints[ch]--;//将字符对应位置的数据自减1
            //若某一个字符对应位置的数据小于0，说明在magazine中无足够的该位置的字符组成ransomNote，返回false
            if (ints[ch]<0){
                return false;
            }
        }
        return true;
    }

}
