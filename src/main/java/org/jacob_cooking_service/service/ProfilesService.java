package org.jacob_cooking_service.service;

import org.jacob_cooking_service.entity.Profiles;
import org.jacob_cooking_service.repositories.ProfilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProfilesService {

    @Autowired
    private ProfilesRepository profilesRepository;

    public List<Profiles> getAllProfiles() {
        return profilesRepository.findAll();
    }
    // Optional<> returns a single object which may be empty allowing for additional methods later
    public Profiles getProfilesById(Integer id){
        return profilesRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public Profiles saveProfiles(Profiles profiles){
        return profilesRepository.save(profiles);
    }

    public Profiles updateProfiles(Integer id, Profiles profiles){
        Profiles existingProfiles = profilesRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        existingProfiles.setRelation(profiles.getRelation());
        existingProfiles.setName(profiles.getName());
        profilesRepository.save(existingProfiles);

        return profilesRepository.save(profiles);
    }

    public void deleteProfiles(Integer id){
        profilesRepository.deleteById(id);
    }
}
