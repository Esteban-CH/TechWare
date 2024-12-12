package cibertec.edu.pe.TechWare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cibertec.edu.pe.TechWare.entity.Usuario;
import cibertec.edu.pe.TechWare.service.UsuarioService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/usuarios")
public class HomeController {
	
	@Autowired
    private UsuarioService usuarioService;

	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
	    Usuario usuarioLogueado = (Usuario) session.getAttribute("usuarioLogueado");
	    
	    if (usuarioLogueado != null) {
	        String nombreCompleto = usuarioLogueado.getNombre() + " " + usuarioLogueado.getApellido();
	        model.addAttribute("nombreCompleto", nombreCompleto); // Pasa el nombre completo
	    }
	    
	    return "usuario/dashboard";
	}
	
	@GetMapping("/home")
    public String home() {
        return "usuario/home";
    }
}