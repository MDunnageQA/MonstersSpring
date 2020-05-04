package org.example.repository;

import org.example.domain.Monsters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MonsterRepository extends JpaRepository<Monsters, Long> {

    Monsters findByName(String name);

}
