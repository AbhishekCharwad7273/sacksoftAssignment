package com.CrudOperation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.CrudOperation.Entity.User;


public interface UserRepo extends JpaRepository<User, Integer> {

}
