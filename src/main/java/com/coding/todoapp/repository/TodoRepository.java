package com.coding.todoapp.repository;

import com.coding.todoapp.model.Todo;
import com.coding.todoapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    public List<Todo> findByUserOrderBySchedule(User user);
}
