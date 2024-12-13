package cibertec.edu.pe.TechWare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cibertec.edu.pe.TechWare.entity.Producto;
import cibertec.edu.pe.TechWare.service.CategoriaService;
import cibertec.edu.pe.TechWare.service.ProductoService;
import cibertec.edu.pe.TechWare.service.ProveedorService;

@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private ProveedorService proveedorService;
	
	@GetMapping("/listar")
	public String verFormularioProductos(Model model) {
		model.addAttribute("productos", productoService.listarProductos());
		model.addAttribute("categoria", categoriaService.listarCategorias());
		model.addAttribute("proveedor", proveedorService.listarProveedores());
		return "producto/listado";
	}
	
	@GetMapping("/registro")
    public String mostrarFormularioNuevoProducto(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("categorias", categoriaService.listarCategorias());
        model.addAttribute("proveedores", proveedorService.listarProveedores());
        return "producto/registro";
    }

    @PostMapping("/registro")
    public String registrarProducto(@ModelAttribute Producto producto, RedirectAttributes redirectAttributes, @RequestParam("file") MultipartFile file) {
        productoService.registrarProducto(producto, file);
        redirectAttributes.addFlashAttribute("mensaje", "Producto registrado exitosamente.");
        return "redirect:/productos/listar";
    }
    
    @GetMapping("/detalle/{id}") public String verDetalleProducto(@PathVariable("id") Long id, Model model) { 
    	Producto producto = productoService.buscarPorId(id); 
    	model.addAttribute("producto", producto); 
    	return "producto/detalle"; 
    }
    
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarProducto(@PathVariable("id") Long id, Model model) {
        Producto producto = productoService.buscarPorId(id);
        model.addAttribute("producto", producto);
        model.addAttribute("categorias", categoriaService.listarCategorias());
        model.addAttribute("proveedores", proveedorService.listarProveedores());
        return "producto/editar";
    }

    @PostMapping("/actualizar")
    public String actualizarProducto(@ModelAttribute Producto producto,
                                     @RequestParam("file") MultipartFile file,
                                     RedirectAttributes redirectAttributes) {
        productoService.actualizarProducto(producto, file);
        redirectAttributes.addFlashAttribute("mensaje", "Producto actualizado exitosamente.");
        return "redirect:/productos/listar";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        productoService.eliminarProducto(id);
        redirectAttributes.addFlashAttribute("mensaje", "Producto eliminado exitosamente.");
        return "redirect:/productos/listar";
    }
}
