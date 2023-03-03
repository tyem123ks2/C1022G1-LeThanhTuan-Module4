package com.example.football_management.repository;

import com.example.football_management.model.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IPlayerRepository extends JpaRepository<Player, Integer> {

    @Query(value = "SELECT * FROM Player WHERE name like concat('%',:name,'%') and is_deleted = false  order by name asc ", nativeQuery = true)
    Page<Player> searchName(String name, Pageable pageable);

//    @Query(value = "SELECT * FROM Player WHERE name like concat('%',:name,'%') and position = position", nativeQuery = true)
//    Page<Player> searchName(String name, String position, Pageable pageable);

    Player findById(Long id);
}
