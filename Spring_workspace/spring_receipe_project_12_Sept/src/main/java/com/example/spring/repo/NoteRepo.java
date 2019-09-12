package com.example.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.model.Note;

@Repository
public interface NoteRepo extends JpaRepository<Note, Integer> {

}
