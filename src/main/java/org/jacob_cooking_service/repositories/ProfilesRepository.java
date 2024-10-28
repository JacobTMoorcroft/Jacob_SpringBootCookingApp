package org.jacob_cooking_service.repositories;

import org.jacob_cooking_service.entity.Profiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfilesRepository extends JpaRepository<Profiles, Integer>{

}
