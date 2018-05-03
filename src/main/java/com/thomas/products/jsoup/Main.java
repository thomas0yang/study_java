package com.thomas.products.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Created by yangyang32 on 17/3/20.
 */
public class Main {
    public static void main(String[] args) {
        String html = "<html><head><title>First parse</title></head>"
                + "<body><p>Parsed HTML into a doc.</p></body></html>";
        Document doc = Jsoup.parse(html);
        System.out.println(doc.head());
        System.out.println(doc.title());

        html = "<div><p>Lorem ipsum.</p>";
        doc = Jsoup.parseBodyFragment(html);
        Element body = doc.body();
        System.out.println(body);
    }
}
