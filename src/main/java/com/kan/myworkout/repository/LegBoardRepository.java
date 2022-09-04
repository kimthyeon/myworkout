package com.kan.myworkout.repository;

import com.kan.myworkout.entity.LegBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LegBoardRepository extends JpaRepository<LegBoard, Integer> {

    Page<LegBoard> findByLetitleContaining(String searchTitle, Pageable pageable);
}
