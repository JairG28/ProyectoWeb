package pe.proyecto.zonamangas.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import pe.proyecto.zonamangas.controlador.dto.UsuarioRegistroDTO;
import pe.proyecto.zonamangas.modelo.Usuario;


public interface UsuarioServicio extends UserDetailsService{

	public Usuario guardar(UsuarioRegistroDTO registroDTO);
	
	public List<Usuario> listarUsuarios();
	
}
