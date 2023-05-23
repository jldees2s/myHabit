package com.MyHabit.MyHabit.repositories;

import com.MyHabit.MyHabit.models.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepo extends CrudRepository<Profile, Integer> {

  void deleteProfileById(int id);

  Optional<Profile> findProfileById(int id); // optional in case no profile w given id
}
