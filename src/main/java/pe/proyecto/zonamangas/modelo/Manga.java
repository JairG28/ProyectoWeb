package pe.proyecto.zonamangas.modelo;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "manga")
public class Manga {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length = 60)
	private String nombre;
	@Column(nullable = false, length = 1000)
	private String sinopsis;
	@Column(nullable = false)
	private Date lanzamiento;
	@Column(nullable = true)
	private String portada;
	@Column(nullable = true)
	private String editorial;
	@Column(nullable = false)
	private int episodios;
	public Manga(Long id, String nombre, String sinopsis, Date lanzamiento, String portada, String editorial,
			int episodios) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.sinopsis = sinopsis;
		this.lanzamiento = lanzamiento;
		this.portada = portada;
		this.editorial = editorial;
		this.episodios = episodios;
	}
	public Manga(String nombre, String sinopsis, Date lanzamiento, String portada, String editorial, int episodios) {
		super();
		this.nombre = nombre;
		this.sinopsis = sinopsis;
		this.lanzamiento = lanzamiento;
		this.portada = portada;
		this.editorial = editorial;
		this.episodios = episodios;
	}
	public Manga() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	public Date getLanzamiento() {
		return lanzamiento;
	}
	public void setLanzamiento(Date lanzamiento) {
		this.lanzamiento = lanzamiento;
	}
	public String getPortada() {
		return portada;
	}
	public void setPortada(String portada) {
		this.portada = portada;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public int getEpisodios() {
		return episodios;
	}
	public void setEpisodios(int episodios) {
		this.episodios = episodios;
	}
	

}
