package com.kan.myworkout.repository;

import com.kan.myworkout.entity.StreetBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreetBoardRepository extends JpaRepository<StreetBoard, Integer> {

    Page<StreetBoard> findBySttitleContaining(String searchTitle, Pageable pageable);
}
