package generics.vote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Election {
    private Map<Candidate, List<Person>> createVoters() {
        Map<Candidate, List<Person>> map = new HashMap<>();
        List<Person> people = new ArrayList<>();
        Person person1 = new Person(Gender.FEMALE, AgeCategory.FROM_18_TO_29);
        Person person2 = new Person(Gender.MALE, AgeCategory.FROM_18_TO_29);
        Person person3 = new Person(Gender.MALE, AgeCategory.FROM_50_TO_64);
        people.add(person1);
        people.add(person2);
        people.add(person3);
        map.put(new Candidate("Prezident"), people);
        return map;
    }

    public ElectionResults getResults() {
        return new ElectionResults(createVoters());
    }

    public String getResultsString() {
        ElectionResults results = getResults();
        return results.toString();
    }

}
