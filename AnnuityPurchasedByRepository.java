package com.lic.epgs.mst.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lic.epgs.mst.entity.AddressType;
import com.lic.epgs.mst.entity.AnnuityPurchasedBy;

@Repository
public interface AnnuityPurchasedByRepository extends JpaRepository<AnnuityPurchasedBy, Long> {
	
	@Query("SELECT DISTINCT a FROM AnnuityPurchasedBy a WHERE a.annuityCode = :code")
	public Optional<AnnuityPurchasedBy> findByCode(String code);
	
	@Query("SELECT DISTINCT a FROM AnnuityPurchasedBy a WHERE a.annuityCode = :code AND a.name = :name")
	public Optional<AnnuityPurchasedBy> findByCodeAndName(String code, String name);
	
	@Query("SELECT DISTINCT a FROM AnnuityPurchasedBy a WHERE a.name = :name")
	public Optional<AnnuityPurchasedBy> findByName(String name);
}