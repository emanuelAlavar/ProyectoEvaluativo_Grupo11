package ar.edu.unju.fi.controllers;

import org.apache.commons.logging.LogFactory;


import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.models.Candidato;
import ar.edu.unju.fi.service.ICandidatoService;
import ar.edu.unju.fi.util.ListaCandidatos;


@Controller
@RequestMapping("/")
public class CandidatoController {
	@Autowired
	@Qualifier("CandidatoServiceImpList")
	private ICandidatoService candidatoService;
	
	private static final Log LOGGER = LogFactory.getLog(CandidatoController.class);
	//ListaCandidatos listaCandidatos = new ListaCandidatos();
	
	@GetMapping("/candidato")
	public ModelAndView getCandidatosPage(@ModelAttribute("candidato") Candidato candidato) {
		ModelAndView mav = new ModelAndView("lista_candidatos");
		mav.addObject("candidatos", candidatoService.getListaCandidato().getCandidatos());
		return mav;
	}
	
	//Este metodo agrega un nuevo candidato a la lista
	@GetMapping("/candidato/nuevo")
	public String getNuevoCandidatoForm(Model model) {
		model.addAttribute("candidato", candidatoService.getCandidato());
		return "nuevo_candidato";
	}
	
	
	
	@PostMapping("/candidato")
	public ModelAndView putCandidato(@ModelAttribute("candidato") Candidato candidato) {
		ModelAndView mav = new ModelAndView("lista_candidatos");
		
		if(candidatoService.guardarCandidato(candidato)) {
			LOGGER.info("Se registró un nuevo candidato");
		}
		mav.addObject("candidatos", candidatoService.getListaCandidato().getCandidatos());
		return mav;
	}
	
	@GetMapping("/")
	public String visualizarPaginaCandidatos(Model model) {	
    	model.addAttribute("candidatos",candidatoService.getListaCandidato().getCandidatos());
    	LOGGER.info("REQUEST: /viewCandidatos - METHOD: visualizarPaginaCandidatos() - INFO: Se agregan al contexto de la aplicación la colección de posts");
    	for(Candidato c:candidatoService.getListaCandidato().getCandidatos()) {
    		LOGGER.info(c.toString());
    	}
    	LOGGER.info("REQUEST: /viewPosts - METHOD: visualizarPaginaPosts() - INFO: Se solicita la página post.html");
    	return "index";
	}
	
	@GetMapping("/votos")
	public String updateVotos(@RequestParam(value="codigo") int codigo) {
		ModelAndView mav = new ModelAndView("lista_usuarios");
		for(Candidato c:candidatoService.getListaCandidato().getCandidatos()) {
			if(c.getCodigo() == codigo) {
				c.updateVotos();
				LOGGER.info("Se ha actualizado el conteo de votos");
			}
		}
		mav.addObject("candidatos", candidatoService.getListaCandidato().getCandidatos());
		return "votacionConfirmada";
	}
	
	@GetMapping("/candidato/editar/{codigo}")
	public ModelAndView getEditarCandidatoPage(@PathVariable(value="codigo") int codigo) {
		if(codigo == 0) {
			ModelAndView mav= new ModelAndView("redirect:/candidato");
			return mav;
		}
		ModelAndView mav= new ModelAndView("edicion_candidato");
		Candidato candidato= candidatoService.buscarCandidato(codigo);
		mav.addObject("candidato", candidato);
		return mav;
	}
	
	@PostMapping("/candidato/modificar")
	public ModelAndView editarDatosCandidato(@ModelAttribute("candidato") Candidato candidato , BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("ocurrio un error"+candidato);
			ModelAndView mav= new ModelAndView("edicion_candidato");
			mav.addObject("candidato",candidato);
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/candidato");
		candidatoService.modificarCandidato(candidato);
		LOGGER.info("Se ha modificado el candidato ID: "+candidato.getCodigo());
		return mav;
	}
	
	@GetMapping("/candidato/eliminar/{codigo}")
	public ModelAndView eliminarCandidato(@PathVariable("codigo") int codigo) {
		ModelAndView mav = new ModelAndView("redirect:/candidato");
		if(codigo!=0) {
			candidatoService.eliminarCandidato(codigo);
			LOGGER.info("Se elimino el candidato ID: "+codigo);
		}
		return mav;
	}
	
}
