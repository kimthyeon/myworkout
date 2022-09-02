package com.kan.myworkout.repository;

import com.kan.myworkout.entity.FreeBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreeBoardRepository extends JpaRepository<FreeBoard, Integer> {
    Page<FreeBoard> findByFrtitleContaining(String searchText, Pageable pageable);
}
