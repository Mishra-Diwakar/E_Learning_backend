package com.clickncash.dto;

import java.sql.Timestamp;

public interface PurchasedDto {
	Long getId();
	String getName();
	String getBanner();
	Timestamp getCreatedAt();
	Timestamp getValidTill();
}
