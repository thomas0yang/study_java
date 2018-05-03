package com.thomas.products.threadlocal;

/*
 * 线程本地化，即每个线程都有自己的一个对象（原来是共享的对象）
 * ThreadLocalMap<threadlocalHashCode,Object>
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class DateUtil {
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>();

    public static DateFormat getDateFormat() {
        return threadLocal.get();
    }

    public static Date parse(String textDate) throws ParseException {
        return getDateFormat().parse(textDate);
    }

    public static void main(String[] args) throws ParseException {
        for (int i = 0; i < 2; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    Date parse = null;
                    try {
                        parse = DateUtil.parse("2013-03-05 11:11:11");
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    System.out.println(parse);
                }
            };
            t.start();
        }

        Date parse1 = DateUtil.parse("2013-03-06 11:11:11");
        System.out.println(parse1);
    }
}
