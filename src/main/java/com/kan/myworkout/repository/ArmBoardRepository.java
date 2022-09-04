package com.kan.myworkout.repository;

import com.kan.myworkout.entity.ArmBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArmBoardRepository extends JpaRepository<ArmBoard, Integer> {

    Page<ArmBoard> findByArtitleContaining(String searchTitle, Pageable pageable);
}
