package com.example.spring_h2_jpa_11Sept.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_h2_jpa_11Sept.model.Publisher;
@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
