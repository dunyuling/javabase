package com.lhg.test.regularexpression;

import java.util.Scanner;

public class WeixinHao {

    //微信号仅支持6-20个字母，数字，下划线或减号，以字母开头
    public static void main(String[] args) {
        String pattern = "^[a-zA-Z]{1}(\\w|-|_){5,19}$";

        while(true) {
            Scanner input=new Scanner(System.in);
            String result = input.next();
            int length = result.length();
            if (length > 20) {
                System.out.println("too long");
            } else {
                System.out.println("result:" + result.matches(pattern));
                if(result.equals("exit")) {
                    System.exit(0);
                    break;
                }
            }
        }
    }
}
