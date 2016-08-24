package com.lhg.test;

import java.util.StringTokenizer;

/**
 * Created by liuhg on 16-7-18.
 */
public class StringTokenTest {
    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer("a:b:c", ":");
        while (st.hasMoreElements()) {
            System.out.println(st.nextToken(":"));
        }

        for (String token : "a:b:c".split(":")) {
            System.err.println(token);
        }
    }
}
