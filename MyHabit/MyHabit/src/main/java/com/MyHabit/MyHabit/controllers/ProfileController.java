package com.MyHabit.MyHabit.controllers;

import com.MyHabit.MyHabit.models.Profile;
import com.MyHabit.MyHabit.repositories.ProfileRepo;
import com.MyHabit.MyHabit.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/profile")
public class ProfileController {

  private final ProfileService profileService;

//    @Autowired
//    ProfileRepo profileRepo;

  // CONSTRUCTORS
  public ProfileController(ProfileService profileService) {
    this.profileService = profileService;
  }

  // METHODS
  // view user's profile
  @GetMapping("/{id}")
  public ResponseEntity<Profile> displayUserProfile(@PathVariable("id") int profileId) {
    Profile userProfile = profileService.findProfileById(profileId);
    return new ResponseEntity<>(userProfile, HttpStatus.OK);
  }

  // add new profile
  @PostMapping("/add")
  public ResponseEntity<Profile> addProfile(@RequestBody Profile profile, String first, String last, String display, String email, String location, String pic, String status, String bio) {
    Profile newProfile = profileService.addProfile(profile, first, last, display, email, location, pic, status, bio);
    return new ResponseEntity<>(newProfile, HttpStatus.CREATED);
  }

  // update profile information
  @PutMapping("/update/profile")
  public ResponseEntity<Profile> updateProfile(@RequestBody Profile profile, String first, String last, String display, String email, String location) {
    Profile updatedProfile = profileService.updateProfile(profile, first, last, display, email, location);
    return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
  }

  // update profile picture
  @PutMapping("/update/picture")
  public ResponseEntity<Profile> updatePicture(@RequestBody Profile profile, String pic) {
    Profile newPic = profileService.updateProfilePic(profile, pic);
    return new ResponseEntity<>(newPic, HttpStatus.OK);
  }

  // update profile status
  @PutMapping("/update/status")
  public ResponseEntity<Profile> updateStatus(@RequestBody Profile profile, String status) {
    Profile newStatus = profileService.updateStatus(profile, status);
    return new ResponseEntity<>(newStatus, HttpStatus.OK);
  }

  // update profile bio
  @PutMapping("/update/bio")
  public ResponseEntity<Profile> updateBio(@RequestBody Profile profile, String bio) {
    Profile newBio = profileService.updateBio(profile, bio);
    return new ResponseEntity<>(newBio, HttpStatus.OK);
  }

  // delete user profile
  @DeleteMapping("delete/{id}")
  public ResponseEntity<?> deleteProfile(@PathVariable("id") int profileId) {
    profileService.deleteProfile(profileId);
    return new ResponseEntity<>(HttpStatus.OK);
  }


//    // view user's profile
//    @GetMapping("/view/{profileId}")
//    public String displayUserProfile(Model model, @PathVariable int profileId) {
//        Optional<Profile> optProfile = profileRepo.findById(profileId);
//        if (optProfile.isPresent()) {
//            Profile profile = optProfile.get();
//            model.addAttribute("profile", profile);
//            return "profile/view";
//        } else {
//            return "/profile";
//        }
//    }
//
//    // display form - edit user profile
//    @GetMapping("edit")
//    public String displayEditProfileForm(Model model) {
//        model.addAttribute(new Profile());
//        return "profile/edit";
//    }
//
//    // process form - edit user profile
//    @PostMapping("edit")
//    public String processEditProfileForm(@ModelAttribute @Valid Profile newProfile, Errors errors, Model model) {
//        if (errors.hasErrors()) {
//            return "profile/edit";
//        } else {
//            profileRepo.save(newProfile);
//        }
//        return "/profile";
//    }

}
