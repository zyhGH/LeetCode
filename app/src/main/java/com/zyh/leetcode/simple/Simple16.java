package com.zyh.leetcode.simple;

public class Simple16 {
    public String addBinary(String a, String b) {
        if (a.equals("0"))
            return b;
        if (b.equals("0"))
            return a;
        return "";
    }
}
