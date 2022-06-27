package pe.proyecto.zonamangas.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.proyecto.zonamangas.modelo.Manga;
import pe.proyecto.zonamangas.repositorio.MangaRepositorio;


@Service
public class MangaServicio {
	
	@Autowired
	private MangaRepositorio mangaRepositorio;
	
	public List<Manga> listAll(String nombre){
		if(nombre != null) {
			return mangaRepositorio.findAll(nombre);
		}
		return mangaRepositorio.findAll();
	}

	
	public void save(Manga manga) {
		mangaRepositorio.save(manga);
	}
	
	public Manga get(long id) {
		return mangaRepositorio.findById(id).get();
	}
	
	public void delete(Long id) {
		mangaRepositorio.deleteById(id);
	}

	
}

