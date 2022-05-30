package ar.edu.unju.fi.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.models.Candidato;
import ar.edu.unju.fi.service.ICandidatoService;
import ar.edu.unju.fi.util.ListaCandidatos;
@Service("CandidatoServiceImpList")
public class CandidatoServiceImp implements ICandidatoService {
	@Autowired
	private ListaCandidatos listaCandidatos;
	
	@Override
	public Candidato getCandidato() {
		// TODO retorna un objeto de la clase Candidato
		return new Candidato();
	}

	@Override
	public boolean guardarCandidato(Candidato candidato) {
		// TODO gaurda un objeto candidato en la lista de candidatos
		boolean respuesta = listaCandidatos.getCandidatos().add(candidato);
		return respuesta;
	}

	@Override
	public void modificarCandidato(Candidato candidato) {
		// TODO buscar el candidato con ese dni y actualizar sus atributos
		for(Candidato cand: listaCandidatos.getCandidatos()) {
			if(cand.getCodigo()==candidato.getCodigo()){
				cand.setNombre(candidato.getNombre());
				cand.setGenero(candidato.getGenero());
				cand.setDescripcion(candidato.getDescripcion());
			}
			
		}

	}

	@Override
	public void eliminarCandidato(int codigo) {
		// TODO Auto-generated method stub
		Optional <Candidato> candidato = listaCandidatos.getCandidatos().stream().filter(a -> a.getCodigo() == codigo).findFirst();
		listaCandidatos.getCandidatos().remove(candidato.get());

	}

	@Override
	public ListaCandidatos getListaCandidato() {
		// TODO retorna el objeto que accede a la lista de candidatos
		return listaCandidatos;
	}

	@Override
	public Candidato buscarCandidato(int codigo) {
		// TODO busca un alumno por dni y devuelve el objeto asociado al dni
		Optional<Candidato>candidato = listaCandidatos.getCandidatos().stream().filter(a -> a.getCodigo() == codigo).findFirst();
		return candidato.get();
	}

}
