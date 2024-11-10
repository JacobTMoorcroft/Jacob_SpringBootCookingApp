package org.jacob_cooking_service.service;

import org.jacob_cooking_service.entity.Profiles;
import org.jacob_cooking_service.repositories.ProfilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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

        if (profiles.getProfile_name() != null){
            existingProfiles.setProfile_name(profiles.getProfile_name());
        }

        if (profiles.getRelation() != null){
            existingProfiles.setRelation(profiles.getRelation());
        }

        return profilesRepository.save(existingProfiles);
    }

    public void deleteProfiles(Integer id){
        profilesRepository.deleteById(id);
    }
}
