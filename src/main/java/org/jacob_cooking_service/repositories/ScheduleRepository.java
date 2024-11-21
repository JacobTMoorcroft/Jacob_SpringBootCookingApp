package org.jacob_cooking_service.repositories;

import org.jacob_cooking_service.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, String> {

    @Modifying
    @Transactional
    @Query("UPDATE Schedule s SET s.profiles = NULL, s.dishes = NULL")
    void clearSchedule();

}
