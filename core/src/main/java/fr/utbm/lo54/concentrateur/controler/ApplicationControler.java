package fr.utbm.lo54.concentrateur.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/concentrateur")
public class ApplicationControler {
	
	@RequestMapping(method = RequestMethod.GET)
	public String showIndex(ModelMap model) {
		model.addAttribute("message", "Page index Concentrateur");
		return "affichage";
	}
}
