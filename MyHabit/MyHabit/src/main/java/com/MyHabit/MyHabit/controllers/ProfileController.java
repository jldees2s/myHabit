package com.MyHabit.MyHabit.controllers;

import com.MyHabit.MyHabit.models.Profile;
import com.MyHabit.MyHabit.repositories.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    ProfileRepo profileRepo;

    // METHODS
    // view user's profile
    @GetMapping("/view/{profileId}")
    public String displayUserProfile(Model model, @PathVariable int profileId) {
        Optional<Profile> optProfile = profileRepo.findById(profileId);
        if (optProfile.isPresent()) {
            Profile profile = optProfile.get();
            model.addAttribute("profile", profile);
            return "profile/view";
        } else {
            return "/profile";
        }
    }

    // display form - edit user profile
    @GetMapping("edit")
    public String displayEditProfileForm(Model model) {
        model.addAttribute(new Profile());
        return "profile/edit";
    }

    // process form - edit user profile
    @PostMapping("edit")
    public String processEditProfileForm(@ModelAttribute @Valid Profile newProfile, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "profile/edit";
        } else {
            profileRepo.save(newProfile);
        }
        return "/profile";
    }

}
