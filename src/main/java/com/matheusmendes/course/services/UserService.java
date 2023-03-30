package com.matheusmendes.course.services;

import com.matheusmendes.course.entities.User;
import com.matheusmendes.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }

    public User isert(User obj){
        return repository.save(obj);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
