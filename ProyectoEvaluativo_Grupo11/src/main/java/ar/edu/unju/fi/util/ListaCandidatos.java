package ar.edu.unju.fi.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.models.Candidato;
@Component
public class ListaCandidatos {
	private ArrayList<Candidato> candidatos;
	
	
	public ListaCandidatos(){
		candidatos = new ArrayList<Candidato>();
		
		candidatos.add(new Candidato(10,"Pablo Lescano","Masculino","Es un cantante y músico argentino, líder del grupo Damas Gratis"));
		candidatos.add(new Candidato(9,"Maluma","Masculino","Es un actor y cantante colombiano de pop, reguetón y trap latino"));
		candidatos.add(new Candidato(8,"Tini","Femenino","Es una actriz, cantante y compositora argentina"));
		candidatos.add(new Candidato(0,"Ninguno","-","Selecciona esta opción si decides no votar por ninguno de los candidatos propuestos"));
	}

	public ArrayList<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(ArrayList<Candidato> candidatos) {
		this.candidatos = candidatos;
	}
	
}
