package com.qa.repository;

import com.qa.domain.Monsters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonsterRepository extends JpaRepository<Monsters, Long> {

    Monsters findByName(String name);

}
