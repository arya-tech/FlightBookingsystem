package com.skylift.fbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skylift.fbs.entites.PaymentInfo;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, String> {

}
