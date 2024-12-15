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

import cibertec.edu.pe.TechWare.entity.Categoria;
import cibertec.edu.pe.TechWare.service.CategoriaService;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
    private CategoriaService categoriaService;
	
	@GetMapping("/listar")
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", categoriaService.listarCategorias());
        return "categoria/listado";
    }
	
	@GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categoria/registro";
    }

    @PostMapping("/registro")
    public String registrarCategoria(@ModelAttribute Categoria categoria, RedirectAttributes redirectAttributes) {
        categoriaService.registrarCategoria(categoria);
        redirectAttributes.addFlashAttribute("mensaje", "Categoría registrada exitosamente.");
        return "redirect:/categorias/listar";
    }
    
    @GetMapping("/detalle/{id}") public String mostrarDetalleCategoria(@PathVariable("id") Long id, Model model) { 
    	Categoria categoria = categoriaService.buscarPorId(id); 
    	model.addAttribute("categoria", categoria); 
    	return "categoria/detalle"; 
    }
    
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarCategoria(@PathVariable("id") Long id, Model model) {
        Categoria categoria = categoriaService.buscarPorId(id);
        model.addAttribute("categoria", categoria);
        return "categoria/editar";
    }

    @PostMapping("/actualizar")
    public String actualizarCategoria(@ModelAttribute Categoria categoria,
                                       RedirectAttributes redirectAttributes) {
        categoriaService.actualizarCategoria(categoria);
        redirectAttributes.addFlashAttribute("mensaje", "Categoría actualizada exitosamente.");
        return "redirect:/categorias/listar";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarCategoria(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        categoriaService.eliminarCategoria(id);
        redirectAttributes.addFlashAttribute("mensaje", "Categoría eliminada exitosamente.");
        return "redirect:/categorias/listar";
    }
}
