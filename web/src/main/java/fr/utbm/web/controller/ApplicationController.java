package fr.utbm.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import fr.utbm.core.ressource.Releve;
import fr.utbm.core.ressource.ReleveQueryResult;
import fr.utbm.core.service.IReleveService;
import fr.utbm.core.service.IUserService;

@Controller
@RequestMapping("/concentrateur")
public class ApplicationController {
	
	private IUserService userService;
	private IReleveService releveService;
	
	public IUserService getUserService() {
		return userService;
	}
	
	@Autowired
	public void setUserService(IUserService iUserService) {
		this.userService = iUserService;
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
	
	
	@RequestMapping(value="lastreleves", method = RequestMethod.GET)
	public String addUser(ModelMap model) {
		
		/*User user = new User();
		
		user.setUserName("Neakapppcpra");
		user.setActive(true);

		System.out.println("deb add");

		userService.addUser(user);

		System.out.println("Add cools");*/
		
		List<ReleveQueryResult> releves = releveService.listReleve(); 
		
		model.addAttribute("message", "Liste des températures collectées");
		model.addAttribute("view", 1);
		model.addAttribute("releves", releves);
		
		return "affichage";
	}
	
	@RequestMapping(value="badreleves", method = RequestMethod.GET)
	public String listOutReleves(ModelMap model) {
		
		
		
		List<Releve> releves = new ArrayList<Releve>();
		
		String rootPath = System.getProperty("catalina.home");
		
		File dir = new File(rootPath+File.separator+"relevesOut");
		
		String ext;
	
		
		if ( dir.isDirectory ( ) ) {
			File[] files = dir.listFiles();
			
			for(int i=0; i<files.length; i++) {
				ext = files[i].getAbsolutePath().substring(files[i].getAbsolutePath().lastIndexOf("."));
				model.addAttribute("message", "Liste des releves out "+ext);
				if(ext.equals(".xml"))
					releves.add(releveService.jaxbGet(files[i].getAbsolutePath()));
			}
			
		}
		
		
		//model.addAttribute("message", "Liste des releves out "+releves.size());
		model.addAttribute("view", 2);
		model.addAttribute("releves", releves);
		
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
