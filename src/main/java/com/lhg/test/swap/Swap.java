package com.lhg.test.swap;

/**
 * Created by liuhg on 16-2-23.
 */
public class Swap {

    public static void main(String[] args) {
        Swap swap = new Swap();
        int x = 10 , y = 20;
        System.out.println("x: " + x + " \t y: " + y);
//        a:无效
//        swap.swap(x, y);
//        System.out.println("x: " + x + " \t y: " + y);

//        b
//        int arr[] = new int[] {x,y};
//        swap.swapArr(arr,0,1);
//        System.out.println("x: " + arr[0] + " \t y: " + arr[1]);

        //c
//        List<Integer> list = new ArrayList<>();
//        list.add(x);
//        list.add(y);
//        Collections.swap(list,list.indexOf(x),list.indexOf(y));
//        System.out.println("x: " + list.get(0) + " \t y: " + list.get(1));

        //d
        swap.toSwapObject(10, 20);

    }


    private void swap(int x,int y) {
        int temp = x;
        x = y;
        y = temp;
    }

    private void swapArr(int arr[] ,int index0 ,int index1) {
        int temp = arr[index0];
        arr[index0] = arr[index1];
        arr[index1] = temp;
    }

    private void toSwapObject(int x, int y) {
        SwapClass swapClassX = new SwapClass(x);
        SwapClass swapClassY = new SwapClass(y);

        swapObject(swapClassX,swapClassY);
        System.out.println("x: " + swapClassX.getAge() + " \t y: " + swapClassY.getAge());
    }

    private void swapObject(SwapClass swapClassX,SwapClass swapClassY) {
        int age = swapClassX.getAge();
        swapClassX.setAge(swapClassY.getAge());
        swapClassY.setAge(age);
    }

    class SwapClass {
        private int age;

        public SwapClass(int age) {
            setAge(age);
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
