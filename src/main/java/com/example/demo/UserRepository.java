package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{     //Choose the User from the one you created (com.example.demo)
    //CRUD - Create, read, update, delete

}
