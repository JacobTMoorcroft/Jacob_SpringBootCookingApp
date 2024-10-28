package org.jacob_cooking_service.repositories;

import org.jacob_cooking_service.entity.Days;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaysRepository extends JpaRepository<Days,Integer> {

}
