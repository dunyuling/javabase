package com.lhg.test.gtan.begin.niosocket;

//import java.lang.*;
import java.util.*;
public class Test {
    public static void main(String args[]) {
//	System.out.println(1&10);
/*
	if((1&1 ) == 1) {
	    System.out.println("000000000");
	}
*/
//	System.out.println(~5);
//	System.out.println(-1 ^ 1);	
/*
	System.out.println(Integer.toBinaryString(1));
	System.out.println(Integer.toBinaryString(-1));
	System.out.println(Integer.toBinaryString(-2));
	System.out.println(Integer.toBinaryString(-3));
*/
/*
	Set<Integer> set = new HashSet<>();
	int i = 0;
	for(i=0;i<10;i++) {
	    set.add(i);
	}
	System.out.println("set.size= "+set.size());
        Iterator<Integer> iterator = set.iterator();
	while(iterator.hasNext()) {
	    int j = iterator.next();
	    System.out.println(j);
	    iterator.remove();
	    System.out.println("set.size= "+set.size());
	}
*/
	
	String str = null;
	if(str == null ){
	    System.out.println(1111111111);
	} else if(str.equals(null)) {
	    System.out.println(22222222);
	} else if(str.equals("")){
	    System.out.println(3333333);
	} else if(str == ""){
	    System.out.println(4444);
	} else {
	    System.out.println(5555);
	}
	System.out.println(str.toString());
    }
}
