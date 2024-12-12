package cibertec.edu.pe.TechWare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cibertec.edu.pe.TechWare.entity.Rol;
import cibertec.edu.pe.TechWare.entity.Usuario;
import cibertec.edu.pe.TechWare.service.RolService;
import cibertec.edu.pe.TechWare.service.UsuarioService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolService rolService;

    @GetMapping("")
    public String mostrarFormularioLogin() {
        return "login/login";
    }

    @PostMapping("/login")
    public String loginUsuario(@ModelAttribute Usuario usuario, Model model, HttpSession session) {
        if (usuarioService.validarUsuario(usuario, session)) {
            Usuario user = (Usuario) session.getAttribute("usuarioLogueado");
            if (user != null && "ADMIN".equalsIgnoreCase(user.getRol().getNombre())) {
                return "redirect:/usuarios/dashboard";
            } else if (user != null && "CLIENTE".equalsIgnoreCase(user.getRol().getNombre())) {
                return "redirect:/usuarios/home";
            } else {
                model.addAttribute("error", "Rol no reconocido. Contacte al administrador.");
                return "login/login";
            }
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login/login";
        }
    }

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("roles", rolService.listaRoles());
        return "login/registro";
    }

    @PostMapping("/registro")
    public String registrarUsuario(@ModelAttribute Usuario usuario) {
        Rol rolCliente = rolService.findByNombre("CLIENTE");
        usuario.setRol(rolCliente);
        usuarioService.registrarUsuario(usuario);
        return "redirect:/login";
    }
    
    @GetMapping("/logout")
    public String logoutUsuario(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

}
