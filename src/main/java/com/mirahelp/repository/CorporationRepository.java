package com.mirahelp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mirahelp.domain.Corporation;

@Repository
public interface CorporationRepository extends JpaRepository<Corporation, String> {

}
