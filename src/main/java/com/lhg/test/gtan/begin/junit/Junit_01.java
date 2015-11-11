package com.lhg.test.gtan.begin.junit;

import java.util.*;

public class Junit_01 {

    public static void main(String args[]) {
	Junit_01 junit_01 = new Junit_01();
	List<Data> dataList = junit_01.init();
	junit_01.sort(dataList);
    }

    public List<Data> init() {
 	List<Data> dataList = new ArrayList<Data>();
        String[] dataArr = {"2.7.8","2.7.8-SNAPSHOT","2.7.8-1","2.4.4-SNAPSHOT","2.7.8-2","2.7.8.RC1",
                "2.7.8.RC2","2.8.9-1","2.4.3.RC2"};
        int i = 0;
        for(i=0;i<dataArr.length;i++) {
            Data data = new Data();
            data.setVersion(dataArr[i]);
            dataList.add(data);
        }
	return dataList;

    }

    public void sort(List<Data> dataList) {
	Object[] dataArr1 = dataList.toArray();
	int i = 0,j = 0;
	Sort sort = new Sort();
        for(i=0;i<dataArr1.length;i++) {
	    for(j=i+1;j<dataArr1.length;j++) {
		String version_01 = ((Data)dataArr1[i]).getVersion().trim();
		String version_02 = ((Data)dataArr1[j]).getVersion().trim();
		sort.isSameKind(dataArr1,i,j,version_01,version_02);
	    }
        }

	for(i=0;i<dataArr1.length;i++) {
	    out(((Data)dataArr1[i]).getVersion());
	}
    }

    public static void out(String str) {
	System.out.println(str);
    }

}
