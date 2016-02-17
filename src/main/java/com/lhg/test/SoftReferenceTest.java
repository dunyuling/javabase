package com.lhg.test;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * Created by liuhg on 16-1-29.
 */
public class SoftReferenceTest {
    public static void main(String... args){
        ReferenceQueue<? super A> rq= new ReferenceQueue<>();
        A a= new A();
        a.s="hello";
//        STE<A> r= new STE<>(a,rq);
        Reference<A> r= new SoftReference<A>(a,rq);
        a=null;
        byte[] bytes = new byte[1024*1024*1024*5];
      /*  try {
            r.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }*/
        System.gc();
        /*try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println(r.get().s + " \t ");
        Reference ref=  rq.poll();
        System.out.println(ref == null);
        while(ref!=null){
            System.out.println(ref.get());
        }

    }
}

class STE<A> extends SoftReference<A> {

    public STE(A referent, ReferenceQueue<? super A> q) {
        super(referent, q);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        this.clear();
    }
}

class A{
    String s;
}