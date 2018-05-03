package com.thomas.products.io.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class SysOutErr
{
    public static void main(final String[] args) throws FileNotFoundException
    {
        System.setErr(new PrintStream(new FileOutputStream("D:/test.txt")));
        System.err.println("111");//不在console中输出，而打印到test.txt中
        System.err.println("123");//不在console中输出，而打印到test.txt中
        System.err.println("345");//不在console中输出，而打印到test.txt中
        System.setOut(new PrintStream(new FileOutputStream("D:/test.txt")));
        System.out.append("o111");//不在console中输出，而打印到test.txt中
        System.out.append("o123");//不在console中输出，而打印到test.txt中
        System.out.append("o345");//不在console中输出，而打印到test.txt中
    }
}
