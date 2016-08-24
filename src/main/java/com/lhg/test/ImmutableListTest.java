package com.lhg.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by liuhg on 16-7-18.
 */
public class ImmutableListTest {

    public static void main(String[] args) {
        List<D> list = new ArrayList<>();
        list.add(new D("a", "b"));

        List<D> list1 = list.stream().map(d ->
                new D(d.getA(), "123")
        ).collect(Collectors.toList());
        list.forEach(d -> System.out.println(d.getB()));
        list1.forEach(d -> System.out.println(d.getB()));
        System.out.println(list.hashCode() + " \t " + list1.hashCode());
    }

}

class D {

    private String a;
    private String b;

    public D(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        D d = (D) o;

        if (a != null ? !a.equals(d.a) : d.a != null) return false;
        return b != null ? b.equals(d.b) : d.b == null;

    }

    @Override
    public int hashCode() {
        int result = a != null ? a.hashCode() : 0;
        result = 31 * result + (b != null ? b.hashCode() : 0);
        return result;
    }


}

