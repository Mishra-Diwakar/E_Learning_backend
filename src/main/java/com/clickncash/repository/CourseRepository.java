package com.clickncash.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.clickncash.dto.CourseDto;
import com.clickncash.dto.PurchasedDto;
import com.clickncash.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
//	@Query(nativeQuery = true, value = "select id,name from course")
//	Map<String, Object> findList();

    @Query(nativeQuery = true, value = "SELECT c.id, c.name FROM Course c")
	List<CourseDto> findList();
    
    @Query(nativeQuery = true, value = "select count(id) as total from course")
    Long countCourse();
    
    @Query(nativeQuery = true, value = "select course.id,course.name,course.banner,purchasedcourse.enrolledAt as createdAt,purchasedcourse.validTill from course join purchasedcourse on course.id = purchasedcourse.courseId and purchasedcourse.userId=?1")
	List<PurchasedDto> findPurchasedCourseByUserId(long userId);
    
}
