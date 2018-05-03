/* ===========================================================================
 * $                                                                         $
 * $ (C) Copyright http://www.uuwatch.com 2007-2008  All rights reserved.    $
 * $                                                                         $
 * ===========================================================================
 * $Revision:: 44924                                                         $ 
 * $LastChangedBy:: fxy                                                      $ 
 * $LastChangedDate:: 2012-09-13 10:23:28 +0800 #$                           $
 * ===========================================================================
 */

package com.thomas.products;

/**
 * JUnit Test Case
 * 
 */
public class DateUtilTest
{
//    @Test
//    public final void testAddDays()
//    {
//        Date date;
//
//        date = DateUtil.parseDate("2007-10-12");
//        date = DateUtil.addDays(date, 1);
//        Assert.assertEquals("2007/10/13", DateUtil.dateToJSString(date));
//
//        date = DateUtil.parseDate("2007-10-12");
//        date = DateUtil.addDays(date, 30);
//        Assert.assertEquals("2007/11/11", DateUtil.dateToJSString(date));
//    }
//
//    @Test
//    public final void testAddDays1()
//    {
//
//        //        final Date date = new Date(350433883913660L / 1000000L);
//
//        //        System.err.println(date.toString());
//    }
//
//    @Test
//    public final void testAddMinutes()
//    {
//        Date date;
//
//        date = DateUtil.parseDateTime("2007-10-12 08:20:00");
//        date = DateUtil.addMinutes(date, 30);
//        Assert.assertEquals("2007-10-12 08:50:00", DateUtil.dateTimeToString(date));
//
//        date = DateUtil.parseDateTime("2007-10-12 08:20:00");
//        date = DateUtil.addMinutes(date, -30);
//
//        Assert.assertEquals("2007-10-12 07:50:00", DateUtil.dateTimeToString(date));
//    }
//
//    //    @Test
//    //    public final void testGetDateOnly()
//    //    {
//    //        final Date date = DateTimeParser.parseTimeString("2007-10-12 08:50:00");
//    //        Assert.assertEquals("2007-10-12 00:00:00", DateUtil.getDateOnly(date));
//    //    }
//
//    @Test
//    public void testaddMonths()
//    {
//        Date date;
//
//        date = DateUtil.parseDate("2007-10-12");
//        date = DateUtil.addMonths(date, 1);
//        Assert.assertEquals("2007/11/12", DateUtil.dateToJSString(date));
//
//        date = DateUtil.parseDate("2007-10-12");
//        date = DateUtil.addMonths(date, 12);
//        Assert.assertEquals("2008/10/12", DateUtil.dateToJSString(date));
//    }
//
//    @Test
//    public final void testCheckDateInRange()
//    {
//        Date d1;
//        Date d2;
//        Date date;
//        d1 = null;
//        d2 = null;
//        date = null;
//
//        Assert.assertTrue(DateUtil.checkDateInRange(null, null, null));
//
//        Assert.assertNull(d1);
//        Assert.assertNull(d2);
//        date = new Date();
//        Assert.assertTrue(DateUtil.checkDateInRange(date, d1, d2));
//
//        Assert.assertNull(d1);
//        d2 = DateUtil.parseDate("2007-10-12");
//        date = DateUtil.parseDate("2007-10-11");
//        Assert.assertTrue(DateUtil.checkDateInRange(date, d1, d2));
//
//        Assert.assertNull(d1);
//        d2 = DateUtil.parseDate("2007-10-10");
//        date = DateUtil.parseDate("2007-10-11");
//        Assert.assertFalse(DateUtil.checkDateInRange(date, d1, d2));
//
//        d2 = null;
//        Assert.assertNull(d2);
//        d1 = DateUtil.parseDate("2007-10-10");
//        date = DateUtil.parseDate("2007-10-11");
//        Assert.assertTrue(DateUtil.checkDateInRange(date, d1, d2));
//
//        Assert.assertNull(d2);
//        Assert.assertNull(d2);
//        d1 = DateUtil.parseDate("2007-10-12");
//        date = DateUtil.parseDate("2007-10-11");
//        Assert.assertFalse(DateUtil.checkDateInRange(date, d1, d2));
//
//        d1 = DateUtil.parseDate("2007-10-10");
//        d2 = DateUtil.parseDate("2007-10-12");
//        date = DateUtil.parseDate("2007-10-11");
//        Assert.assertTrue(DateUtil.checkDateInRange(date, d1, d2));
//
//        d1 = new Date();
//        DateUtil.addDays(d1, -1);
//        d2 = new Date();
//        DateUtil.addDays(d1, 1);
//        date = null;
//        Assert.assertTrue(DateUtil.checkDateInRange(date, d1, d2));
//
//        d1 = DateUtil.parseDate("2010-11-23");
//        d2 = null;
//        date = DateUtil.parseDate("2010-11-23");
//        Assert.assertTrue(DateUtil.checkDateInRange(date, d1, d2));
//
//        d1 = null;
//        d2 = DateUtil.parseDate("2010-11-23");
//        date = DateUtil.parseDate("2010-11-23");
//        Assert.assertTrue(DateUtil.checkDateInRange(date, d1, d2));
//
//        d1 = null;
//        d2 = null;
//        date = DateUtil.parseDate("2010-11-23");
//        Assert.assertTrue(DateUtil.checkDateInRange(date, d1, d2));
//
//        d1 = DateUtil.parseDate("2010-11-23");
//        d2 = DateUtil.parseDate("2010-11-23");
//        date = DateUtil.parseDate("2010-11-23");
//        Assert.assertTrue(DateUtil.checkDateInRange(date, d1, d2));
//    }
//
//    // --------------------------------------------------------------------------
//    // 判断两个日期范围是否重叠; 日期可以为 null
//    public final void testcheckDateOverlappedAllNull()
//    {
//        Date d_11;
//        Date d_12;
//        Date d_21;
//        Date d_22;
//
//        // 第一种情况 全部日期为空
//        Assert.assertTrue(DateUtil.checkDateOverlapped(null, null, null, null));
//
//        // 第二种情况 第一日期范围为空
//        d_21 = DateUtil.parseDate("2007-07-07");
//        d_22 = DateUtil.parseDate("2007-07-09");
//        Assert.assertTrue(DateUtil.checkDateOverlapped(null, null, d_21, d_22));
//
//        // 第三种情况 第二日期范围为空
//        d_11 = DateUtil.parseDate("2007-07-07");
//        d_12 = DateUtil.parseDate("2007-07-09");
//        Assert.assertTrue(DateUtil.checkDateOverlapped(d_11, d_12, null, null));
//
//        // 第四种情况 第二日期范围在第一日期范围前面
//        d_11 = DateUtil.parseDate("2007-07-07");
//        d_12 = DateUtil.parseDate("2007-07-09");
//        d_21 = DateUtil.parseDate("2007-07-05");
//        d_22 = DateUtil.parseDate("2007-07-06");
//        Assert.assertFalse(DateUtil.checkDateOverlapped(d_11, d_12, d_21, d_22));
//
//        // 第五种情况 第二日期范围在第一日期范围后面
//        d_11 = DateUtil.parseDate("2007-07-01");
//        d_12 = DateUtil.parseDate("2007-07-06");
//        d_21 = DateUtil.parseDate("2007-07-07");
//        d_22 = DateUtil.parseDate("2007-07-09");
//        Assert.assertFalse(DateUtil.checkDateOverlapped(d_11, d_12, d_21, d_22));
//
//        // 第六种情况 第一日期范围只指定了开始时间
//        // 分三种情况：
//        // 1、第二日期范围的结束时间比第一日期范围的开始时间早
//        d_11 = DateUtil.parseDate("2007-07-10");
//        d_21 = DateUtil.parseDate("2007-07-07");
//        d_22 = DateUtil.parseDate("2007-07-09");
//        Assert.assertFalse(DateUtil.checkDateOverlapped(d_11, null, d_21, d_22));
//
//        // 2 、第二日期范围的结束时间比第一日期范围的开始时间晚
//        d_11 = DateUtil.parseDate("2007-07-08");
//        d_21 = DateUtil.parseDate("2007-07-07");
//        d_22 = DateUtil.parseDate("2007-07-09");
//        Assert.assertTrue(DateUtil.checkDateOverlapped(d_11, null, d_21, d_22));
//
//        // 3、第二日期范围的结束时间与第一日期范围的开始时间相同
//        d_11 = DateUtil.parseDate("2007-07-09");
//        d_21 = DateUtil.parseDate("2007-07-07");
//        d_22 = DateUtil.parseDate("2007-07-09");
//        Assert.assertTrue(DateUtil.checkDateOverlapped(d_11, null, d_21, d_22));
//
//        // 第七种情况 第一日期范围只指定了结束时间
//        // 1、第二日期范围的开始时间比第一日期范围的结束时间晚
//        d_12 = DateUtil.parseDate("2007-07-06");
//        d_21 = DateUtil.parseDate("2007-07-07");
//        d_22 = DateUtil.parseDate("2007-07-09");
//        Assert.assertFalse(DateUtil.checkDateOverlapped(null, d_12, d_21, d_22));
//
//        // 2、第二日期范围的开始时间比第一日期范围的结束时间早
//        d_12 = DateUtil.parseDate("2007-07-08");
//        d_21 = DateUtil.parseDate("2007-07-07");
//        d_22 = DateUtil.parseDate("2007-07-09");
//        Assert.assertTrue(DateUtil.checkDateOverlapped(null, d_12, d_21, d_22));
//
//        // 3、第二日期范围的开始时间与第一日期范围的结束时间相同
//        d_12 = DateUtil.parseDate("2007-07-07");
//        d_21 = DateUtil.parseDate("2007-07-07");
//        d_22 = DateUtil.parseDate("2007-07-09");
//        Assert.assertTrue(DateUtil.checkDateOverlapped(null, d_12, d_21, d_22));
//
//        // 第八种情况 指定了四个时间（均不为空）
//        // 分4种情况 1、第二日期范围的结束时间在第一日期范围的开始时间之前
//        d_11 = DateUtil.parseDate("2007-05-05");
//        d_12 = DateUtil.parseDate("2007-07-06");
//        d_21 = DateUtil.parseDate("2007-02-02");
//        d_22 = DateUtil.parseDate("2007-02-09");
//        Assert.assertFalse(DateUtil.checkDateOverlapped(d_11, d_12, d_21, d_22));
//
//        // 2、第二日期范围的开始时间在第一日期范围的结束时间之后
//        d_11 = DateUtil.parseDate("2007-05-05");
//        d_12 = DateUtil.parseDate("2007-07-06");
//        d_21 = DateUtil.parseDate("2007-07-09");
//        d_22 = DateUtil.parseDate("2007-08-09");
//        Assert.assertFalse(DateUtil.checkDateOverlapped(d_11, d_12, d_21, d_22));
//
//        // 3、第二日期范围的开始时间在第一日期范围的结束时间之前
//        d_11 = DateUtil.parseDate("2007-05-05");
//        d_12 = DateUtil.parseDate("2007-07-012");
//        d_21 = DateUtil.parseDate("2007-07-09");
//        d_22 = DateUtil.parseDate("2007-08-09");
//        Assert.assertTrue(DateUtil.checkDateOverlapped(d_11, d_12, d_21, d_22));
//
//        // 4、第二日期范围的结束时间在第一日期范围的开始时间之后
//        d_11 = DateUtil.parseDate("2007-05-05");
//        d_12 = DateUtil.parseDate("2007-07-012");
//        d_21 = DateUtil.parseDate("2007-06-06");
//        d_22 = DateUtil.parseDate("2007-05-07");
//        Assert.assertTrue(DateUtil.checkDateOverlapped(d_11, d_12, d_21, d_22));
//    }
//
//    //	public void testAddDeletionDay()
//    //	{
//    //		final Calendar c = Calendar.getInstance();
//    //		c.setTime(new Date());
//    //		final List<Calendar> cl = new ArrayList<Calendar>();
//    //		cl.add(c);
//    //
//    //		final Calendar c2 = Calendar.getInstance();
//    //		c2.setTime(new Date());
//    //		c2.add(Calendar.HOUR_OF_DAY, 1);
//    //		cl.add(c2);
//    //
//    //		final Calendar c3 = Calendar.getInstance();
//    //		c3.setTime(new Date());
//    //		c3.add(Calendar.HOUR_OF_DAY, 3);
//    //		cl.add(c3);
//    //
//    //		final List<Calendar> cl2 = DateUtil.addDeletionHours(cl);
//    //		Assert.assertTrue(cl2.size() == 4);
//    //	}
//
//    @Test
//    public final void testDateToJSString()
//    {
//        final Calendar cal = Calendar.getInstance();
//        Date date;
//
//        date = DateUtil.parseDate("2007-07-04");
//        Assert.assertEquals("2007/7/4", DateUtil.dateToJSString(date));
//
//        date = DateUtil.parseDate("2007-07-20");
//        cal.setTime(date);
//        Assert.assertEquals(20, cal.get(Calendar.DAY_OF_MONTH));
//        Assert.assertEquals("2007/7/20", DateUtil.dateToJSString(date));
//
//        date = DateUtil.parseDate("2007-07-20");
//        date = DateUtil.addDays(date, 5 - 1);
//        Assert.assertEquals("2007/7/24", DateUtil.dateToJSString(date));
//    }
//
//    @Test
//    public final void testDateToString()
//    {
//        Date date;
//
//        date = DateUtil.parseDate("2007-07-04");
//        Assert.assertEquals("2007-07-04", DateUtil.dateToString(date));
//
//        date = DateUtil.parseDate("2007-07-20");
//        Assert.assertEquals("2007-07-20", DateUtil.dateToString(date));
//    }
//
//    @Test
//    public final void testGetBaseDate()
//    {
//        final Date date = DateUtil.getBaseDate();
//        Assert.assertEquals("1970-01-01 08:00:00", DateUtil.dateTimeToString(new Date(0)));
//        Assert.assertEquals("1970-01-01 08:00:00", DateUtil.dateTimeToString(date));
//    }
//
//    @Test
//    public final void testGetBaseTime()
//    {
//        final Date time = DateUtil.getBaseTime();
//        Assert.assertEquals("1970-01-01" + " 00:00:00", DateUtil.dateTimeToString(time));
//    }
//
//    @Test
//    public final void testGetCentesimalDate()
//    {
//        final Calendar c = Calendar.getInstance();
//        c.setTime(DateUtil.parseDateTime("2009-08-15 12:34:56"));
//        Assert.assertEquals(123456, DateUtil.getCentesimalDate(c.getTime()));
//    }
//
//    //	@Test
//    //	public final void testParseDate1()
//    //	{
//    //		final Calendar c = Calendar.getInstance();
//    //		Date d;
//    //
//    //		d = DateUtil.ParseDate1(null);
//    //		c.setTime(d);
//    //		Assert.assertEquals(0, c.get(Calendar.HOUR_OF_DAY));
//    //		Assert.assertEquals(0, c.get(Calendar.MINUTE));
//    //		Assert.assertEquals(0, c.get(Calendar.SECOND));
//    //
//    //		d = DateUtil.ParseDate1("2007-05-05");
//    //		c.setTime(d);
//    //		Assert.assertEquals(0, c.get(Calendar.HOUR_OF_DAY));
//    //		Assert.assertEquals(0, c.get(Calendar.MINUTE));
//    //		Assert.assertEquals(0, c.get(Calendar.SECOND));
//    //	}
//    //
//    //	@Test
//    //	public final void testParseDate2()
//    //	{
//    //		final Calendar c = Calendar.getInstance();
//    //		Date d;
//    //
//    //		d = DateUtil.ParseDate2(null);
//    //		c.setTime(d);
//    //		Assert.assertEquals(23, c.get(Calendar.HOUR_OF_DAY));
//    //		Assert.assertEquals(59, c.get(Calendar.MINUTE));
//    //		Assert.assertEquals(59, c.get(Calendar.SECOND));
//    //
//    //		d = DateUtil.ParseDate2("2007-05-05");
//    //		c.setTime(d);
//    //		Assert.assertEquals(23, c.get(Calendar.HOUR_OF_DAY));
//    //		Assert.assertEquals(59, c.get(Calendar.MINUTE));
//    //		Assert.assertEquals(59, c.get(Calendar.SECOND));
//    //	}
//
//    @Test
//    public void testGetDateList()
//    {
//        final Date start = DateUtil.parseDate("2007-10-12");
//        final Date end = DateUtil.parseDate("2007-11-15");
//        final List<Date> dates = DateUtil.getDateList(start, end);
//        Assert.assertEquals(35, dates.size());
//    }
//
//    @Test
//    public void testGetDateMargin()
//    {
//        Date beginDate;
//        Date endDate;
//        long expected;
//        long actual;
//
//        beginDate = DateUtil.makeDateTime(2011, 1, 1, 15, 0, 0, 0);
//        endDate = DateUtil.makeDateTime(2011, 1, 2, 7, 0, 0, 0);
//        expected = 0;
//        actual = DateUtil.getDateMargin(beginDate, endDate);
//        assertEquals(expected, actual);
//
//        beginDate = DateUtil.makeDateTime(2011, 1, 1, 15, 0, 0, 0);
//        endDate = DateUtil.makeDateTime(2011, 1, 2, 20, 0, 0, 0);
//        expected = 1;
//        actual = DateUtil.getDateMargin(beginDate, endDate);
//        assertEquals(expected, actual);
//
//        beginDate = DateUtil.makeDateTime(2011, 1, 1, 15, 0, 0, 0);
//        endDate = DateUtil.makeDateTime(2011, 1, 2, 15, 0, 0, 0);
//        expected = 1;
//        actual = DateUtil.getDateMargin(beginDate, endDate);
//        assertEquals(expected, actual);
//
//        beginDate = DateUtil.makeDateTime(2011, 1, 1, 0, 0, 0, 0);
//        endDate = DateUtil.makeDateTime(2011, 1, 2, 0, 0, 0, 0);
//        expected = 1;
//        actual = DateUtil.getDateMargin(beginDate, endDate);
//        assertEquals(expected, actual);
//
//        beginDate = DateUtil.makeDateTime(2011, 1, 1, 23, 0, 0, 0);
//        endDate = DateUtil.makeDateTime(2011, 1, 2, 0, 0, 0, 0);
//        expected = 0;
//        actual = DateUtil.getDateMargin(beginDate, endDate);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testGetDateMarginNoTime()
//    {
//        Date beginDate;
//        Date endDate;
//        long actual;
//
//        beginDate = DateUtil.makeDateTime(2011, 1, 1, 0, 0, 0, 0);
//        endDate = DateUtil.makeDateTime(2011, 1, 2, 0, 0, 0, 0);
//        actual = DateUtil.getDateMargin(beginDate, endDate);
//        assertEquals(1, actual);
//    }
//
//    public final void testGetDayOfWeek()
//    {
//        final Calendar dDate = Calendar.getInstance();
//        dDate.set(2008, 10 - 1, 1);
//
//        Assert.assertEquals(3, DateUtil.getDayOfWeek(dDate.getTime()));
//        Assert.assertEquals(Calendar.TUESDAY, DateUtil.getDayOfWeek(dDate.getTime()));
//    }
//
//    @Test
//    public void testGetDayOfWeekString()
//    {
//        Date dDate;
//
//        dDate = DateUtil.makeDate(2009, 7, 20);
//        Assert.assertEquals("周一", DateUtil.getDayOfWeekString(dDate));
//
//        dDate = DateUtil.makeDate(2009, 7, 21);
//        Assert.assertEquals("周二", DateUtil.getDayOfWeekString(dDate));
//
//        dDate = DateUtil.makeDate(2009, 7, 22);
//        Assert.assertEquals("周三", DateUtil.getDayOfWeekString(dDate));
//
//        dDate = DateUtil.makeDate(2009, 7, 23);
//        Assert.assertEquals("周四", DateUtil.getDayOfWeekString(dDate));
//
//        dDate = DateUtil.makeDate(2009, 7, 24);
//        Assert.assertEquals("周五", DateUtil.getDayOfWeekString(dDate));
//
//        dDate = DateUtil.makeDate(2009, 7, 25);
//        Assert.assertEquals("周六", DateUtil.getDayOfWeekString(dDate));
//
//        dDate = DateUtil.makeDate(2009, 7, 26);
//        Assert.assertEquals("周日", DateUtil.getDayOfWeekString(dDate));
//    }
//
//    @Test
//    public void testGetMondayOfWeek()
//    {
//        Date dDate;
//
//        // 周一为一周的开始
//        {
//            dDate = DateUtil.makeDate(2009, 7, 13);
//            Assert.assertEquals("2009-07-13",
//                    DateUtil.dateToString(DateUtil.getMondayOfWeek(dDate, Calendar.MONDAY).getTime()));
//
//            dDate = DateUtil.makeDate(2009, 7, 14);
//            Assert.assertEquals("2009-07-13",
//                    DateUtil.dateToString(DateUtil.getMondayOfWeek(dDate, Calendar.MONDAY).getTime()));
//
//            dDate = DateUtil.makeDate(2009, 7, 15);
//            Assert.assertEquals("2009-07-13",
//                    DateUtil.dateToString(DateUtil.getMondayOfWeek(dDate, Calendar.MONDAY).getTime()));
//
//            dDate = DateUtil.makeDate(2009, 7, 16);
//            Assert.assertEquals("2009-07-13",
//                    DateUtil.dateToString(DateUtil.getMondayOfWeek(dDate, Calendar.MONDAY).getTime()));
//
//            dDate = DateUtil.makeDate(2009, 7, 17);
//            Assert.assertEquals("2009-07-13",
//                    DateUtil.dateToString(DateUtil.getMondayOfWeek(dDate, Calendar.MONDAY).getTime()));
//
//            dDate = DateUtil.makeDate(2009, 7, 18);
//            Assert.assertEquals("2009-07-13",
//                    DateUtil.dateToString(DateUtil.getMondayOfWeek(dDate, Calendar.MONDAY).getTime()));
//
//            dDate = DateUtil.makeDate(2009, 7, 19);
//            Assert.assertEquals("2009-07-13",
//                    DateUtil.dateToString(DateUtil.getMondayOfWeek(dDate, Calendar.MONDAY).getTime()));
//        }
//
//        // 周日为一周的开始
//        {
//            dDate = DateUtil.makeDate(2009, 7, 13);
//            Assert.assertEquals("2009-07-12",
//                    DateUtil.dateToString(DateUtil.getMondayOfWeek(dDate, Calendar.SUNDAY).getTime()));
//
//            dDate = DateUtil.makeDate(2009, 7, 14);
//            Assert.assertEquals("2009-07-12",
//                    DateUtil.dateToString(DateUtil.getMondayOfWeek(dDate, Calendar.SUNDAY).getTime()));
//
//            dDate = DateUtil.makeDate(2009, 7, 15);
//            Assert.assertEquals("2009-07-12",
//                    DateUtil.dateToString(DateUtil.getMondayOfWeek(dDate, Calendar.SUNDAY).getTime()));
//
//            dDate = DateUtil.makeDate(2009, 7, 16);
//            Assert.assertEquals("2009-07-12",
//                    DateUtil.dateToString(DateUtil.getMondayOfWeek(dDate, Calendar.SUNDAY).getTime()));
//
//            dDate = DateUtil.makeDate(2009, 7, 17);
//            Assert.assertEquals("2009-07-12",
//                    DateUtil.dateToString(DateUtil.getMondayOfWeek(dDate, Calendar.SUNDAY).getTime()));
//
//            dDate = DateUtil.makeDate(2009, 7, 18);
//            Assert.assertEquals("2009-07-12",
//                    DateUtil.dateToString(DateUtil.getMondayOfWeek(dDate, Calendar.SUNDAY).getTime()));
//
//            dDate = DateUtil.makeDate(2009, 7, 19);
//            Assert.assertEquals("2009-07-19",
//                    DateUtil.dateToString(DateUtil.getMondayOfWeek(dDate, Calendar.SUNDAY).getTime()));
//        }
//    }
//
//    public void testGetMonth()
//    {
//        final Date oDate = DateUtil.parseDate("2009-02-01");
//        final int month = DateUtil.getMonth(oDate);
//
//        assertTrue(month == 2);
//    }
//
//    public void testGetMonthEnd()
//    {
//        Date oDate = DateUtil.parseDate("2009-02-01");
//
//        assertTrue("2009-02-28".equals(DateUtil.getMonthEnd(oDate)));
//        oDate = DateUtil.parseDate("2000-02-01");
//        assertTrue("2000-02-29".equals(DateUtil.getMonthEnd(oDate)));
//    }
//
//    public void testGetOneOfWeeks()
//    {
//        int n;
//        final Date oDate = DateUtil.parseDate("2008-01-22");
//
//        n = 0;
//        Assert.assertTrue("2008-01-27".equals(DateUtil.dateToString((DateUtil.getOneOfWeeks(oDate, n)))));
//        n = 1;
//        Assert.assertTrue("2008-01-21".equals(DateUtil.dateToString((DateUtil.getOneOfWeeks(oDate, n)))));
//        n = 2;
//        Assert.assertTrue("2008-01-22".equals(DateUtil.dateToString((DateUtil.getOneOfWeeks(oDate, n)))));
//        n = 3;
//        Assert.assertTrue("2008-01-23".equals(DateUtil.dateToString((DateUtil.getOneOfWeeks(oDate, n)))));
//        n = 4;
//        Assert.assertTrue("2008-01-24".equals(DateUtil.dateToString((DateUtil.getOneOfWeeks(oDate, n)))));
//        n = 5;
//        Assert.assertTrue("2008-01-25".equals(DateUtil.dateToString((DateUtil.getOneOfWeeks(oDate, n)))));
//        n = 6;
//        Assert.assertTrue("2008-01-26".equals(DateUtil.dateToString((DateUtil.getOneOfWeeks(oDate, n)))));
//        n = 7;
//        Assert.assertTrue("2008-01-27".equals(DateUtil.dateToString((DateUtil.getOneOfWeeks(oDate, n)))));
//    }
//
//    @Test
//    public final void testGetPlayTimeString()
//    {
//        int nTime;
//        String sTime;
//
//        nTime = 00;
//        sTime = "00:00";
//        Assert.assertEquals(sTime, DateUtil.getPlayTimeString(nTime));
//
//        nTime = 59;
//        sTime = "00:59";
//        Assert.assertEquals(sTime, DateUtil.getPlayTimeString(nTime));
//
//        nTime = 60;
//        sTime = "01:00";
//        Assert.assertEquals(sTime, DateUtil.getPlayTimeString(nTime));
//
//        nTime = 60 + 10;
//        sTime = "01:10";
//        Assert.assertEquals(sTime, DateUtil.getPlayTimeString(nTime));
//
//        nTime = 60 * 60;
//        sTime = "01:00:00";
//        Assert.assertEquals(sTime, DateUtil.getPlayTimeString(nTime));
//
//        nTime = 59 * 60;
//        sTime = "59:00";
//        Assert.assertEquals(sTime, DateUtil.getPlayTimeString(nTime));
//    }
//
//    @Test
//    public final void testGetSecondsTimeString()
//    {
//        int nTime;
//        String sTime;
//
//        nTime = 0;
//        sTime = "0";
//        Assert.assertEquals(sTime, DateUtil.getSecondsTimeString(nTime));
//
//        nTime = 449;
//        sTime = "0.4";
//        Assert.assertEquals(sTime, DateUtil.getSecondsTimeString(nTime));
//
//        nTime = 450;
//        sTime = "0.5";
//        Assert.assertEquals(sTime, DateUtil.getSecondsTimeString(nTime));
//
//        nTime = 949;
//        sTime = "0.9";
//        Assert.assertEquals(sTime, DateUtil.getSecondsTimeString(nTime));
//
//        nTime = 950;
//        sTime = "1";
//        Assert.assertEquals(sTime, DateUtil.getSecondsTimeString(nTime));
//
//        nTime = 1 * 1000;
//        sTime = "1";
//        Assert.assertEquals(sTime, DateUtil.getSecondsTimeString(nTime));
//
//        nTime = 100 * 1000;
//        sTime = "100";
//        Assert.assertEquals(sTime, DateUtil.getSecondsTimeString(nTime));
//
//        nTime = 449 + 1000;
//        sTime = "1.4";
//        Assert.assertEquals(sTime, DateUtil.getSecondsTimeString(nTime));
//
//        nTime = 450 + 1000;
//        sTime = "1.5";
//        Assert.assertEquals(sTime, DateUtil.getSecondsTimeString(nTime));
//
//        nTime = 949 + 1000;
//        sTime = "1.9";
//        Assert.assertEquals(sTime, DateUtil.getSecondsTimeString(nTime));
//
//        nTime = 950 + 1000;
//        sTime = "2";
//        Assert.assertEquals(sTime, DateUtil.getSecondsTimeString(nTime));
//    }
//
//    public void testGetYear()
//    {
//        assertEquals(2009, DateUtil.getYear(DateUtil.parseDateTime("2009-08-02")));
//    }
//
//    @Test
//    public final void testGetYearMonth()
//    {
//        assertEquals(200901, DateUtil.getYearMonth(DateUtil.parseDateTime("2009-01-01")));
//    }
//
//    @Test
//    public final void testParseDate()
//    {
//        final Calendar cal = Calendar.getInstance();
//        Date date;
//
//        date = DateUtil.parseDate("2007-07-10");
//        cal.setTime(date);
//        Assert.assertTrue(10 == cal.get(Calendar.DAY_OF_MONTH));
//
//        date = DateUtil.parseDate("2007年7月10日", DateUtil.DEFAULT_DATE_FORMAT3);
//        cal.setTime(date);
//        Assert.assertTrue(10 == cal.get(Calendar.DAY_OF_MONTH));
//        Assert.assertTrue(7 == cal.get(Calendar.MONTH) + 1);
//        Assert.assertTrue(2007 == cal.get(Calendar.YEAR));
//
//        date = DateUtil.parseDate("1-05-2002", "d-MM-yyyy");
//        cal.setTime(date);
//        Assert.assertTrue(1 == cal.get(Calendar.DAY_OF_MONTH));
//        Assert.assertTrue(5 == cal.get(Calendar.MONTH) + 1);
//        Assert.assertTrue(2002 == cal.get(Calendar.YEAR));
//    }
//
//    @Test
//    public final void testParsePlayDateTime()
//    {
//        String sDate = "";
//        String sTime = "";
//        Date atual;
//        String expected = "";
//
//        sDate = "20080229";
//        sTime = "121743";
//        atual = DateUtil
//                .parseDateTime(sDate + sTime, GLOBAL.INDEXER_PLAY_DATE_FORMAT + GLOBAL.INDEXER_PLAY_TIME_FORMAT);
//        expected = "2008-02-29 12:17:43";
//        Assert.assertEquals(expected, DateUtil.dateTimeToString(atual));
//
//        sDate = "20100112";
//        sTime = "13";
//        atual = DateUtil.parseDateTime(sDate + sTime, "yyyyMMddHH");
//        expected = "2010-01-12 13:00:00";
//        Assert.assertEquals(expected, DateUtil.dateTimeToString(atual));
//    }
//
//    @Test
//    public final void testParseTime()
//    {
//        String sTime;
//        Date oTime;
//
//        sTime = "12:17:43";
//        oTime = DateUtil.parseTime(sTime);
//        Assert.assertEquals("12:17:43", DateUtil.timeToString(oTime));
//
//        sTime = "12:17:00";
//        oTime = DateUtil.parseTime(sTime);
//        Assert.assertEquals("12:17:00", DateUtil.timeToString(oTime));
//
//        sTime = "12:17";
//        oTime = DateUtil.parseTime(sTime);
//        Assert.assertEquals("12:17:00", DateUtil.timeToString(oTime));
//    }
//
//    public void testParseTimestamp()
//    {
//        String sTimestamp = "";
//        Timestamp oTimestamp = DateUtil.parseTimestamp(sTimestamp);
//        assertNull(oTimestamp);
//
//        sTimestamp = "2009-01-02 00:00:00.000";
//        oTimestamp = DateUtil.parseTimestamp(sTimestamp);
//        assertTrue(oTimestamp.getNanos() == 0);
//
//        sTimestamp = "2009-01-02 00:00:00.100";
//        oTimestamp = DateUtil.parseTimestamp(sTimestamp);
//        assertTrue(oTimestamp.getNanos() == 100000000);
//
//        sTimestamp = "2009-01-02 00:00:00.400";
//        oTimestamp = DateUtil.parseTimestamp(sTimestamp);
//        assertTrue(oTimestamp.getNanos() == 400000000);
//
//        sTimestamp = "2009-01-02 00:00:00.500";
//        oTimestamp = DateUtil.parseTimestamp(sTimestamp);
//        assertTrue(oTimestamp.getNanos() == 500000000);
//
//        sTimestamp = "2009-01-02 00:00:00.600";
//        oTimestamp = DateUtil.parseTimestamp(sTimestamp);
//        assertTrue(oTimestamp.getNanos() == 600000000);
//
//        sTimestamp = "2009-01-02 00:00:00.900";
//        oTimestamp = DateUtil.parseTimestamp(sTimestamp);
//        assertTrue(oTimestamp.getNanos() == 900000000);
//    }

}
