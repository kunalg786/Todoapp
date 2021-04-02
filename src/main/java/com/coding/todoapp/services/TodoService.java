package com.coding.todoapp.services;

import com.coding.todoapp.model.Todo;
import com.coding.todoapp.model.User;
import com.coding.todoapp.repository.TodoRepository;
import com.coding.todoapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TodoService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    TodoRepository todoRepository;
    public List<Todo> getAllTodo(){
        List<Todo> todos = null;
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> optionalUser  = userRepository.findUserByEmail(email);
        if (optionalUser.isPresent()){
            todos = todoRepository.findByUserOrderBySchedule(optionalUser.get());
            return todos;
        }
        return todos;

    }
    public Todo getTodo(int id){
        Optional<Todo> optionalTodo=todoRepository.findById(id);
        Todo todo = null;
        if (optionalTodo.isPresent()){
            todo = optionalTodo.get();
        }
        return todo;
    }
    public void saveTodo(Todo todo){
        todoRepository.save(todo);
    }
    public  void deleteTodo(int id){
        todoRepository.deleteById(id);
    }
}
