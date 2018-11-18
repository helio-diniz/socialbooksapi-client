package com.algaworks.socialbooks.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.algaworks.socialbooks.client.LivrosClient;
import com.algaworks.socialbooks.client.domain.Livro;

public class Aplicacao {
	public static void main(String[] args) throws ParseException {
		LivrosClient cliente = new LivrosClient("http://localhost:8080", "algaworks", "s3nh4");

		Livro livro = new Livro();
		livro.setNome("API Restful Avançadas");
		livro.setEditora("Algaworks");
		SimpleDateFormat publicacao = new SimpleDateFormat("dd/MM/yyyy");
		livro.setPublicacao(publicacao.parse("01/01/2016"));
		livro.setResumo("Este livro aborda técnicas de desenvolvimento de API");

		String localizacao = cliente.salvar(livro);

		System.out.println("URI do livro salvo: " + localizacao);

		List<Livro> listaLivros = cliente.listar();
		for (Livro livroListado : listaLivros) {
			System.out.println("Livro: " + livroListado.getNome());
		}
		
		Livro livroBuscado = cliente.buscar(localizacao);
		System.out.println("Livro buscado: "+ livroBuscado.getNome() );

	}
}
