package com.clickncash.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clickncash.entity.CourseTopics;
@Repository
public interface CourseTopicRepository extends JpaRepository<CourseTopics, Long>{

	List<CourseTopics> findByCourseId(Long courseId);

}
