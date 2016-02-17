package com.lhg.test.softreferencetest;

/**
 * Created by liuhg on 16-1-29.
 */
public class Empolyee {
    private String id;
    private String name;
    private String department;
    private String phone;
    private int salary;
    //下面的a变量只为消耗一部分内存空间，占用了1M
    //因为对于软可及对象，只有在系统内存不足时才会被回收，所以必须占用掉大部分内存
    private byte[] a = new byte[1024*1024*1024];

    public Empolyee(String id){
        this.id = id;
        this.getDataFromInfoCenter();
    }

    private void getDataFromInfoCenter(){
        //下面的代码仅为测试，实际员工的信息应从数据库中查询
        this.name = "***";
        this.department = "xiaoshou";
        this.phone = "13562558952";
        this.salary = 5000;
    }

    public String getId(){
        return this.id;
    }
}
