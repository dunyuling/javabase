package com.lhg.test.designpattern.filter;

import java.util.List;

/**
 * Created by liuhg on 16-2-22.
 */
public class OrCriteria implements Criteria {

    private Criteria firstCriteria;
    private Criteria otherCriteria;

    public OrCriteria(Criteria firstCriteria, Criteria otherCriteria) {
        this.firstCriteria = firstCriteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> firstCriteriaItems = firstCriteria.meetCriteria(persons);
        List<Person> otherCriteriaItems = otherCriteria.meetCriteria(persons);

        /*otherCriteriaItems.forEach(person -> {
            if (!firstCriteriaItems.contains(person)) {
                firstCriteriaItems.add(person);
            }
        });
        return firstCriteriaItems;*/

        firstCriteriaItems.forEach(person -> {
            if (!otherCriteriaItems.contains(person)) {
                otherCriteriaItems.add(person);
            }
        });
        return otherCriteriaItems;
    }
}
