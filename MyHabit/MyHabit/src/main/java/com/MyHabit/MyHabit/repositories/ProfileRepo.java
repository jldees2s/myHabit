package com.MyHabit.MyHabit.repositories;

import com.MyHabit.MyHabit.models.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepo extends CrudRepository<Profile, Integer> {
}
