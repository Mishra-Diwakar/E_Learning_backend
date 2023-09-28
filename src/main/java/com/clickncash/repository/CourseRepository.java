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

//    @Query(nativeQuery = true, value = "select * from course where name like %?1% or header like %?1% ")
//	List<Course> searchCourse(String name);
    
    @Query(nativeQuery = true, value = "select c.id,c.name,c.header,c.banner,c.fee,concat(u.firstName,space(1),u.lastName) as teacher from (course c join user u on u.id=c.teacher) where c.name like %?1% or c.header like %?1%")
    List<CourseDto> searchCourse(String name);

    @Query(nativeQuery = true, value = "select course.id, course.startDate, course.name,course.banner, course.fee, concat(user.firstName,space(1), user.lastName)as teacher from course join user on user.id=course.teacher where course.startDate <= cast(Date(Now()) as Date)")
	List<CourseDto> findLiveCourses();

    @Query(nativeQuery = true, value = "select course.id, course.startDate, course.name,course.banner, course.fee, concat(user.firstName,space(1), user.lastName)as teacher from course join user on user.id=course.teacher where course.startDate > cast(Date(Now()) as Date);")
	List<CourseDto> findUpcomingCourses();

    @Query(nativeQuery = true, value = "select count(id) from course")
	Long countAllCourse();
    
}
