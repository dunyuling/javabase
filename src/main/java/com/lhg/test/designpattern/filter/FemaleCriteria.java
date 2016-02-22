package com.lhg.test.designpattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuhg on 16-2-22.
 */
public class FemaleCriteria implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> femalePersons = new ArrayList<>();
        persons.forEach(person -> {
            if(person.getGender().equalsIgnoreCase("FEMALE")) {
                femalePersons.add(person);
            }
        });

        return femalePersons;
    }
}
