package org.jacob_cooking_service.controller;

import org.jacob_cooking_service.entity.Profiles;
import org.jacob_cooking_service.service.ProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/profiles")
public class ProfilesController {

    @Autowired
    private ProfilesService profileService;

    @GetMapping
    public List<Profiles> getAllProfiles(){
        return profileService.getAllProfiles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profiles> getProfile(@PathVariable Integer id){
        Profiles profile = profileService.getProfilesById(id);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Profiles> saveProfiles(@RequestBody Profiles profile){
        Profiles savedProfile = profileService.saveProfiles(profile);
        return new ResponseEntity<>(savedProfile, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Profiles> updateProfiles(@PathVariable Integer id, @RequestBody Profiles profiles){
        Profiles saveProfile = profileService.updateProfiles(id, profiles);
        return new ResponseEntity<>(saveProfile, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Profiles> deleteProfiles(@PathVariable Integer id) {
        Profiles profile = profileService.getProfilesById(id);
        profileService.deleteProfiles(id);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }


}
