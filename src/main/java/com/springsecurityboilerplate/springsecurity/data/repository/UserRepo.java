package com.springsecurityboilerplate.springsecurity.data.repository;

import com.springsecurityboilerplate.springsecurity.data.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Abdur Rahim Nishad
 * @created 09/02/2021 - 11:42 PM
 * @project springsecurity
 */
@Repository
public interface UserRepo extends CrudRepository<Users,String> {
    Users findByEmail(String email);
}
