package com.lhg.test.designpattern.template;

import java.util.Date;

/**
 * Created by liux on 16-3-19.
 */
public class TemplatePatternDemo {
    public static void main(String[] args) {
        Game football = new Football();
        Game cricket = new Cricket();

        System.out.println(new Date());
        football.play();
        System.out.println(new Date());
        cricket.play();
        System.out.println(new Date());
    }
}
