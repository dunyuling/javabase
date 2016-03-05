package com.lhg.test;

/**
 * Created by liuhg on 16-2-24.
 */
public class FinalChange {

    public static void main(String[] args) {
        new FinalChange().use();
    }

    void use() {
        FinalChange fb = new FinalChange();
        fb.setAge(20);
        FinalDemo fd = new FinalDemo(fb);
        System.out.println("FinalDemo: " + fd.fb.getAge() + " \t fd: " + fb.hashCode() + " \t fb: " + fd.fb.hashCode());
        fb.setAge(22);
        System.out.println("FinalDemo: " + fd.fb.getAge() + " \t fd: " + fb.hashCode() + " \t fb: " + fd.fb.hashCode());
    }

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    final class FinalDemo {
        private final FinalChange fb;

        private FinalDemo(FinalChange fb) {
            this.fb = fb;
        }
    }
}
//FinalDemo: 20 	 fd: 21685669 	 fb: 2133927002
//FinalDemo: 22 	 fd: 21685669 	 fb: 2133927002
//FinalDemo: 20 	 fd: 21685669 	 fb: 21685669
//FinalDemo: 22 	 fd: 21685669 	 fb: 21685669