package com.clickncash.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.clickncash.dto.CourseDto;
import com.clickncash.entity.Videos;

@Repository
public interface VideosRepository extends JpaRepository<Videos, Long>{

	@Query(nativeQuery = true, value = "SELECT distinct course.id, course.name\r\n"
			+ "FROM course\r\n"
			+ "INNER JOIN videos ON course.id=videos.playList")
	List<CourseDto> findAllPlayList();

	List<Videos> findAllByPlayList(Long playList);

}
