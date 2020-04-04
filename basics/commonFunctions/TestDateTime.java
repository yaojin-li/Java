package commonFunctions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;

/**
 * @Description: 日期与时间常见相关操作
 * <p>
 * 零、常用函数
 * 0. LocalDate、LocalTime、LocalDateTime
 * 1. TemporalAdjusters
 * 1. 查询日期是一周的第几天
 * 2. 获取当前小时数
 * 3. 获取当前时间之前、之后的 xx 秒/分钟/小时/天/周/月/年
 * 4. 日期字符串与日期互转
 * 5. 解析时间
 * 6.
 * <p>
 * 一、知识点：
 * 1. SimpleDateFormat 中 format 方法线程不安全。
 * format 方法部分源码如下：
 * // Convert input date to time field list
 * calendar.setTime(date);
 * 其中 calendar 是共享变量，没有控制线程安全；当多线程同时调用时，设置 time 值可能被修改。
 * <p>
 * 2. SimpleDateFormat 中 parse 方法线程不安全。
 * parse 方法实际调用 alb.establish(calendar).getTime() 方法来解析，alb.establish(calendar) 方法主要完成：
 * a.重置日期对象 cal 的属性值；
 * b.使用 calb 中中属性设置cal；
 * c.返回设置好的 cal 对象；
 * 但是这三步不是原子操作，导致解析出来的时间可能是错误的。
 * <p>
 * 3. 解决方法：
 * 多线程并发保证线程安全：
 * 使用 ThreadLocal 保证每个线程最多只创建一次 SimpleDateFormat 对象。
 * <p>
 * 二、注意点：
 * 1. 和 SimpleDateFormat 相比，DateTimeFormatter 是线程安全的。
 * 2. TemporalAdjusters 类中包含许多常用的静态方法，避免自己编写工具类
 * <p>
 * 三、参考链接：
 * https://mp.weixin.qq.com/s/jSMRTQCDgITrCjcZxLFPKg
 * --------------------------------------
 * @ClassName: commonFunctions.TestDateTime.java
 * @Date: 2019/10/10 18:37
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class TestDateTime {
    public static void main(String[] args) throws Exception {

    }

    /**
     * @Description: LocalDate、LocalTime、LocalDateTime 相关测试
     * @Date: 2019/10/29 16:14
     * @Params:
     * @ReturnType:
     **/
    public static void localDateTimeTest() {
        // 1. LocalDate 只获取年月日
        LocalDate localDate = LocalDate.now();
        // 2019-10-10
        LocalDate localDate1 = LocalDate.of(2019, 9, 12);
        // 2019-09-12

        int year = localDate.getYear();
        // 2019
        int year1 = localDate.get(ChronoField.YEAR);
        // 2019

        Month month = localDate.getMonth();
        // OCTOBER
        int month1 = localDate.get(ChronoField.MONTH_OF_YEAR);
        // 10

        int day = localDate.getDayOfMonth();
        // 10
        int day1 = localDate.get(ChronoField.DAY_OF_MONTH);
        // 10

        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        // THURSDAY
        int dayOfWeek1 = localDate.get(ChronoField.DAY_OF_WEEK);
        // 4


        // 2. LocalTime 只获取时分秒
        LocalTime localTime = LocalTime.of(14, 14, 14);
        // 14:14:14
        LocalTime localTime1 = LocalTime.now();
        // 18:02:19.867

        int hour = localTime.getHour();
        // 14
        int hour1 = localTime.get(ChronoField.HOUR_OF_DAY);
        // 14

        int minute = localTime.getMinute();
        // 14
        int minute1 = localTime.get(ChronoField.MINUTE_OF_HOUR);
        // 14

        int second = localTime.getMinute();
        // 14
        int second1 = localTime.get(ChronoField.SECOND_OF_MINUTE);
        // 14


        // 3. LocalDateTime 获取年月日时分秒，相当于 LocalDate + LocalTime
        LocalDateTime localDateTime = LocalDateTime.now();
        // 2019-10-10T17:53:41.465
        LocalDateTime localDateTime1 = LocalDateTime.of(2019, Month.SEPTEMBER, 10, 14, 46, 56);
        // 2019-09-10T18:46:56
        LocalDateTime localDateTime2 = LocalDateTime.of(localDate, localTime);
        // 2019-10-10T18:14:14
        LocalDateTime localDateTime3 = localDate.atTime(localTime);
        // 2019-10-10T18:14:14
        LocalDateTime localDateTime4 = localTime.atDate(localDate);
        // 2019-10-10T18:14:14
        LocalDate localDate2 = localDateTime.toLocalDate();
        // 2019-10-10
        LocalTime localTime2 = localDateTime.toLocalTime();
        // 18:17:11.895


        // 4. Instant 获取秒数，用于表示一个时间戳（精确到纳秒）
        Instant instant = Instant.now();
        // 2019-10-10T08:17:58.893Z
        long currentSecond = instant.getEpochSecond();
        // 1570695510
        long currentMilli = instant.toEpochMilli();
        // 1570695510252


        // 5. Duration 表示从 from 到 to 时间段
        LocalDateTime from = LocalDateTime.of(2018, Month.JANUARY, 1, 00, 0, 0);
        LocalDateTime to = LocalDateTime.of(2019, Month.SEPTEMBER, 12, 19, 30, 18);
        Duration duration = Duration.between(from, to);
        // PT14875H30M18S

        long days = duration.toDays();
        // 619
        long hours = duration.toHours();
        // 14875
        long minutes = duration.toMinutes();
        // 892530
        long seconds = duration.getSeconds();
        // 53551818
        long milliSeconds = duration.toMillis();
        // 53551818000
        long nanoSeconds = duration.toNanos();
        // 53551818000000000


        // 6. 操作年月日 当前时间：2019-10-10 18:33:21
        // 增加一年
        localDateTime = localDateTime.plusYears(1);
        // 2020-10-10T18:33:21.870
        localDateTime = localDateTime.plus(1, ChronoUnit.YEARS);
        // 2021-10-10T18:33:21.870

        // 减少一个月
        localDateTime = localDateTime.minusMonths(1);
        // 2021-09-10T18:35:41.656
        localDateTime = localDateTime.minus(1, ChronoUnit.MONTHS);
        // 2021-08-10T18:35:41.656

        // 通过 with 修改某些值
        // 修改年为2020
        localDateTime = localDateTime.withYear(2020);
        // 2020-08-10T18:36:33.754
        localDateTime = localDateTime.with(ChronoField.YEAR, 2020);
        // 2020-08-10T18:36:33.754

        // 时间计算
        // 获取该年的第一天
        LocalDate localDate3 = localDate.with(TemporalAdjusters.firstDayOfYear());
        // 2019-01-01
    }


    /**
     * @Description: TemporalAdjusters 常用静态方法
     * // firstDayOfMonth	    返回当月的第一天
     * // firstDayOfNextMonth	返回下月的第一天
     * // firstDayOfNextYear	返回下一年的第一天
     * // firstDayOfYear	    返回本年的第一天
     * // firstInMonth	        返回同一个月中第一个星期几
     * // lastDayOfMonth	    返回当月的最后一天
     * // lastDayOfNextMonth	返回下月的最后一天
     * // lastDayOfNextYear	    返回下一年的最后一天
     * @Date: 2019/10/29 15:28
     * @Params:
     * @ReturnType:
     **/
    public static void temporalAdjustersTest() {
        LocalDate localDate = LocalDate.now();
        // 2019-10-10

        LocalDateTime localDateTime = LocalDateTime.now();
        // 2019-10-10T17:53:41.465

        // 当前时间：2019-10-10 18:44:13
        // 获得当月第一天 2019-10-01
        LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        // 获得当年第一天相同的时间：2019-01-01T18:44:13.857
        LocalDateTime.now().with(TemporalAdjusters.firstDayOfYear());

        // 格式化时间
        String s1 = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
        // 20191010

        String s2 = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        // 2019-10-10

        // 自定义当前时间与日期格式化 yyyy-MM-dd, yyyy/MM/dd, yyyy-MM-dd HH:mm:ss
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String s3 = localDateTime.format(dateTimeFormatter);
        // 2019-10-10 18:22:44

    }


    /**
     * @Description: 查询日期是一周的第几天
     * @Date: 2019/10/25 18:14
     * @Params: dateString : "2013-02-13"
     * @ReturnType: 第几天 : 1,2,3,4,5,6,7
     **/
    public static int dayForWeek(String dateString) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(format.parse(dateString));
        int dayForWeek = 0;
        if (calendar.get(Calendar.DAY_OF_WEEK) == 1) {
            dayForWeek = 7;
        } else {
            dayForWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return dayForWeek;
    }

    /**
     * @Description: 获取当前小时数
     * @Date: 2019/10/25 18:13
     * @Params:
     * @ReturnType: 当前时间的小时
     **/
    public static int getNowHour() {
        SimpleDateFormat format = new SimpleDateFormat("HH");
        String time = format.format(new Date());
        return Integer.parseInt(time);
    }

    /**
     * @Description: 日期字符串与日期互转
     * @Date: 2019/10/29 15:25
     * @Params:
     * @ReturnType:
     **/
    public static void dateAndStrTransform() throws Exception {
        LocalDateTime localDateTime = LocalDateTime.now();
        // 2019-10-10T17:53:41.465

        // str 转日期
        String strDate = "2019-10-10T18:30:28";
        LocalDateTime date = LocalDateTime.parse(strDate);
        // 2019-10-10T18:30:28 （LocalDateTime 类型）

        // str 转日期
        String string = "2019-10-10 18:59:06";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.parse(string));
        // Thu Oct 10 18:59:06 CST 2019 （java.util.Date类型）


        // 日期转 str
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String s4 = localDateTime.format(dateTimeFormatter2);
        // 2019-10-10 18:01:16

        // 日期转 str
        Date dt = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatDate = dateFormat.format(dt);
        // 2019-10-10 18:12:37 （ hh表示12小时制；）

    }


    /**
     * @Description: 解析时间字符串
     * @Date: 2019/10/29 15:27
     * @Params:
     * @ReturnType:
     **/
    public static void parseDateTime() {
        LocalDate localDate4 = LocalDate.parse("20190912", DateTimeFormatter.BASIC_ISO_DATE);
        // 2019-09-12

        LocalDate localDate5 = LocalDate.parse("2019-09-12", DateTimeFormatter.ISO_LOCAL_DATE);
        // 2019-09-12
    }


    /**
     * @Description: 获取当前时间之前、之后的 xx 秒/分钟/小时/天/周/月/年
     * @Date: 2019/10/29 18:13
     * @Params:
     * @ReturnType:
     **/
    public static void offsetTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = new GregorianCalendar();
        Date date = new Date();
        System.out.println("系统当前时间：" + df.format(date));

        // 获取当前日期之前 xx 秒。整数为当前时间往后移，负数则往前推。
        c.setTime(date);
        c.add(Calendar.SECOND, -10);    // 秒
        // c.add(Calendar.MINUTE, 3);   // 分钟
        // c.add(Calendar.HOUR, -4);    // 小时
        // c.add(Calendar.DATE, -2);    // 天
        // c.add(Calendar.DAY_OF_WEEK, -1); // 周
        // c.add(Calendar.WEEK_OF_MONTH, -5);   // 月
        // c.add(Calendar.YEAR, 4);     // 年
        date = c.getTime();
        String strSecond = df.format(date);
        System.out.println("系统前10秒时间：" + strSecond);

        // 输出：
        // 系统当前时间：2019-10-29 14:33:38
        // 统前10秒时间：2019-10-29 14:33:28
    }



}
