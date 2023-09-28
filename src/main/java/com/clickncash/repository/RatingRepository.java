package com.clickncash.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.clickncash.dto.RatingDto;
import com.clickncash.entity.Ratings;
@Repository
public interface RatingRepository extends JpaRepository<Ratings, Long>{

	@Query(nativeQuery = true, value = "select sum(rate) as totalRating, count(id) as total from ratings where courseId=?1 ")
	Map<String, Object> countRating(Long courseId);
	
//	@Query(nativeQuery = true, value = "select * from ratings where courseId=?1 order by id desc limit 10")
//	List<Ratings> findLatestRatings(Long courseId);
	
	@Query(nativeQuery = true, value = "select user.firstName as name, ratings.rate, ratings.description from user join ratings on ratings.userId=user.id where ratings.courseId=?1 order by ratings.id desc limit 5")
	List<RatingDto> findLatedRatingDetails(Long courseId);

	Ratings findByUserIdAndCourseId(Long userId, Long courseId);
	
	@Query(nativeQuery = true, value = "select sum(rate)/count(id) as rate from ratings where courseId=?1")
	Long countByCourseId(Long courseId);

	@Query(nativeQuery = true, value = "select ratings.description, ratings.rate, ratings.createdAt as date, concat(user.firstName,space(1),user.lastName) as name from ratings join user on ratings.userId=user.id order by ratings.id desc limit 5")
	List<RatingDto> getRecentRating();

}
