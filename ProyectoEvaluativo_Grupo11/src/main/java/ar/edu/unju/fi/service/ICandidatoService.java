package ar.edu.unju.fi.service;

import ar.edu.unju.fi.models.Candidato;
import ar.edu.unju.fi.util.ListaCandidatos;

public interface ICandidatoService {
	
	public Candidato getCandidato();
	public boolean guardarCandidato(Candidato candidato);
	public void modificarCandidato(Candidato candidato);
	public void eliminarCandidato(int codigo);
	public ListaCandidatos getListaCandidato();
	public Candidato buscarCandidato(int candidato);
}
