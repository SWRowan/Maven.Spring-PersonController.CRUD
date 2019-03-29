package io.zipcoder.crudapp.Controller;


import io.zipcoder.crudapp.Model.Person;
import io.zipcoder.crudapp.Repos.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class PersonController {


    private final PersonRepo personRepo;

    @Autowired
    public PersonController(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }


    @PostMapping("/people/")
    public ResponseEntity<Person> createPerson(@RequestBody Person p) {
        return new ResponseEntity<>(personRepo.save(p), HttpStatus.CREATED);
    }

    @GetMapping("/people/{id}")
    public Person getPerson(@PathVariable int id) {
        return this.personRepo.findOne(id);
    }

    @GetMapping("/people/")
    public Iterable<Person> getPersonList() {
        return this.personRepo.findAll();
    }

    @PutMapping("/people/")
    public Person updatePerson(@RequestBody Person p) {
        Person person = personRepo.findOne(p.getId());
        person.setFirstName(p.getFirstName());
        person.setLastName(p.getLastName());
        return personRepo.save(p);
    }

    @DeleteMapping("/people/{id}")
    public void deletePerson(@PathVariable int id) {
        personRepo.delete(id);
    }


}
