package com.kan.myworkout.repository;

import com.kan.myworkout.entity.BackBoard;
import com.kan.myworkout.entity.ChestBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackBoardRepository extends JpaRepository<BackBoard, Integer> {

    Page<BackBoard> findByBatitleContaining(String searchTitle, Pageable pageable);
}
