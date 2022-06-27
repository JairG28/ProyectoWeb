package pe.proyecto.zonamangas.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.proyecto.zonamangas.modelo.Manga;


public interface MangaRepositorio extends JpaRepository<Manga, Long> {

	@Query("select m from Manga m where m.nombre like %?1%")
	public List<Manga> findAll(String nombre);
	
}