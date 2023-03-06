package com.example.football_management.repository;

import com.example.football_management.model.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IPlayerRepository extends JpaRepository<Player, Integer> {
    @Query(value = "SELECT * FROM Player WHERE name like concat('%',:name,'%') and is_deleted = false order by id asc ", nativeQuery = true)
    Page<Player> searchName(@Param("name") String name, Pageable pageable);

    @Query(value = "SELECT * FROM Player WHERE name like concat('%',:name,'%') and (nation_id = :nationId or 0 = :nationId) and (position_id = :positionId or 0 = :positionId) and is_deleted = false", nativeQuery = true)
    Page<Player> searchName(@Param("name") String name, @Param("positionId") int positionId, @Param("nationId") int nationId, Pageable pageable);

    Player findById(Long id);
}
