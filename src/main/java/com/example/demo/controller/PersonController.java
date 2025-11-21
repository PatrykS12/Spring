package com.example.demo.controller;

import com.example.demo.Person;
import com.example.demo.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/people")
public class PersonController {

    private final PersonService personService;


    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping
    public String listPeople(Model model) {
        List<Person> people = personService.getPeople();

        model.addAttribute("people", people);
        return "people-list";
    }


    @GetMapping("/{index}")
    public String getPersonDetails(@PathVariable int index, Model model) {
        Optional<Person> personOptional = personService.getPerson(index);

        if (personOptional.isPresent()) {
            model.addAttribute("person", personOptional.get());
            return "person-details";
        } else {
            return "redirect:/people";
        }
    }


    @GetMapping("/add")
    public String showAddPersonForm(Model model) {
        model.addAttribute("person", new Person());
        return "person-form";
    }


    @PostMapping("/add")
    public String addPersonSubmit(Person person) {

        personService.addPerson(person);
        return "redirect:/people";
    }
}
