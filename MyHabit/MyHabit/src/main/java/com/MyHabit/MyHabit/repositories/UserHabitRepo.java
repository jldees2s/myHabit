package com.MyHabit.MyHabit.repositories;

import com.MyHabit.MyHabit.models.HabitSettings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserHabitRepo extends CrudRepository<HabitSettings, Integer> {
}
