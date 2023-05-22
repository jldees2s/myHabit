package com.MyHabit.MyHabit.services;

import com.MyHabit.MyHabit.exceptions.UserNotFoundException;
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
    public Profile addProfile(Profile profile, String first, String last, String display, String email, String location, String pic, String status, String bio){
        profile.setFirstName(first);
        profile.setLastName(last);
        profile.setDisplayName(display);
        profile.setEmail(email);
        profile.setLocation(location);
        profile.setProfileImageURL(pic);
        profile.setStatus(status);
        profile.setBio(bio);
        return profileRepo.save(profile);
    }

    // update existing profile (personal information ONLY)
    public Profile updateProfile(Profile profile, String first, String last, String display, String email, String location){
        profile.setFirstName(first);
        profile.setLastName(last);
        profile.setDisplayName(display);
        profile.setEmail(email);
        profile.setLocation(location);
        return profileRepo.save(profile);
    }

    // update profile picture
    public Profile updateProfilePic(Profile profile, String pic){
        profile.setProfileImageURL(pic);
        return profileRepo.save(profile);
    }

    // update status
    public Profile updateStatus(Profile profile, String status){
        profile.setStatus(status);
        return profileRepo.save(profile);
    }

    // update bio
    public Profile updateBio(Profile profile, String bio){
        profile.setBio(bio);
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
