package com.isutc.interopitability.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isutc.interopitability.modelEnum.Result;
import com.isutc.interopitability.models.User;
import com.isutc.interopitability.services.InstitutionService;
import com.isutc.interopitability.services.UserService;

@Controller
public class InstitutionController {

	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/forwardRequest/{instCodReq}/{instCodResp}/{reqDoc}/{bi}")
	public String receiveRequest(@PathVariable("instCodReq") long instCodReq,
			@PathVariable("instCodResp") long instCodResp, @PathVariable("reqDoc") Result reqDoc,
			@PathVariable("bi") String bi) {
		String redirect = "redirect:";

		User user = userService.findStudentByInstitutionIdAndBi(instCodResp, bi);

		String infoName = "Aprovacao por Disciplina";
		String observation = "";
		String result = "";
		if (user != null) {
			if (user.getResult().equals(Result.POSITIVE)) {
				observation = "Nao se omitiu notas";
				result = Result.POSITIVE.name();
				// prepara tudo e envia ao web service
				redirect += "/responseRequest/{" + instCodReq + "}/" + "{" + instCodResp + "}/" + "{" + infoName + "}/"
						+ "{" + result + "}/" + "{" + observation + "}";
			} else {
				observation = "Nao encontrou se notas sobre este estudante";
				result = Result.NEGATIVE.name();
				redirect += "/responseRequest/{" + instCodReq + "}/" + "{" + instCodResp + "}/" + "{" + infoName + "}/"
						+ "{" + result + "}/" + "{" + observation + "}";

			}

		}

		return redirect;
	}

}
