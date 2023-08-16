package com.example.crud.repository;

import com.example.crud.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface DataRepo extends JpaRepository<Model,Long> {

}
