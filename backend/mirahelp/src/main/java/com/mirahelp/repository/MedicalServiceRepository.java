package com.mirahelp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mirahelp.domain.MedicalService;

public interface MedicalServiceRepository extends JpaRepository<MedicalService, String>{

}
