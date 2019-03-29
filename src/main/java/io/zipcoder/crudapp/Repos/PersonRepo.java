package io.zipcoder.crudapp.Repos;


import io.zipcoder.crudapp.Model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepo extends CrudRepository<Person, Integer> {


}