package com.clickncash.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clickncash.entity.CourseFeature;
import com.clickncash.entity.CourseTopics;

@Repository
public interface CourseFeatureRepository extends JpaRepository<CourseFeature, Long>{

	List<CourseFeature> findByCourseId(Long courseId);

}
