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
import fr.utbm.core.ressource.ReleveParameter;
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
	
	/**
	 * Paramétrage du concentrateur
	 * @param model
	 * @return
	 */
	
	@RequestMapping(value="param", method = RequestMethod.POST)
	public String setParam(@RequestParam("pr_tc_min") String pr_tc_min, 
							@RequestParam("pr_tc_max") String pr_tc_max, ModelMap model) {
		
		ReleveParameter param = new ReleveParameter();
		
		param.setTempMin(Integer.parseInt(pr_tc_min));
		param.setTempMax(Integer.parseInt(pr_tc_max));
		
		releveService.jaxbSerialiseParam(param) ;
		
		return "index";
	}
	
	@RequestMapping(value="filter", method = RequestMethod.POST)
	public String showLastRelevesByFiltering(@RequestParam("flt_tc_min") Float flt_tc_min, 
												@RequestParam("flt_tc_max") Float flt_tc_max,
												@RequestParam("flt_date_deb") String flt_date_deb, 
												@RequestParam("flt_date_fin") String flt_date_fin, 
												@RequestParam("flt_station") String flt_station, 
												@RequestParam("flt_area") String flt_area,
												@RequestParam("flt_capteur") String flt_capteur,ModelMap model) {
		
		List<ReleveQueryResult> releves = releveService.listReleveByFilter(flt_tc_min, flt_tc_max, 
																			flt_date_deb, flt_date_fin, 
																			flt_station, flt_area, 
																			flt_capteur); 
		
		model.addAttribute("message", "Liste des températures collectées Filtrered");
		model.addAttribute("view", 1);
		model.addAttribute("releves", releves);
		
		return "affichage";
	}
	
	
	@RequestMapping(value="lastreleves", method = RequestMethod.GET)
	public String showLastReleves(ModelMap model) {
		
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
