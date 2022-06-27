package pe.proyecto.zonamangas.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pe.proyecto.zonamangas.modelo.Manga;
import pe.proyecto.zonamangas.servicio.MangaServicio;

@Controller
public class MangaControlador {
	
	@Autowired
	private  MangaServicio mangaService;
	
	@GetMapping("/login")
	public String iniciarSesion() {
		return "login";
	}

	@RequestMapping("/")
	public String verPaginaDeInicio(Model modelo) {
		return "index";
	}
	
	@RequestMapping("/crud")
	public String verCrud(Model modelo,@Param("nombre") String nombre) {
		List<Manga> listaMangas = mangaService.listAll(nombre);
		
		modelo.addAttribute("listaMangas", listaMangas);	
		modelo.addAttribute("nombre",nombre);
		return "crud";
	}
	
	@RequestMapping("/nuevo")
	public String mostrarRegistrarManga(Model modelo) {
		Manga manga = new Manga();
		modelo.addAttribute("manga", manga);
		return "nuevo_manga";
	}
	
	@RequestMapping(value = "/guardar",method = RequestMethod.POST)
	public String guardarManga(@ModelAttribute("manga") Manga manga) {
		mangaService.save(manga);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/guardarCrud",method = RequestMethod.POST)
	public String guardarMangaCrud(@ModelAttribute("manga") Manga manga) {
		mangaService.save(manga);
		return "redirect:/crud";
	}

	@RequestMapping("/crud/editar/{id}")
	public ModelAndView mostrarFormularioDeEditarManga(@PathVariable(name="id")Long id){
	    ModelAndView modelo = new ModelAndView("editar");
	    Manga manga = mangaService.get(id);
	    modelo.addObject("manga",manga);
	    return modelo;
	}
	
	@RequestMapping("/crud/mostrar/{id}")
	public ModelAndView mostrarDetalleManga(@PathVariable(name="id")Long id){
	    ModelAndView modelo = new ModelAndView("mostrar");
	    Manga manga = mangaService.get(id);
	    modelo.addObject("manga",manga);
	    return modelo;
	}
	
	
	@RequestMapping("/crud/eliminar/{id}")
	public String eliminarProductoCrud(@PathVariable(name="id") Long id) {
		mangaService.delete(id);
		return "redirect:/crud";
	}
	                                                                  
}
