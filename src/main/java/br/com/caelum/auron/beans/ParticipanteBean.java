package br.com.caelum.auron.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.auron.dao.ParticipanteDao;
import br.com.caelum.auron.modelo.Participante;

@Named
@RequestScoped
public class ParticipanteBean {
	
	@Inject
	private Participante participante;
	
	@Inject	
	private ParticipanteDao participanteDao;
	
	public void cadastrar() {
		participanteDao.inserir(participante);
	}
	
	public List<Participante> getParticipantes() {
		return participanteDao.getParticipantes();
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

}
