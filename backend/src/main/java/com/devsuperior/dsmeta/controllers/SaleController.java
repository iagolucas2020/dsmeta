package com.devsuperior.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.Services.SaleServices;
import com.devsuperior.dsmeta.Services.SmsService;
import com.devsuperior.dsmeta.entities.Sale;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleServices Services;
	
	private SmsService smsService;
	
	@GetMapping
	public Page<Sale> findSales(
			@RequestParam(value="minDate", defaultValue = "") String minDate,
			@RequestParam(value="maxDate", defaultValue = "")String maxDate,
			Pageable pageable){
		return Services.findSales(minDate, maxDate, pageable);
	}
	
	@GetMapping("/notification")
	public void notifySms() {
		smsService.sendSms();
	}

}
