package com.clickncash.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clickncash.entity.PurchasedCourse;

@Repository
public interface PurchasedCourseRepository extends JpaRepository<PurchasedCourse, Long> {

	List<PurchasedCourse> findByCourseIdAndUserId(Long courseId, Long userId);

}
