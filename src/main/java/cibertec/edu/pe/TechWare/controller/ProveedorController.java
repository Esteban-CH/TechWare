package cibertec.edu.pe.TechWare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cibertec.edu.pe.TechWare.entity.Proveedor;
import cibertec.edu.pe.TechWare.service.ProveedorService;

@Controller
@RequestMapping("/proveedores")
public class ProveedorController {

	@Autowired
	private ProveedorService proveedorService;

	@GetMapping("")
    public String listarProveedores(Model model) {
        model.addAttribute("proveedores", proveedorService.listarProveedores());
        return "proveedor/listado";
    }

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("proveedor", new Proveedor());
        return "proveedor/registro";
    }

    @PostMapping("/registro")
    public String registrarProveedor(@ModelAttribute Proveedor proveedor, RedirectAttributes redirectAttributes) {
        proveedorService.registrarProveedor(proveedor);
        redirectAttributes.addFlashAttribute("mensaje", "Proveedor registrado exitosamente.");
        return "redirect:/proveedores";
    }

    @GetMapping("/detalle/{id}") public String mostrarDetalleProveedor(@PathVariable("id") Long id, Model model) { 
    	Proveedor proveedor = proveedorService.buscarPorId(id); 
    	model.addAttribute("proveedor", proveedor); 
    	return "proveedor/detalle"; 
    }
    
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Long id, Model model) {
        Proveedor proveedor = proveedorService.buscarPorId(id);
        model.addAttribute("proveedor", proveedor);
        return "proveedor/editar";
    }

    @PostMapping("/actualizar")
    public String actualizarProveedor(@ModelAttribute Proveedor proveedor, RedirectAttributes redirectAttributes) {
        proveedorService.actualizarProveedor(proveedor);
        redirectAttributes.addFlashAttribute("mensaje", "Proveedor actualizado exitosamente.");
        return "redirect:/proveedores";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProveedor(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        proveedorService.eliminarProveedor(id);
        redirectAttributes.addFlashAttribute("mensaje", "Proveedor eliminado exitosamente.");
        return "redirect:/proveedores";
    }
}
