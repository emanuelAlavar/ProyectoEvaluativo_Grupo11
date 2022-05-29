package ar.edu.unju.fi.util;

import java.util.ArrayList;

import ar.edu.unju.fi.models.Candidato;

public class ListaCandidatos {
	private ArrayList<Candidato> candidatos;
	
	public ListaCandidatos(){
		candidatos = new ArrayList<Candidato>();
	}

	public ArrayList<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(ArrayList<Candidato> candidatos) {
		this.candidatos = candidatos;
	}
	
}
