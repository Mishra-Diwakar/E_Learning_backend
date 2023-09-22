package com.clickncash.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.clickncash.entity.UserType;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Long>{

	@Transactional
	@Query(nativeQuery = true, value = "select * from user_type where type=?1")
	public List<UserType> findByType(String type);
}
