package com.clickncash.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.clickncash.entity.PurchasedCourse;

@Repository
public interface PurchasedCourseRepository extends JpaRepository<PurchasedCourse, Long> {

	List<PurchasedCourse> findByCourseIdAndUserId(Long courseId, Long userId);
	
	@Query(nativeQuery = true, value = "select count(id) as total from purchasedcourse where courseId=?1")
	Long countTotalEnrolled(Long id);

}
