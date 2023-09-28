package com.clickncash.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.clickncash.entity.Queries;

@Repository
public interface QueriesRepository extends JpaRepository<Queries, Long>{

	@Query(nativeQuery = true, value = "select count(id) from queries where email=?1 and createdAt>=DATE(NOW() + INTERVAL 0 SECOND )")
	Long countTodayQueryByEmail(String email);

	@Query(nativeQuery = true, value = "select * from queries order by id desc")
	Page<Queries> getAllQueries(Pageable pageable);
}
