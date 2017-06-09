package logica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Paths;

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
				return selecionaDoArquivo("palavras\\facil.txt");				
			case MEDIO:
				return selecionaDoArquivo("palavras\\medio.txt");				
			case DIFICIL:
				return selecionaDoArquivo("palavras\\dificil.txt");
			default:
				System.err.println("Nivel selecionado não existe");
				return null;
		}

	}

	private String selecionaDoArquivo(String caminho){
		try{
			
			Random random = new Random();
			int linha = random.nextInt(verificaLinhasDisponiveis(caminho));
			String palavra = Files.readAllLines(Paths.get(caminho)).get(linha);

			// TODO - checagem

			return palavra;
		}catch(IOException e){
			//TODO - tratar especifico;
			e.printStackTrace();
			throw new RuntimeException("Falaha ao selecionar palavra"); // TODO - Meio agressivo, acertar depois
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