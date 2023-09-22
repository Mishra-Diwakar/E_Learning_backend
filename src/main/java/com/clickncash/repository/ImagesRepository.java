package com.clickncash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clickncash.entity.Images;

@Repository
public interface ImagesRepository extends JpaRepository<Images, Long>{

}
