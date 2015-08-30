package br.com.nt.app;

import br.com.nt.stream.exception.NotFoundRepeatedException;
import br.com.nt.stream.impl.StreamImpl;

public class App {

	public static void main(String[] args) {
		StreamImpl imp = new StreamImpl("aAbBABac");
		try {
			System.out.println("No exemplo " + "'"+imp.findFirstRepeatedChar()+ "'" +
					" e o primeiro caracter da stream que nao se repete");
		} catch (NotFoundRepeatedException e) {
			System.out.println(e.getMessage());
		}
	}
}
