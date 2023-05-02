package com.MyHabit.MyHabit.repositories;

import com.MyHabit.MyHabit.models.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<Users, Integer> {
    Users getByUserName(String userName);
}
