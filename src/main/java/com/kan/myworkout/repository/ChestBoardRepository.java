package com.kan.myworkout.repository;

import com.kan.myworkout.entity.ChestBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChestBoardRepository extends JpaRepository<ChestBoard, Integer> {
    Page<ChestBoard> findByChtitleContaining(String searchTitle, Pageable pageable);
}
