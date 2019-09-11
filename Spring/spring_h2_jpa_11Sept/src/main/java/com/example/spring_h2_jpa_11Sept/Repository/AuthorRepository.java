package com.example.spring_h2_jpa_11Sept.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_h2_jpa_11Sept.model.Author;
@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
