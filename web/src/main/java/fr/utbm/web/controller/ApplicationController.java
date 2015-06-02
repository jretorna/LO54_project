package fr.utbm.web.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import fr.utbm.core.entity.User;
import fr.utbm.core.ressource.Releve;
import fr.utbm.core.service.IReleveService;
import fr.utbm.core.service.IUserService;

@Controller
@RequestMapping("/concentrateur")
public class ApplicationController {
	
	private IUserService iUserService;
	private IReleveService releveService;
	
	public IUserService getUserService() {
		return iUserService;
	}
	
	@Autowired
	public void setUserService(IUserService iUserService) {
		this.iUserService = iUserService;
	}

	public IReleveService getReleveService() {
		return releveService;
	}
	
	@Autowired
	public void setReleveService(IReleveService releveService) {
		this.releveService = releveService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showIndex(ModelMap model) {
		model.addAttribute("message", "Page index Concentrateur");
		return "affichage";
	}
	
	@RequestMapping(value="releve", method = RequestMethod.GET)
	public String putReleve(ModelMap model) {
		return "releveTest";
	}
	
	
	@RequestMapping(value="adduser", method = RequestMethod.GET)
	public String addUser(ModelMap model) {
		
		User user = new User();
		
		user.setUserName("Neakapppcpra");
		user.setActive(true);

		System.out.println("deb add");

		iUserService.addUser(user);

		System.out.println("Add cools");
		
		model.addAttribute("message", "Ajout d'un utilisateur");
		return "affichage";
	}
	
	@RequestMapping(value="upreleve", method = RequestMethod.POST)
	public @ResponseBody String getReleve(@RequestParam("file") MultipartFile file, ModelMap model) {
		
		String fullReleveFileName = "Aucun fichier uploadé";
		
		if(!file.isEmpty()) {
			
			try {
				
				fullReleveFileName = releveService.saveFile(file.getBytes());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		Releve releve = releveService.jaxbGet(fullReleveFileName);
		
		model.addAttribute("message", "Uplaod : "+fullReleveFileName);
		
		releveService.registerReleve(releve);
		
		return "Uplaod : "+fullReleveFileName+" "+file.getContentType()+" Objet : "+releve;
	}
}
