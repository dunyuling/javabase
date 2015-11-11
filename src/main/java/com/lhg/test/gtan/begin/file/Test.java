package com.lhg.test.gtan.begin.file;

public class Test {
    public static void main(String args[]) {
	System.out.println("00:22:57,409 --> 00:22:59,84".contains("-->"));
	System.out.println("但在梦中，他杀死的一直是他母亲…".contains("-->"));
	String str = "00:22:57,409 --> 00:22:59,84";
	String str2 = "但在梦中，他杀死的一直是他母亲…";
	if(str.contains("-->")) {
            String str1[] = str.split("-->");
	    System.out.println(str1[0].trim());
   	   System.out.println(str1[1].trim());
	} 
	if (str2.contains("-->")) {
	    String str3[] = str2.split("-->");
	    System.out.println(str3[0]);
	    System.out.println(str3[1]);
        }
    }
}
   
