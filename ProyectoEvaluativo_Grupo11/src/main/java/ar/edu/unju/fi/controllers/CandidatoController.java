package ar.edu.unju.fi.controllers;

import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.models.Candidato;
import ar.edu.unju.fi.util.ListaCandidatos;


@Controller
@RequestMapping("/")
public class CandidatoController {
	private static final Log LOGGER = LogFactory.getLog(CandidatoController.class);
	ListaCandidatos listaCandidatos = new ListaCandidatos();
	
	@GetMapping("/candidato")
	public ModelAndView getCandidatos(Model model) {
		ModelAndView mav = new ModelAndView("lista_candidatos");
		mav.addObject("candidato", listaCandidatos.getCandidatos());
		return mav;
	}
	
	@GetMapping("/candidato/nuevo")
	public String getNuevoCandidatoForm(Model model) {
		model.addAttribute("candidato", new Candidato());
		return "nuevo_candidato";
	}
	
	@PostMapping("/candidato")
	public ModelAndView putCandidato(@ModelAttribute("candidato") Candidato candidato) {
		ModelAndView mav = new ModelAndView("lista_candidatos");
		
		if(listaCandidatos.getCandidatos().add(candidato)) {
			LOGGER.info("Se registró un nuevo candidato");
		}
		mav.addObject("candidatos", listaCandidatos.getCandidatos());
		return mav;
	}
	
	public List<Candidato> getCandidatos(){
		List<Candidato> listaCandidatos = new ArrayList<>();
		listaCandidatos.add(new Candidato(10,"Pablo Lescano","Masculino","Es un cantante y músico argentino, líder del grupo Damas Gratis"));
		listaCandidatos.add(new Candidato(9,"Maluma","Masculino","Es un actor y cantante colombiano de pop, reguetón y trap latino"));
		listaCandidatos.add(new Candidato(8,"Tini","Femenino","Es una actriz, cantante y compositora argentina"));
		return listaCandidatos;
	}
	

	@PostMapping("/viewCandidatos")
	public String visualizarPaginaCandidatos(Model model) {	
    	model.addAttribute("candidatos",this.getCandidatos());
    	LOGGER.info("REQUEST: /viewCandidatos - METHOD: visualizarPaginaCandidatos() - INFO: Se agregan al contexto de la aplicación la colección de posts");
    	for(Candidato c:this.getCandidatos()) {
    		LOGGER.info(c.toString());
    	}
    	LOGGER.info("REQUEST: /viewPosts - METHOD: visualizarPaginaPosts() - INFO: Se solicita la página post.html");
    	return "candidatos";
	}
}
