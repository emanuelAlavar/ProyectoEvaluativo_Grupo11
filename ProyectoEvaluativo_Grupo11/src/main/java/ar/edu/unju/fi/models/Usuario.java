package ar.edu.unju.fi.models;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Component;

@Component
public class Usuario {
	String nombre;
	String email;
	LocalDate fechaDeNacimiento;
	int maxVotos = 3;
	
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
		Period periodo = Period.between(fechaDeNacimiento, fechaActual);
		return periodo.getYears();
	}
	
	
}
