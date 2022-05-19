package br.com.caelum.auron.modelo;

import java.util.List;

public class Sorteador {

	private Sorteio sorteio;
	private List<Participante> participantes;

	public Sorteador(Sorteio sorteio, List<Participante> participantes) throws SorteioException {
		if (participantes == null) {
			throw new SorteioException("Por favor insira uma lista de participantes!");
		}
		
		this.sorteio = sorteio;
		this.participantes = participantes;
	}

	public void sortear() throws SorteioException {

		Integer indiceAtual = 0;
		Integer totalDeParticipantes = participantes.size();
		
		if(totalDeParticipantes < 2) {
			throw new SorteioException("Por favor insira uma lista de participantes com no mínimo "
					+ "dois participantes");
		}

		while (indiceAtual < totalDeParticipantes) {
			if (indiceAtual == totalDeParticipantes - 1) {
				Par par = new Par(participantes.get(indiceAtual), participantes.get(0), sorteio);
				sorteio.adicionaPar(par);
				break;
			}
			Par par = new Par(participantes.get(indiceAtual), participantes.get(indiceAtual + 1), sorteio);
			sorteio.adicionaPar(par);
			
			indiceAtual++;
		}

	}

}
