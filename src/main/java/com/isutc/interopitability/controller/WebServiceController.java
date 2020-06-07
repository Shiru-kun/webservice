package com.isutc.interopitability.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.isutc.interopitability.modelEnum.Status;
import com.isutc.interopitability.models.WebServiceHistory;
import com.isutc.interopitability.services.InstitutionService;
import com.isutc.interopitability.services.LogService;

@RestController
public class WebServiceController {
//
	@Autowired
	private InstitutionService insService;

	@Autowired
	private LogService logService;
	@GetMapping("/institution")
	public @ResponseBody ResponseEntity<?> getInstitutionList() {

		return new ResponseEntity<>(insService.findAll(), HttpStatus.ACCEPTED);
	}

	@PostMapping("requestInfo")
	public @ResponseBody ResponseEntity<?> requestInfo(@RequestParam("name") String name, @RequestParam("bi") String bi,
			@RequestParam("instCod") String instCod, @RequestParam("reqDoc") String reqDoc) {

		long loggedId  = 1; 
		long RequestedId  = 1; 
		WebServiceHistory log = new WebServiceHistory(loggedId, RequestedId, Status.Sending, reqDoc);
		 boolean isSavedLog = logService.save(log); 
		
		
		return new ResponseEntity<>(isSavedLog, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("responseInfo")
	public @ResponseBody ResponseEntity<?> response(@RequestParam("name") String name, @RequestParam("bi") String bi,
			@RequestParam("instCod") String instCod, @RequestParam("reqDoc") String reqDoc) {

		long loggedId  = 1; 
		long RequestedId  = 1; 
		WebServiceHistory log = new WebServiceHistory(loggedId, RequestedId, Status.Sending, reqDoc);
		 boolean isSavedLog = logService.save(log); 
		
		
		return new ResponseEntity<>(isSavedLog, HttpStatus.ACCEPTED);
	}
//	
//	
//	@RequestMapping
//	public @ResponseBody ResponseEntity<?> answerInfoRequest(){
//		
//		return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
//	} 
//	
//	//methodToForwardRequest 
//	
//	
}
