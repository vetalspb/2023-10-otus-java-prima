package ru.otus;

import com.google.common.base.Splitter;

@SuppressWarnings("java:S106")
public class HelloOtus {
    public static void main(String... args) {
        Iterable<String> strings =
                Splitter.on(',').trimResults().omitEmptyStrings().split("abc, def,, ghi   ,jkl");
        System.out.println(strings);
    }
}
