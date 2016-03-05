package com.lhg.test.designpattern.filter;

import java.util.List;

/**
 * Created by liuhg on 16-2-22.
 */
public interface Criteria {
    public List<Person> meetCriteria(List<Person> persons);
}