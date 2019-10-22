package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.unity.Jogador;
import br.com.codenation.unity.Time;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	private List<Time> listaTimes = new ArrayList<>();
	private List<Jogador> listaJogadores = new ArrayList<>();

	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {

		if(listaTimes.stream().filter(time -> time.getId().equals(id)).findFirst().isPresent()){
			throw new UnsupportedOperationException("br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException");
		}
		else {
			Time novoTime = new Time(id,
									nome,
									dataCriacao,
									corUniformePrincipal,
									corUniformeSecundario);

			listaTimes.add(novoTime);
		}

	}

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {

		if(listaJogadores.stream().filter(jogador -> jogador.getId().equals(id)).findFirst().isPresent()){
			throw new UnsupportedOperationException("br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException");
		}

		if(listaTimes.stream().filter(time -> time.getId().equals(id)).findFirst().isPresent()){

			Jogador novoJogador = new Jogador(id,
											idTime,
											nome,
											dataNascimento,
											nivelHabilidade,
											salario);

			listaJogadores.add(novoJogador);
		}
		else{
			throw new UnsupportedOperationException("br.com.codenation.desafio.exceptions.TimeNaoEncontradoException");
		}

	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {

		Jogador capitao = buscaJogador(idJogador);

		if(capitao != null){
			listaTimes.forEach(item->{
				if(capitao.getIdTime() == (item.getId())){
					item.setIdJogador(idJogador);
				}
			});
		}
        else {
        	throw new UnsupportedOperationException("br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException");
		}
	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {

		Time time = buscaTime(idTime);

		if(time == null){
			throw new UnsupportedOperationException("br.com.codenation.desafio.exceptions.TimeNaoEncontradoException");
		}
		else if(time.getIdJogador() == null){
			throw new UnsupportedOperationException("br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException");
		}
		else{
			return time.getIdJogador();
		}

	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {

		Jogador busca = buscaJogador(idJogador);

		if(busca != null){
			return busca.getNome();
		}
		else {
			throw new UnsupportedOperationException("br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException");
		}
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {

		Time time = buscaTime(idTime);;

		if(time == null){
			throw new UnsupportedOperationException("br.com.codenation.desafio.exceptions.TimeNaoEncontradoException");
		}
		else{
			return time.getNome();
		}
	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {

		if(buscaTime(idTime) == null){
			throw new UnsupportedOperationException("br.com.codenation.desafio.exceptions.TimeNaoEncontradoException");
		}

		List<Long> jogadoresDoTime = new ArrayList<>();

		listaJogadores.forEach(item->{
			if(idTime == (item.getIdTime())){
				jogadoresDoTime.add(item.getId());
			}
		});

		Collections.sort(jogadoresDoTime);

		return jogadoresDoTime;

	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {

		Time time = buscaTime(idTime);

		if(time == null){
			throw new UnsupportedOperationException("br.com.codenation.desafio.exceptions.TimeNaoEncontradoException");
		}

		Jogador jogador =  getListaJogadores(idTime)
				.stream()
				.max(Comparator.comparing(Jogador::getNivelHabilidade))
				.orElse(null);

		return jogador.getId();

	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {

		Time time = buscaTime(idTime);

		if(time == null){
			throw new UnsupportedOperationException("br.com.codenation.desafio.exceptions.TimeNaoEncontradoException");
		}

		Jogador jogador =  getListaJogadores(idTime)
				.stream()
				.max(Comparator.comparing(Jogador::getDataNascimento))
				.orElse(null);

		return jogador.getId();
	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {

		List<Long> times = new ArrayList<>();

		listaTimes.forEach(item->{
			times.add(item.getId());
		});

		Collections.sort(times);

		return times;
	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {
		Time time = buscaTime(idTime);

		if(time == null){
			throw new UnsupportedOperationException("br.com.codenation.desafio.exceptions.TimeNaoEncontradoException");
		}

		Jogador jogador =  getListaJogadores(idTime)
				.stream()
				.max(Comparator.comparing(Jogador::getSalario))
				.orElse(null);

		return jogador.getId();
	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {

		Jogador busca = buscaJogador(idJogador);

		if(busca != null){
			return busca.getSalario();
		}
		else{
			throw new UnsupportedOperationException("br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException");
		}
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {

		List<Long> jogadores = new ArrayList<>();
		List<Jogador> todosJogadores = new ArrayList<>();

		todosJogadores.addAll(listaJogadores);

		if(!todosJogadores.isEmpty()){
			todosJogadores.sort((Jogador j1, Jogador j2) -> !j1.getNivelHabilidade().equals(j2.getNivelHabilidade()) ?
					Integer.compare(j2.getNivelHabilidade(), j1.getNivelHabilidade()) :
					Long.compare(j1.getId(), j2.getId()));

			if(top > todosJogadores.size())
				top = todosJogadores.size();
			List<Jogador> topJogadores = todosJogadores.subList(0, top);
			topJogadores.forEach(jogador -> jogadores.add(jogador.getId()));
		}

		return jogadores;

	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {

		Time timeCasa = buscaTime(timeDaCasa);
		Time timeFora = buscaTime(timeDeFora);

		if(timeCasa.getCorUniformePrincipal().equals(timeFora.getCorUniformePrincipal())){
			return timeFora.getCorUniformeSecundario();
		}

		return timeFora.getCorUniformePrincipal();

	}

	public Jogador buscaJogador(Long idJogador){
		return 	listaJogadores.stream().filter(jogador -> jogador.getId().equals(idJogador)).findFirst().orElse(null);
	}

	public Time buscaTime(Long idTime){
		return listaTimes.stream().filter(jogador -> jogador.getId().equals(idTime)).findFirst().orElse(null);
	}

	public List<Jogador> getListaJogadores(Long idTime) {

		List<Jogador> listaJogadores = new ArrayList<>();

		listaJogadores.forEach(item->{
			if(idTime == (item.getIdTime())){
				listaJogadores.add(item);
			}
		});

		return listaJogadores;
	}
}
