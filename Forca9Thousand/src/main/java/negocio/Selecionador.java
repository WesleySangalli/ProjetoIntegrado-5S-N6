package negocio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import dao.PalavrasDAO;

public class Selecionador{
	
	public static final int FACIL = 1;
	public static final int MEDIO = 2;
	public static final int DIFICIL = 3;

	private final int nivelSelecionado;

	public Selecionador(int level){
		this.nivelSelecionado = level;
	}

	public String seleciona(){

		switch(nivelSelecionado){
			case FACIL:
				return selecionaDoArquivo(FACIL);				
			case MEDIO:
				return selecionaDoArquivo(MEDIO);				
			case DIFICIL:
				return selecionaDoArquivo(DIFICIL);
			default:
				System.err.println("Nivel selecionado não existe");
				return null;
		}
	}

	private String selecionaDoArquivo(int dificuldade){
		try{
			
			PalavrasDAO dao = new PalavrasDAO();
			List<String> palavras = dao.selectPalavra(dificuldade);
			
			Random random = new Random();
			int linha = random.nextInt(palavras.size());
			String palavra = palavras.get(linha);

			return palavra;
		}catch(SQLException e){
			//TODO - tratar especifico;
			e.printStackTrace();
			throw new RuntimeException("Falha ao selecionar palavra"); // TODO - Meio agressivo, acertar depois
		}
	}

	private int verificaLinhasDisponiveis(String caminho) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(caminho));
		int lines = 0;
		while (reader.readLine() != null) lines++;
		reader.close();
		reader = null;
		return lines;
	}
}
