package org.jacob_cooking_service.repositories;

import org.jacob_cooking_service.entity.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredients, Integer>{

}
