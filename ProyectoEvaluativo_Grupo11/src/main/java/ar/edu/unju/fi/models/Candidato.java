package ar.edu.unju.fi.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;


@Component
public class Candidato {
	@Min(value=0)
	private int codigo;
	@NotBlank
	private String nombre;
	@NotBlank
	private String genero;
	@NotBlank
	private String descripcion;
	@Min(value=0)
	private int votos = 0;
	//private static final Log LOGGER = LogFactory.getLog(Candidato.class);
	
	public Candidato(int codigo, String nombre, String genero, String descripcion) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.genero = genero;
		this.descripcion = descripcion;
	}
	public Candidato() {
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getVotos() {
		return votos;
	}
	public void setVotos(int votos) {
		this.votos = votos;
	}
	public void updateVotos() {
		this.votos += 1;
	}
	
	
}
