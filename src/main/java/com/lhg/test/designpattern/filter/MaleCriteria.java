package com.lhg.test.designpattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuhg on 16-2-22.
 */
public class MaleCriteria implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> malePersons = new ArrayList<>();
        persons.forEach(person -> {
            if(person.getGender().equalsIgnoreCase("MALE")) {
                malePersons.add(person);
            }
        });

        return malePersons;
    }
}
