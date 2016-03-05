package com.lhg.test.designpattern.filter;

import java.util.List;

/**
 * Created by liuhg on 16-2-22.
 */
public class AndCriteria implements Criteria {

    private Criteria firstCriteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria firstCriteria,Criteria otherCriteria) {
        this.firstCriteria = firstCriteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> firstCriteriaItems = firstCriteria.meetCriteria(persons);
        return otherCriteria.meetCriteria(firstCriteriaItems);
    }
}
