package com.isutc.interopitability.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.isutc.interopitability.beans.Response;
import com.isutc.interopitability.modelEnum.Status;
import com.isutc.interopitability.models.Institution;
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

		// test purpose

		Institution institution= new Institution();
      institution.setName("Up");
       System.err.println(insService.save(institution));
		return new ResponseEntity<>(insService.findAll(), HttpStatus.ACCEPTED);
	}

	@PostMapping("requestInfo")
	public  String requestInfo(@RequestParam("name") String name, @RequestParam("bi") String bi,
			@RequestParam("instCod") String instCod, @RequestParam("reqDoc") String reqDoc) {
		String redirect = "redirect:/";
		long instCodReq = 1;
		long instCodResp = 1;
		WebServiceHistory log = new WebServiceHistory(instCodReq, instCodResp, Status.Sending, reqDoc);
		boolean isSavedLog = logService.save(log);
System.err.println(isSavedLog);
		redirect += "forwardRequest/{" + instCodReq + "}/{" + instCodResp + "}/{" + reqDoc + "}/{" + bi+"}";

		return redirect;
	}

	
	@RequestMapping(value= "/responseRequest/{instCodReq}/{instCodResp}/{infoName}/{result}/{observation}")
	public @ResponseBody ResponseEntity<?> responseInfo(@PathVariable("instCodReq") long instCodReq, 
			@PathVariable("instCodResp") long instCodResp, @PathVariable("infoName") String infoName, @PathVariable("result") String result, @PathVariable("observation") String observation ){
		
		
		Response response = new Response() ;
		
		response.setCodInstReq(insService.findById(instCodReq).getName());
		response.setCodInstResp(insService.findById(instCodResp).getName());
		response.setObs(observation);
		response.setResult(result);
		response.setInfoName(infoName);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	

}
