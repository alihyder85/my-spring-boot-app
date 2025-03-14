package com.example.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.myapp.model.Usertable;

@Repository
public interface UserRepository extends JpaRepository<Usertable, String> {
}
