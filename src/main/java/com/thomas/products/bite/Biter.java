package com.thomas.products.bite;

import java.math.BigInteger;

public class Biter {
    public static void main(String[] args) {
        byte[] _b1 = {1,1,1,1}; // 00000001 00000001 00000001 00000001
        int len = ((_b1[0] & 0xff) << 24)
                | ((_b1[1] & 0xff) << 16)
                | ((_b1[2] & 0xff) << 8)
                |((_b1[3] & 0xff) << 0); //二进制转十进制

        // 2^0+2^8+2^16+2^24=16843009

        System.err.println(len);
        String binaryString = Integer.toBinaryString(len); //十进制转二进制
        System.err.println(binaryString);

        BigInteger src = new BigInteger(binaryString, 2); //二进制转十进制
        System.err.println(src.intValue());

        long parseInt = Long.parseLong("0000ffffffff0000", 16);
        System.err.println(parseInt);
    }
}
