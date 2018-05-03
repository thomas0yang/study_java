package com.thomas.products.io.file;

import com.google.common.base.Charsets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by yangyang32 on 16/7/19.
 */
public class ResourceAsStreamTest {
    public static void main(String[] args) {
//        InputStream input = ResourceAsStreamTest.class.getResourceAsStream("/com/thomas/products/io/ResourceAsStreamTest.class");
        InputStream input = ResourceAsStreamTest.class.getResourceAsStream("/config/123.txt");
//        input = ResourceAsStreamTest.class.getResourceAsStream("/config/123.txt");
        try {
            List<String> names = new ArrayList<String>();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(input, Charsets.UTF_8))) {
                String name = reader.readLine();
                while (name != null) {
                    names.add(name);
                    name = reader.readLine();
                }
            }
            int index = ThreadLocalRandom.current().nextInt(names.size());
            System.out.println(index);
        } catch (IOException e) {
            throw new RuntimeException("Could not read node names list", e);
        }
    }
}
