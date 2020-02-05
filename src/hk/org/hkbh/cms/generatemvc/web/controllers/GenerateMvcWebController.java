package hk.org.hkbh.cms.generatemvc.web.controllers;

import javax.validation.Valid;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.rabbitforever.generateJavaMVC.factories.PropertiesFactory;
import com.rabbitforever.generateJavaMVC.models.dtos.GenerateMvcWebDefaultHomeRequestDto;

@Controller
public class GenerateMvcWebController {
	private final Logger logger = LogManager.getLogger(getClassName());
	private PropertiesFactory propertiesFactory = null;
//	private PatientChargesProperties patientChargesProperties = null;
	private String getClassName() {
		return this.getClass().getName();
	}
	
	public GenerateMvcWebController() {
		try {
			init();
		} catch (Exception e) {
			logger.error(getClassName() + ".OutpatientWebController() ", e);
		}
	}
	private void init() throws Exception {
		propertiesFactory = PropertiesFactory.getInstanceOfPropertiesFactory();
//		patientChargesProperties = propertiesFactory.getInstanceOfPatientChargesProperties();
	}
	
	@GetMapping("/")
	public String read(@ModelAttribute("GenerateMvcWebDefaultHomeRequestDto") @Valid GenerateMvcWebDefaultHomeRequestDto requestDto, BindingResult result, Model model) {


		try {
//			propertiesFactory.getInstanceOfPatientChargesProperties();
			Boolean isDebug = true;

			model.addAttribute("patientChargesProperties", null);
		} catch (Exception e) {
			logger.error(getClassName() + ".read() - requestDto=" + requestDto, e);
		}
		return "landingPage";
	}
}
