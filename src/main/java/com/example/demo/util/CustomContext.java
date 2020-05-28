package com.example.demo.util;

public class CustomContext {

    private static String header;

    public static void setHeader(String header) {
        CustomContext.header = header;
    }

    public static String getHeader() {
        return header;
    }
}
