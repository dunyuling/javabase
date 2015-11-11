package com.lhg.test.gtan.begin.junit;

import java.util.regex.*;
import java.util.*;
import java.lang.*;

public class Sort {

    public Map<String,Category> judgeKind(String str) {
	Map<String,Category> map = new HashMap<>();
	if(str.contains("-") && ! str.contains("SNAPSHOT")) {
	    map.put(str,Category.DASH);
	}else if(str.contains("RC")) {
	    map.put(str,Category.RC);
	}else if(str.contains("SNAPSHOT")) {
	    map.put(str,Category.SNAPSHOT);
	}else {
	    map.put(str,Category.NUMBER);
	}
	return map;
    }

    public void isSameKind(Object[] array,int i,int j,String str1,String str2) {
	Map<String,Category> map1 = judgeKind(str1);
 	Map<String,Category> map2 = judgeKind(str2);
	String str1kind = map1.get(str1).toString();
	String str2kind = map2.get(str2).toString();
	if(str1kind.equals(str2kind)) {
	    compareSameKindStr(array,i,j,map1,str1,str2);
	}else {
	    compareDiffKindStr(array,i,j,map1,str1,map2,str2);
	}
    }
    
    public void compareSameKindStr(Object[] array,int i,int j,Map<String,Category> map,String str1,String str2) {
	String strkind = map.get(str1).toString();
/*
	if(strkind.equals("NUMBER")) {
	    compareSameKindStr(array,i ,j,str1,str2,"[.]",true,true);
	}else if(strkind.equals("DASH")) {
	    compareSameKindStr(array,i ,j,str1,str2,"[.|-]",true,true);
	}else if(strkind.equals("SNAPSHOT")) {
	    compareSameKindStr(array,i , j,str1,str2,"[.|-]",false,true);
	}else {
	    compareSameKindStr( array,i ,j,str1,str2,"[.]",false,false);
	}
*/
	switch(strkind) {
	case "NUMBER":
	    compareSameKindStr(array,i ,j,str1,str2,"[.]",true,true);
	    break;
        case "DASH":
	    compareSameKindStr(array,i ,j,str1,str2,"[.|-]",true,true);
	    break;
	case "SNAPSHOT":
	    compareSameKindStr(array,i , j,str1,str2,"[.|-]",false,true);
	    break;
	case "RC":
	    compareSameKindStr( array,i ,j,str1,str2,"[.]",false,false);
	    break;
        }
    }

    public void compareSameKindStr(Object[] array,int i ,int j,String str1,String str2,String pattern1,boolean limitFlag,boolean rcFlag) {
	Pattern pattern = Pattern.compile(pattern1);
	String[] arr1 = pattern.split(str1);
	String[] arr2 = pattern.split(str2);
	int k = 0,length = 0,samCount = 0;
	if(limitFlag) {
	    length = arr1.length;
	}else {
	    length = arr1.length-1;
	}
	
	for(k=0;k<length;k++) {
	    int n1 = Integer.parseInt(arr1[k].trim());
            int n2 = Integer.parseInt(arr2[k].trim());

//	    if(str1.equals("2.8.9-1") || str2.equals("2.8.9-1")) {
//		out("str1: "+str1+"\tstr2: "+str2+"\tn1: "+n1+"\tn2: "+n2);
//	    }
	    if(n1>n2) {
		if(k!=(length-1) ||  samCount == (length-1) ) {
		    swap(array,i,j);
		}
		break;
	    }
	    if(n1 == n2 ) {
		if(rcFlag) {
		    samCount++;
		}
		if(!rcFlag && k==(length-1)) {
		    int num1RC = Integer.parseInt(extractNum(arr1[length]));
		    int num2RC = Integer.parseInt(extractNum(arr2[length]));
		    if(num1RC>num2RC) {
			swap(array,i,j);
			break;
		    }
		}
	    } 	
	}
    }

    public String extractNum(String str) {
	int i = 0;
	StringBuffer buffer = new StringBuffer();
	for(i=2;i<str.length();i++) {
	    buffer.append(str.charAt(i));
	}
	return new String(buffer);
    }
    
    public void compareDiffKindStr(Object[] array,int i ,int j,Map<String,Category> map1,String str1,Map<String,Category> map2,String str2) {
	String str1kind = map1.get(str1).toString();
	String str2kind = map2.get(str2).toString();
	String[] arr1 = splitDiffKindStr(str1kind,str1);
	String[] arr2 = splitDiffKindStr(str2kind,str2);
	compareDiffKindStr(array,i ,j,str1,str1kind,arr1,str2,str2kind,arr2) ;
	
    }

    public void compareDiffKindStr(Object[] array,int i ,int j,String str1,String str1kind,String[] arr1,String str2,String str2kind,String[] arr2) {
	int length1 = arr1.length;
	int length2 = arr2.length;
	int length = 0,k = 0;
	boolean flag = false;
	if(length1<length2) {
	    length = length1;
	}else if(length1>length2) {
	    length = length2;
	}else if(length1 == length2) {
	    length = length1-1;
	}	
		
	for(k=0;k<length;k++) {
	   int n1 = Integer.parseInt(arr1[k]);
	   int n2 = Integer.parseInt(arr2[k]);
	   if(n1>n2) {
		swap(array,i,j);
		break;
	   }
	   if(n1==n2){
		if(k==(length-1)) {
		    flag = true;
		} 		
	   }
	}
	if(flag) {
	    if(k==length && str1kind.equals("DASH")) {
                swap(array,i,j);
            }else if(k==length && str2kind.equals("DASH")) {
	    } else if( k==length && str1kind.equals("NUMBER") ) {
		swap(array,i,j);
            } else if(k==length && str2kind.equals("NUMBER")) {
            }else if(k==length && str1kind.equals("RC")) {
		swap(array,i,j);
            }else if(k==length && str2kind.equals("RC") ) {
            }
	}
	
    }

    public String[] splitDiffKindStr(String strkind,String str) {
	String[] arr = {};
	if(strkind.equals("Number") || strkind.equals("RC")) {
	    Pattern pattern = Pattern.compile("[.]");
	    arr = pattern.split(str);
	}else {
	    Pattern pattern = Pattern.compile("[.|-]");
	    arr = pattern.split(str);
	}
	return arr;
    }

    public void out(String str) {
	System.out.println(str);
    }

    public void swap(Object[] array,int i,int j) {
	if(i!=j) {
	    Data data = (Data)array[i];
	    array[i] = array[j];
	    array[j] = data;
	}
    }
}

enum Category {
   NUMBER,DASH,RC,SNAPSHOT
}

