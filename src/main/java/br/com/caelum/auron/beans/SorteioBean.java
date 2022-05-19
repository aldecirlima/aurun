package br.com.caelum.auron.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.auron.modelo.Participante;
import br.com.caelum.auron.modelo.Sorteador;
import br.com.caelum.auron.modelo.Sorteio;
import br.com.caelum.auron.modelo.SorteioException;

@Named
@RequestScoped
public class SorteioBean {

	@Inject
	private Sorteio sorteio;

	public void sortear() {
		List<Participante> participantes = new ArrayList<>();
		
		try {
			Sorteador sorteador = new Sorteador(sorteio, participantes);
			sorteador.sortear();
		} catch (SorteioException e) {
			e.printStackTrace();
		}
	}

	public Sorteio getSorteio() {
		return sorteio;
	}

}
