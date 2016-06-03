package com.lhg.test.designpattern.iterator;

/**
 * Created by liux on 16-3-15.
 */
public class NameRepository implements Container {
    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private String names[] = {"Robert","John","Julie","Lora"};
    private class NameIterator implements Iterator {
        private int index;

        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        @Override
        public Object next() {
            return hasNext() ? names[index++] : null;
        }
    }
}
