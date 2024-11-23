package org.jacob_cooking_service.repositories;


import org.jacob_cooking_service.entity.History;
import org.jacob_cooking_service.entity.Profiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Integer>{

    List<History> findByProfiles(Profiles profiles);
}
