package com.MyHabit.MyHabit.repositories;

import org.springframework.data.repository.CrudRepository;
import com.MyHabit.MyHabit.models.Followers;
public interface FollowerRepo extends CrudRepository<Followers, Integer> {
}
