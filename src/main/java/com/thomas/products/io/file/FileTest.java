package com.thomas.products.io.file;

import java.io.File;

public class FileTest
{
    public static void main(final String[] args)     {
        File file = new File("e:/opttest/a/b/d/e/f/a.txt");
        file.mkdirs();
    }
}
