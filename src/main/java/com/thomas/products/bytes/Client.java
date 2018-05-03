package com.thomas.products.bytes;

import com.thomas.products.util.DateUtil;

public class Client {

    public static void main(String[] args) {
        byte[] b1 = {12,1};
        byte[] b2 = {12,1};
        System.err.println(b1.equals(b2));

        int cpmcountForAdd = 169611;
        int iDay = DateUtil.getDiffDays(DateUtil.parseDate("20130701"), DateUtil.parseDate("20130926"));
        int cpmcount = cpmcountForAdd / iDay;
        System.err.println(iDay);
        System.err.println(cpmcount);
        System.err.println(cpmcountForAdd - cpmcount * iDay);
        System.err.println(cpmcountForAdd--);

    }
}
