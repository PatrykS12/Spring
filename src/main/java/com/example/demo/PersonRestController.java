package com.example.demo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/people")
public class PersonRestController {

    private final PersonService personService;

    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getPeople() {
        return personService.getPeople();
    }

    @GetMapping("/{index}")
    public ResponseEntity<Person> getPerson(@PathVariable int index) {
        if (index < 0 || index >= personService.getPeople().size()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(personService.getPeople().get(index));
    }

    @PostMapping
    public ResponseEntity<Void> addPerson(@RequestBody Person person) {
        personService.addPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{index}")
    public ResponseEntity<Void> updatePerson(@PathVariable int index, @RequestBody Person person) {
        if (index < 0 || index >= personService.getPeople().size()) {
            return ResponseEntity.notFound().build();
        }
        personService.setPerson(index, person);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{index}")
    public ResponseEntity<Void> removePerson(@PathVariable int index) {
        if (index < 0 || index >= personService.getPeople().size()) {
            return ResponseEntity.notFound().build();
        }
        personService.removePerson(index);
        return ResponseEntity.noContent().build();
    }
}