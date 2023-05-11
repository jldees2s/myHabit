package com.MyHabit.MyHabit.repositories;

import com.MyHabit.MyHabit.models.UserHabit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserHabitRepo extends CrudRepository<UserHabit, Integer> {
}
