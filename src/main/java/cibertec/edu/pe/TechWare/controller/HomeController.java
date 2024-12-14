package cibertec.edu.pe.TechWare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cibertec.edu.pe.TechWare.entity.Usuario;
import cibertec.edu.pe.TechWare.service.CategoriaService;
import cibertec.edu.pe.TechWare.service.ProductoService;
import cibertec.edu.pe.TechWare.service.ProveedorService;
import cibertec.edu.pe.TechWare.service.UsuarioService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/usuarios")
public class HomeController {
	
	@Autowired
    private UsuarioService usuarioService;
	
	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private ProveedorService proveedorService;
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
	    Usuario usuarioLogueado = (Usuario) session.getAttribute("usuarioLogueado");
	    
	    if (usuarioLogueado != null) {
	        String nombreCompleto = usuarioLogueado.getNombre() + " " + usuarioLogueado.getApellido();
	        model.addAttribute("nombreCompleto", nombreCompleto);
	    }
	    
	    // Añadir las cantidades al modelo (supongamos que tienes servicios para obtener estas cantidades)
	    int cantidadUsuarios = usuarioService.contarUsuarios();
	    int cantidadCategorias = categoriaService.contarCategorias();
	    int cantidadProveedores = proveedorService.contarProveedores();
	    int cantidadProductos = productoService.contarProductos();
	    
	    model.addAttribute("cantidadUsuarios", cantidadUsuarios);
	    model.addAttribute("cantidadCategorias", cantidadCategorias);
	    model.addAttribute("cantidadProveedores", cantidadProveedores);
	    model.addAttribute("cantidadProductos", cantidadProductos);
	    
	    return "usuario/dashboard";
	}

	
	@GetMapping("/home")
    public String home() {
        return "usuario/home";
    }
	
	@GetMapping("/contacto")
	public String contacto() {
		return "contacto/contacto";
	}
	
	
}