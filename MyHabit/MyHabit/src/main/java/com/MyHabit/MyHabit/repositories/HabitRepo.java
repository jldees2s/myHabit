package com.MyHabit.MyHabit.repositories;

import com.MyHabit.MyHabit.models.Habit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface HabitRepo extends CrudRepository<Habit, Integer> {

}
