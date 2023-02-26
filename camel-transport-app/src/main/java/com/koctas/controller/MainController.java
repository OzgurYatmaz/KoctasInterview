package com.koctas.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koctas.dto.CamelTransportResponse;
import com.koctas.dto.CamelTransportRequest;
import com.koctas.service.CamelTransportService;

@RestController
@RequestMapping("/api/v1")
public class MainController {

	 private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);


	@Autowired
	private CamelTransportService camelTransportService;
	
	
	@PostMapping("/getTransportedApples")
	public ResponseEntity<CamelTransportResponse> calculate(@RequestBody CamelTransportRequest request){
		LOGGER.info(request.toString());
		CamelTransportResponse response=new CamelTransportResponse();
		
		try {
			int tasinabilirElmaSayisi = camelTransportService.calculateMaxTransportedApples(request.getElmaSayisi(), request.getMesafe());
			response.setTasinabilirElmaSayisi(tasinabilirElmaSayisi);
			response.setStatus("Success");
			LOGGER.info(response.toString());
			return ResponseEntity.ok(response);
		} catch (Exception  e ) {
			response.setStatus(e.getMessage());
			LOGGER.error(response.toString());
			return ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body(response);
			  
		}
		
	}
	
}
