package com.lhg.test.designpattern.iterator;

/**
 * Created by liux on 16-3-15.
 */
public class IteratorPatternDemo {
    public static void main(String[] args) {
        NameRepository nameRepository = new NameRepository();

        //TODO how to next
/*        Iterator iterator =  nameRepository.getIterator();
        for(Object obj = iterator.next();iterator.hasNext();obj = iterator.next()) {
            System.out.println((obj == null) + "\t obj: " + obj);
        }*/

        for(Iterator iterator = nameRepository.getIterator();iterator.hasNext();) {
            String name = (String) iterator.next();
            System.out.println(name);
        }

    }
}
