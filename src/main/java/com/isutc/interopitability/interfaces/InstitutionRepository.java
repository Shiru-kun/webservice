package com.isutc.interopitability.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isutc.interopitability.models.Institution;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {

}
