package com.lhg.test.gtan.begin.junit1;


import java.util.*;
import java.util.regex.*;

public class Sort {
    public  BaseVersion judgeKind(String str) {
	if(str.contains("-") && !str.contains("SNAPSHOT")) {
	    return new DashVersion(str); 
	} else if(str.contains("SNAPSHOT")) {
	    return new SnapshotVersion(str);
	} else if(str.contains("RC")) {
	    return new RcVersion(str);
	} else {
	    return new NumberVersion(str);
	}
    }
}

enum Category {
    NUMBER,DASH,SNAPSHOT,RC
}

abstract class BaseVersion implements Comparable<BaseVersion> {
    private int firstV, secondV, thirdV;
    private String version;
    private Category category; 

    public BaseVersion(String version) {
	this.version = version;
    } 

    public void setCategory(Category category) {
	this.category = category;
    }

    public Category getCategory() {
	return category;
    } 

    public int compareNum(BaseVersion version) {
        if(firstV != version.firstV ) {
            return firstV-version.firstV;
        } else if(secondV != version.secondV) {
            return secondV- version.secondV;
        } else {
            return thirdV - version.thirdV;
        }
    }   

    public String[] splitStr(String strValue,Category category) {
	String[] arr = {};
	switch(category) {
	case NUMBER:
	case RC:
	    Pattern pattern = Pattern.compile("[.]");
	    arr = pattern.split(strValue);
	    break;
	case DASH:
	case SNAPSHOT:
	    pattern = Pattern.compile("[.|-]");
	    arr = pattern.split(strValue);
	    break;
	}
	return arr;
   }


   public String init(String strValue,Category category) {
    	String[] arr = splitStr(strValue,category);
	firstV = Integer.parseInt(arr[0]);
	secondV = Integer.parseInt(arr[1]);
	thirdV = Integer.parseInt(arr[2]);
	if(!Category.NUMBER.equals(category)) {
	    return arr[3];
	}
	return null;
   }
}

class NumberVersion extends BaseVersion {

    public NumberVersion(String version) {
	super(version);
	setCategory(Category.NUMBER);
	init(version,this.getCategory());
    }

    public  int compareTo(BaseVersion another) {
	int flag = 0;
	switch(another.getCategory()) {
	case NUMBER:
	case SNAPSHOT:
	    flag = compareNum(another);
	    break;
	case DASH:
	    if(compareNum(another) == 0) {
		flag = -1;
  	    } else {
		flag = compareNum(another);
	    }
	    break;
	case RC:
	    if(compareNum(another) == 0) {
		flag =  1;
	    } else {
		flag = compareNum(another);
	    }	
	    break;    
	}
	return flag;
    }    
}

class DashVersion extends BaseVersion {

    int minorV;
    
    public DashVersion(String version) {
	super(version);
	setCategory(Category.DASH);
	minorV = Integer.parseInt(init(version,this.getCategory()));
    }

    public  int compareTo(BaseVersion another) {
        int flag = 0;
        switch(another.getCategory()) {
        case DASH:
	    if(compareNum(another) ==0) {
		flag = minorV - ((DashVersion)another).getMinorV();
	    } else {
		flag = compareNum(another);
	    }
	    break;
	case NUMBER:
        case SNAPSHOT:
	case RC:
	    if(compareNum(another) == 0) {
		flag = 1;
	    } else {
		flag = compareNum(another);
	    }	  
	    break;  
        }
        return flag;
    }

    public int getMinorV() {
	return minorV;
   }    
}

class SnapshotVersion extends BaseVersion {

    public SnapshotVersion(String version) {
	super(version);
	setCategory(Category.SNAPSHOT);
	init(version,this.getCategory());
    }

    public  int compareTo(BaseVersion another) {
        int flag = 0;
        switch(another.getCategory()) {
        case NUMBER:
        case DASH:
        case RC:
            if(compareNum(another) == 0) {
                flag = -1;
            } else {
                flag = compareNum(another);
            }
	    break;
	case SNAPSHOT:
	    flag = compareNum(another);
	    break;
	}
        return flag;
    }
}


class RcVersion extends BaseVersion {
	
    String rc;

    public RcVersion(String version) {
	super(version);
	setCategory(Category.RC);
	rc = init(version,this.getCategory());
    }

    public  int compareTo(BaseVersion another) {
        int flag = 0;
        switch(another.getCategory()) {
	case NUMBER:
        case DASH:
            if(compareNum(another) ==0) {
                flag = -1; 
	    } else {
                flag = compareNum(another);
            }
	    break;
        case SNAPSHOT:
	    if(compareNum(another) == 0) {
		flag = 1;
	    } else {
		flag = compareNum(another);
	    }
	    break;
        case RC:
            if(compareNum(another) == 0) {
		String temp = ((RcVersion)another).rc;
                rc.compareTo(temp);
            } else {
                flag = compareNum(another);
            }
	    break;
        }
        return flag;
    }
}
