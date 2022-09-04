package com.kan.myworkout.repository;

import com.kan.myworkout.entity.ShoulderBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoulderBoardRepository extends JpaRepository<ShoulderBoard, Integer> {

    Page<ShoulderBoard> findByShtitleContaining(String searchTitle, Pageable pageable);

}
