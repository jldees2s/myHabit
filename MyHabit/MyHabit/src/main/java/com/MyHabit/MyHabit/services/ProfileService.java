package com.MyHabit.MyHabit.services;

import com.MyHabit.MyHabit.models.Profile;
import com.MyHabit.MyHabit.repositories.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    // import the repo - final, so it cannot be reassigned just values updated
    private final ProfileRepo profileRepo;

    // CONSTRUCTOR
    @Autowired
    public ProfileService(ProfileRepo profileRepo) {
        this.profileRepo = profileRepo;
    }

    // METHODS

    // add entirely new profile
    public Profile addProfile(Profile profile){
        profile.setFirstName();
        profile.setLastName();
        profile.setDisplayName();
        profile.setEmail();
        profile.setLocation();
        profile.setProfileImageURL();
        profile.setStatus();
        profile.setBio();
        return profileRepo.save(profile);
    }

    // update existing profile (personal information ONLY)
    public Profile updateProfile(Profile profile){
        profile.setFirstName();
        profile.setLastName();
        profile.setDisplayName();
        profile.setEmail();
        profile.setLocation();
        return profileRepo.save(profile);
    }

    // update profile picture
    public Profile updateProfilePic(Profile profile){
        profile.setProfileImageURL();
        return profileRepo.save(profile);
    }

    // update status
    public Profile updateStatus(Profile profile){
        profile.setStatus();
        return profileRepo.save(profile);
    }

    // update bio
    public Profile updateBio(Profile profile){
        profile.setBio();
        return profileRepo.save(profile);
    }

    // find profile by id
    public Profile findProfileById(int id){
        return profileRepo.findProfileById(id).orElseThrow(() -> new UserNotFoundException("No Profile Found for Profile ID" + id));
    }

    // delete profile
    public void deleteProfile(int id){
        profileRepo.deleteProfileById(id);
    }

}
