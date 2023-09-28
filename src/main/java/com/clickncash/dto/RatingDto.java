package com.clickncash.dto;

import java.sql.Timestamp;
import java.util.List;

public interface RatingDto {
	String getName();
	String getDescription();
	Long getRate();
	Timestamp getDate();
}
