package com.clickncash.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clickncash.dto.TotalDto;
import com.clickncash.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
//	@Query(nativeQuery = true, value = "SELECT u.* FROM User u where id = :userName")
//	Optional<User> getUserByUserName(@Param("userName") Long userName);
	
	@Query(nativeQuery = true, value = "SELECT u.* FROM User u where email = :userName")
	Optional<User> getUserByUserName(@Param("userName") String userName);
	
	@Query(nativeQuery = true, value = "SELECT * FROM user where email =?1")
	Optional<User> getUserByEmail(String email);

	@Query(nativeQuery = true, value = "SELECT u.* FROM User u where username = :userName")
	Optional<User> getUserByUserName2(@Param("userName") String userName);
	
	@Query(nativeQuery = true, value = "SELECT * FROM user where email =?1")
	Optional<User> getUserByEmail2(String email);
	
	@Modifying
	@Query(nativeQuery = true, value = "UPDATE User u SET u.profile=?1 WHERE u.email=?2 AND u.username=?3 AND u.id=?4")
	public void updateUserProfile(String profile,String email,String username, long id);
	
	@Query(nativeQuery = true, value = "SELECT * from user where email=?1 and id=?2")
	public List<User> getProfilePic(String email,long id);
	
	
	User findByEmail(String email);
	
	@Query(nativeQuery = true, value = "SELECT * from user where aadhar=?1 or email=?2 or mobile=?3 or username=?4")
	List<User> isExist(String aadhar, String email, String mobile, String username);

	@Query(nativeQuery = true, value = "SELECT * from user where username=?1")
	List<User> findByUsername(String username);

	@Query(nativeQuery = true, value = "SELECT * from user where aadhar=?1")
	List<User> findByAadhar(String aadharId);
	
	@Query(nativeQuery = true, value = "SELECT * from user where email=?1")
	List<User> findByEmailList(String email);
	
	@Query(nativeQuery = true, value = "SELECT * from user where mobile=?1")
	List<User> findByMobile(String mobile);
	
	@Query(nativeQuery = true, value = "SELECT * from user where username=?1 and id !=?2")
	List<User> findByUsername2(String username, Long id);

	@Query(nativeQuery = true, value = "SELECT * from user where aadhar=?1 and id !=?2")
	List<User> findByAadhar2(String aadharId, Long id);
	
	@Query(nativeQuery = true, value = "SELECT * from user where email=?1 and id !=?2")
	List<User> findByEmailList2(String email, Long id);
	
	@Query(nativeQuery = true, value = "SELECT * from user where mobile=?1 and id !=?2")
	List<User> findByMobile2(String mobile, Long id);

	@Query(nativeQuery = true, value = "SELECT * from user where id !=?5 and (username=?1 or aadhar=?2 or email=?3 or mobile=?4)")
	List<User> isExist2(String username, String aadharId, String email, String mobile, Long userId);

	@Query(nativeQuery = true, value = "SELECT * from user where userType=?1 order by id desc")
	Page<User> getAllUsers(Long userType,Pageable p);

	@Query(nativeQuery = true, value = "SELECT * from user where email=?1 or mobile=?1 or username=?1")
	List<User> searchUser(String email);
	
	@Query(nativeQuery = true, value = "select count(id) as total from user where userType=?1")
	Long countEmployee(Long userType);
	
	@Query(nativeQuery = true, value = "select count(id) as total from user where userType=?1 and month(createdAt)= month(now()) and year(createdAt)=year(now())")
	Long countNewStudent(Long userType);

	@Query(nativeQuery = true, value = "select count(id) as total from user where userType=?1 and status=true")
	Long countAvlTeacher(Long userType);
	
	@Query(nativeQuery = true, value = "select * from user where userType=?1 order by id desc limit 10")
	List<User> getRecentStudents(Long userType);
	
	@Query(nativeQuery = true, value = "select * from user where userType=?1 limit 10")
	List<User> getProfessorsList(Long userType);

	List<User> findAllUserByUserType(long l);
	
	@Query(nativeQuery = true, value = "select \r\n"
			+ "	count(CASE WHEN (userType=4) THEN \"1\" END) as totalStudent,\r\n"
			+ " count(CASE WHEN (userType=3) THEN \"1\" END) as totalTeacher\r\n"
			+ "FROM user")
	TotalDto totalStudentAndTeacher();
}