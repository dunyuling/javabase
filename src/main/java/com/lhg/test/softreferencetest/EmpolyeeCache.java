package com.lhg.test.softreferencetest;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Hashtable;

public class EmpolyeeCache {

    private static EmpolyeeCache cache = null;
    private Hashtable<String, EmpolyeeRef> empolyeeRefs = null;
    private ReferenceQueue<Empolyee> refQue = null;

    private EmpolyeeCache() {
        this.empolyeeRefs = new Hashtable<>();
        this.refQue = new ReferenceQueue<>();
    }

    //取得缓存器实例
    public static EmpolyeeCache getInstance() {
        if (cache == null)
            cache = new EmpolyeeCache();
        return cache;
    }

    public Empolyee getEmpolyee(String id) {
        Empolyee em = null;
        if (empolyeeRefs.containsKey(id)) {
            //System.out.println("empolyeeRefs.contains(" + id + ") == true");
            em = empolyeeRefs.get(id).get();
        }
        //有2种情况会使 em == null：一是，从来就没有缓存过该id的员工；
        //二是，曾经缓存过该员工，但该员工已被垃圾回收机制回收（该员工对应的引用为软引用）
        if (em == null) {
            em = new Empolyee(id);
            //无论导致em == null的原因是什么，都需要重新缓存em
            this.cacheEmpolyee(em);
        }
        return em;
    }

    //缓存em对象
    private void cacheEmpolyee(Empolyee em) {
        //在缓存对象之前，需要清除那些“所软引用的Empolyee对象已经被回收的EmployeeRef对象”
        System.out.println("ID为" + em.getId() + "的员工不在缓存中，正在加入缓存中...");
        this.cleanCache();
        EmpolyeeRef ref = new EmpolyeeRef(em, this.refQue);
        this.empolyeeRefs.put(em.getId(), ref);
        System.out.println("缓存成功。");
    }

    //清除那些所软引用的Employee对象已经被回收的EmployeeRef对象
    private void cleanCache() {
        System.out.println("正在清除ReferenceQueue中无用的EmpolyeeRef对象...");
        EmpolyeeRef ref = null;
        while ((ref = (EmpolyeeRef) refQue.poll()) != null) {
            empolyeeRefs.remove(ref.key);
            System.out.println("ID为" + ref.key + "的已被回收");
        }
        System.out.println("清除完毕。");
    }

    private class EmpolyeeRef extends SoftReference<Empolyee> {
        private String key;

        public EmpolyeeRef(Empolyee empolyee, ReferenceQueue<Empolyee> refQue) {
            super(empolyee, refQue);
            this.key = empolyee.getId();
        }
    }

    public static void main(String[] args) throws Exception {
        //下面的a变量只为消耗一部分内存空间，占用了4M
        //因为对于软可及对象，只有在系统内存不足时才会被回收，所以必须占用掉大部分内存
        byte[] a = new byte[1024 * 1024 * 1024];

        EmpolyeeCache cache = EmpolyeeCache.getInstance();
        System.out.println(cache);
        System.out.println(cache.getEmpolyee("zhangsan"));
        System.out.println(cache.getEmpolyee("zhangsan"));
        System.out.println(cache.getEmpolyee("lisi"));
        System.out.println(cache.getEmpolyee("wanwu"));

        System.out.println();

        System.out.println("max = " + (Runtime.getRuntime().maxMemory() / 1024 / 1024));
        System.out.println("free = " + (Runtime.getRuntime().freeMemory() / 1024 / 1024));
        System.out.println("total = " + (Runtime.getRuntime().totalMemory() / 1024 / 1024));
    }

}
