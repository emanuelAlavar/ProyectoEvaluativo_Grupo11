package ar.edu.unju.fi.util;

import java.util.ArrayList;
import ar.edu.unju.fi.models.Usuario;

public class ListaUsuarios {
	private ArrayList<Usuario> usuarios;
	
	public ListaUsuarios(){
		usuarios = new ArrayList<Usuario>();
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setCandidatos(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
}