package com.example.demo;

import com.example.demo.Person;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.SessionScope;

@Service
//@SessionScope
public class PersonService {


    private final List<Person> people = new ArrayList<>();


    @PostConstruct
    public void init() {
        people.add(new Person("Szymon", "Sroka"));
        people.add(new Person("Bartek", "Soplica"));
    }



    public List<Person> getPeople() {
        return people;
    }


    public Optional<Person> getPerson(int index) {
        if (index >= 0 && index < people.size()) {
            return Optional.of(people.get(index));
        }
        return Optional.empty();
    }


    public void addPerson(Person person) {
        if (person != null) {
            people.add(person);
        }
    }


    public boolean setPerson(int index, Person updatedPerson) {
        if (index >= 0 && index < people.size() && updatedPerson != null) {
            people.set(index, updatedPerson);
            return true;
        }
        return false;
    }


    public boolean removePerson(int index) {
        if (index >= 0 && index < people.size()) {
            people.remove(index);
            return true;
        }
        return false;
    }
}
