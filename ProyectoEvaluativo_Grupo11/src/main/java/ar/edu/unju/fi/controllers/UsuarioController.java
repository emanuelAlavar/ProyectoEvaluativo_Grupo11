package ar.edu.unju.fi.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.models.Usuario;
import ar.edu.unju.fi.util.ListaUsuarios;

@Controller
@RequestMapping("/")
public class UsuarioController {
	private static final Log LOGGER = LogFactory.getLog(UsuarioController.class);
	ListaUsuarios listaUsuarios = new ListaUsuarios();
	
	
	
	@GetMapping("/usuario/nuevo")
	public String getNuevoUsuarioForm(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "nuevo_usuario";
	}
	
	@PostMapping("/usuario")
	public ModelAndView putCandidato(@ModelAttribute("usuario") Usuario usuario) {
		ModelAndView mav = new ModelAndView("usuarios");
		
		if(listaUsuarios.getUsuarios().add(usuario)) {
			LOGGER.info("Se registró un nuevo usuario");
		}
		mav.addObject("usuarios", listaUsuarios.getUsuarios());
		return mav;
	}
	
	@GetMapping("/usuario")
	public ModelAndView getCandidatos(Model model) {
		ModelAndView mav = new ModelAndView("lista_usuario");
		mav.addObject("usuarios", listaUsuarios.getUsuarios());
		return mav;
	}
}