package com.lic.epgs.mst.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lic.epgs.mst.controller.AnnuityPurchasedByController;
import com.lic.epgs.mst.entity.AnnuityPurchasedBy;
import com.lic.epgs.mst.exceptionhandling.LoggingUtil;
import com.lic.epgs.mst.exceptionhandling.ResourceNotFoundException;
import com.lic.epgs.mst.repository.AnnuityPurchasedByRepository;

@Service
@Transactional
public class AnnuityPurchasedByServiceImpl implements AnnuityPurchasedByService {

	@Autowired
	private AnnuityPurchasedByRepository annuityPurchasedByRepository;

	String className = this.getClass().getSimpleName();
	private static final Logger logger = LoggerFactory.getLogger(AnnuityPurchasedByController.class);

	@Override
	public List<AnnuityPurchasedBy> getAllAnnuityPurchasedBy() {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		logger.info("i get AnnuityPurchasedBy list ");
		LoggingUtil.logInfo(className, methodName, "Started");

		return annuityPurchasedByRepository.findAll();
	}

	@Override
	public AnnuityPurchasedBy getAnnuityPurchasedByById(long id) {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		Optional<AnnuityPurchasedBy> annuitypurchasedbyDb = this.annuityPurchasedByRepository.findById(id);
		LoggingUtil.logInfo(className, methodName, "Started");
		LoggingUtil.logInfo(className, methodName, "Search for AnnuityPurchasedBy By Id: " + id);
		if (annuitypurchasedbyDb.isPresent()) {
			logger.info("AnnuityPurchasedBy is found with id: " + id);
			return annuitypurchasedbyDb.get();
		} else {
			throw new ResourceNotFoundException("AnnuityPurchasedBy not found with id: " + id);
		}
	}

	@Override
	public AnnuityPurchasedBy findByCode(String code, String name) {
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		Optional<AnnuityPurchasedBy> annuitypurchasedbyDb = this.annuityPurchasedByRepository.findByCodeAndName(code, name);
		LoggingUtil.logInfo(className, methodName, "Started");
		LoggingUtil.logInfo(className, methodName, "Search for AnnuityPurchasedBy By code: " + code + " and name: " + name);
		if (annuitypurchasedbyDb.isPresent()) {
			logger.info("AnnuityPurchasedBy is found with code: " + code + " and name: " + name);
			return annuitypurchasedbyDb.get();
		} else {
			throw new ResourceNotFoundException("AnnuityPurchasedBy not found with code: " + code + " and name: " + name);
		}
	}

}