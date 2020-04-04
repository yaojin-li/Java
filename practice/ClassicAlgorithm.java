import java.lang.Math;

/**
 * @Description: 11个基本经典算法
 * 1. 菲波拉契数列问题
 * 2. 判断素数问题
 * 3. 判断水仙花数问题
 * 4. 获取分数评级（嵌套条件运算符）
 * 5. 正整数分解质因数
 * 6. 最大公约数和最小公倍数
 * 7. 统计字符串内容
 * 8. 计算特殊表达式的和 求s=a+aa+aaa+aaaa+aa…a的值
 * 9. 判断一个数是否是完数（一个数如果恰好等于它的因子之和，如6=1＋2＋3）
 * 10.阶乘 求1+2!+3!+…+20!的和
 * 11.判断一个数是不是回文数。即12321是回文数，个位与万位相同，十位与千位相同。
 * --------------------------------------
 * @ClassName: ClassicAlgorithm.java
 * @Date: 2018/11/27 11:31
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class ClassicAlgorithm {
    public static void main(String args[]) {
/*
        // 1. 菲波拉契数列问题
        for (int i = 1; i <= 10; i++) {
            System.out.print(fibonacci_one(i) + "\t");
        }
        fibonacci_two(10);
        fibonacci_three(10);

        // 2. 判断素数
        int beginNum = 101;
        int endNum = 200;
        int count = 0;
        getPrimeInInterval(beginNum, endNum);

        for(int i = 101; i < 200; i++) {
            if (isPrimeNum(i)) {
                count++;
                System.out.print(i + " ");
            }
        }
        System.out.println("总数：" + count);

        // 3. 判断水仙花数
        getDaffodilNum(101, 1000);

        // 4. 获取分数评级（嵌套条件运算符）
        getScoreSign(80);

        // 5. 正整数分解质因数
        getPrimeNum(20);

        // 6. 最大公约数和最小公倍数
        int maxComDivisor = getMaxComDivisor(12, 200);
        int minComMultiple = 12 * 200 / maxComDivisor;

        // 7. 统计字符串内容
        countNum("123test 哈哈 #@*");

        // 8. 计算特殊表达式的和 求s=a+aa+aaa+aaaa+aa…a的值
        getNumSum(3, 6);

        // 9. 判断一个数是否是完数（一个数如果恰好等于它的因子之和，如6=1＋2＋3）
        isCompleteNum(6);

        // 10. 阶乘 求1+2!+3!+…+20!的和
        factorial(20);
*/
        // 11. 判断回文数
        isNumberOfTracts(1234567890987654321L);     // Integer number too large  最后添加L变成long类型

    }

    // 1. 菲波拉契数列问题
    public static void fibonacci_three(int data) {
        /**
         * @Description: 建立数组
         * @Date: 2018/11/27 10:55
         * @Params: [data]
         * @ReturnType: void
         **/
        int[] arr = new int[data];
        arr[0] = 1;
        arr[1] = 1;
        System.out.print(arr[0] + "\t" + arr[1] + "\t");
        for (int i = 2; i < data; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
            System.out.print(arr[i] + "\t");
        }
    }

    public static void fibonacci_two(int data) {
        /**
         * @Description: 直接打印
         * @Date: 2018/11/27 10:56
         * @Params: [data]
         * @ReturnType: void
         **/
        int one = 1;
        int two = 1;
        int three = 0;
        System.out.print(one + "\t" + two + "\t");
        for (int i = 3; i <= data; i++) {
            three = one + two;
            one = two;
            two = three;
            System.out.print(three + "\t");
        }
    }

    public static int fibonacci_one(int data) {
        /**
         * @Description: 递归
         * @Date: 2018/11/27 10:56
         * @Params: [data]
         * @ReturnType: int
         **/
        if (data == 1 || data == 2) {
            return 1;
        } else {
            return fibonacci_one(data - 1) + fibonacci_one(data - 2);
        }
    }

    // 2. 判断素数问题
    public static int getPrimeInInterval(int beginNum, int endNum) {
        /**
         * @Description: 在区间中找到所有素数
         * @Date: 2018/11/27 11:04
         * @Params: [beginNum, endNum]
         * @ReturnType: int
         **/
        int count = 0;
        for (int i = beginNum; i < endNum; i++) {
            boolean flag = true;                        // 标志位的位置，在循环内部，每次新的数字重新至true
            for (int j = 2; j <= Math.sqrt(i); j++) {    // <=， =表示判断math.sqrt(i)这个数是否为素数
                if (i % j == 0) {                            // i%j 用一个数分别去除2到sqrt(这个数)
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                count++;
                System.out.print(i + " ");
            }
        }
        System.out.println("总数：" + count);
        return count;
    }

    public static boolean isPrimeNum(int num) {
        /**
         * @Description: 判断一个数是否是素数
         * @Date: 2018/11/27 11:05
         * @Params: [num]
         * @ReturnType: boolean
         **/
        boolean flag = true;
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    // 3. 判断水仙花数
    public static void getDaffodilNum(int beginNum, int endNum) {
        /**
         * @Description: 判断水仙花数
         * @Date: 2018/11/27 11:25
         * @Params: [beginNum, endNum]
         * @ReturnType: void
         **/
        int a, b, c;
        for (int i = beginNum; i < endNum; i++) {
            a = i % 10;  // 个
            b = (i / 10) % 10;    // 十
            c = i / 100;    // 百
            if (a * a * a + b * b * b + c * c * c == i) {
                System.out.println(i);
            }
        }
    }

    // 4. 获取分数评级（嵌套条件运算符
    public static String getScoreSign(int score) {
        /**
         * @Description: 获取分数评级
         * @Date: 2018/11/27 11:26
         * @Params: [score]
         * @ReturnType: java.lang.String
         **/
        return score >= 90 ? "A" : score >= 60 ? "B" : "C";
    }

    // 5. 正整数分解质因数
    public static void getPrimeNum(int num) {
        /**
         * @Description: 正整数分解质因数
         * @Date: 2018/11/27 11:26
         * @Params: [num]
         * @ReturnType: void
         **/
        int minPrimeNum = 2;
        while (num >= minPrimeNum) {
            if (num == minPrimeNum) {
                System.out.println(num);              // ！找到最终的，也是最大的质因数
                break;
            } else if (num % minPrimeNum == 0) {      // 说明此时的num可以再次被分解
                System.out.println(minPrimeNum);      // ！每次被minPrimeNum整除时，minPrimeNum均作为质因数，而不是num
                num = num / minPrimeNum;              // ！每次取整数
            } else {
                minPrimeNum++;                        // ！minPrimeNum自增找到最大质因数本身。例如：7
            }
        }
    }

    // 6. 最大公约数和最小公倍数
    /*只要除数不等于0在循环中，只要除数不等于0，用较大数除以较小的数，若两数相同，最大公约数为本身；
    将小的一个数作为下一轮循环的大数，取得的余数作为下一轮循环的较小的数，如此循环直到较小的数的值为0，
    返回较大的数，此数即为最大公约数，最小公倍数为两数之积除以最大公约数。*/
    public static int getMaxComDivisor(int maxNum, int minNum) {
        /**
         * @Description: 最大公约数和最小公倍数
         * @Date: 2018/11/29 11:29
         * @Params: [maxNum, minNum]
         * @ReturnType: int
         **/
        if (maxNum < minNum) {
            int temp = maxNum;
            maxNum = minNum;
            minNum = temp;
        }
        while (minNum != 0) {
            if (minNum == maxNum) {
                return maxNum;
            }
            int temp = minNum;
            minNum = maxNum % minNum;
            maxNum = temp;
        }
        System.out.println(maxNum);
        return maxNum;
    }

    // 7. 统计字符串内容
    public static void countNum(String targetString) {
        /**
         * @Description: 统计字符串内容
         * @Date: 2018/11/29 13:40
         * @Params: [targetString]
         * @ReturnType: void
         **/
        int abcCount = 0;
        int chineseCount = 0;
        int spaceCount = 0;
        int numCount = 0;
        int otherCount = 0;

        for (int i = 0; i < targetString.length(); i++) {
            char oneChar = targetString.charAt(i);
            if (Character.isDigit(oneChar)) {
                numCount++;
            } else if (oneChar > '\u4e00' && oneChar < '\u9fa5') {      // 判断汉字
                chineseCount++;
            } else if (Character.isSpaceChar(oneChar)) {
                spaceCount++;
            } else if (Character.isLetter(oneChar)) {
                abcCount++;
            } else {
                otherCount++;
            }
        }

        System.out.println(abcCount);
        System.out.println(chineseCount);
        System.out.println(spaceCount);
        System.out.println(numCount);
        System.out.println(otherCount);
    }

    // 8. 计算特殊表达式的和 求s=a+aa+aaa+aaaa+aa…a的值
    public static int getNumSum(int num, int count) {
        /**
         * @Description: 计算特殊表达式的和
         * @Date: 2018/11/30 10:54
         * @Params: [num, count]
         * @ReturnType: int
         **/
        int sum = 0;
        int result = 0;
        for (int i = 0; i < count; i++) {
            sum += (int) Math.pow(10, i) * num;
            result += sum;
        }
        return result;
    }

    // 9. 判断一个数是否是完数（一个数如果恰好等于它的因子之和，如6=1＋2＋3）
    public static boolean isCompleteNum(int num) {
        /**
         * @Description: 判断一个数是否是完数
         * @Date: 2018/11/30 11:21
         * @Params: [num]
         * @ReturnType: boolean
         **/
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        if (sum == num) {
            return true;
        } else {
            return false;
        }
    }

    // 10. 阶乘 求1+2!+3!+…+20!的和
    public static long factorial(int num) {
        /**
         * @Description: 阶乘
         * @Date: 2018/12/3 15:57
         * @Params: [num]
         * @ReturnType: long
         **/
        long sum = 0;
        long temp = 1;
        for (int i = 1; i <= num; i++) {
            temp *= i;
            sum += temp;
            System.out.println(sum);
        }
        return sum;
    }

    // 11. 判断回文数
    public static boolean isNumberOfTracts(long num) {
        /**
         * @Description: 判断回文数
         * @Date:        2018/12/3 16:58
         * @Params:      [num]
         * @ReturnType:  boolean
         **/
        boolean flag = false;
        String str1 = String.valueOf(num);
        String str2 = new StringBuilder(str1).reverse().toString();
        for (int i = 0; i < str1.length(); i++) {
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);
            if (char1 != char2) {
                System.out.println("error index at: " + i);
                flag = false;
                break;
            } else {
                flag = true;
            }
        }
        System.out.println(flag);
        return flag;
    }

}


