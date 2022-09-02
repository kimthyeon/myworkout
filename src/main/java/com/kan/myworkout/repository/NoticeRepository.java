package com.kan.myworkout.repository;

import com.kan.myworkout.entity.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer> {

    Page<Notice> findByNttitleContaining(String searchText, Pageable pageable);

}
