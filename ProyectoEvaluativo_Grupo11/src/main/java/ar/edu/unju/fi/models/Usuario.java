package ar.edu.unju.fi.models;

import java.time.LocalDate;
import java.time.Period;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class Usuario {
	@NotBlank
	@Size(min=3, max=100)
	private String nombre;
	@NotBlank
	private String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaDeNacimiento;
	@Max(value=3)
	@Min(value=0)
	private int maxVotos = 3;
	
	
	public Usuario(String nombre, String email, LocalDate fechaDeNacimiento) {
		this.nombre = nombre;
		this.email = email;
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public Usuario() {
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public int getMaxVotos() {
		return maxVotos;
	}
	public void setMaxVotos(int maxVotos) {
		this.maxVotos = maxVotos;
	}
	public int getEdad() {
		LocalDate fechaActual = LocalDate.now();
		Period periodo = Period.between(this.getFechaDeNacimiento(), fechaActual);
		return periodo.getYears();
	}
	
	
}
