package com.isutc.interopitability.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isutc.interopitability.models.WebServiceHistory;

public interface LogRepository extends JpaRepository<WebServiceHistory, Long> {

}
