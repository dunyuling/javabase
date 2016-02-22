package com.lhg.test.designpattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuhg on 16-2-22.
 */
public class SingleCriteria implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> singlePersons = new ArrayList<>();
        persons.forEach(person -> {
            if(person.getMaritalStatus().equalsIgnoreCase("SINGLE")) {
                singlePersons.add(person);
            }
        });

        return singlePersons;
    }
}
