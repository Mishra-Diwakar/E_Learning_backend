package com.clickncash.repository;
import java.util.HashMap;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clickncash.entity.PaymentDetails;

public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails, Long>{

	@Query(nativeQuery = true, value = "select sum(amount) from payment")
	String findSumOfPayment();
	
	@Query(nativeQuery = true, value = "SELECT * from payment order by id desc")
	Page<PaymentDetails> getAllPayments(Pageable pageable);

	List<PaymentDetails> findByPaymentId(String paymentId);

}
