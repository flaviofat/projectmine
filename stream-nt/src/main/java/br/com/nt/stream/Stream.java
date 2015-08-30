package br.com.nt.stream;

import br.com.nt.stream.exception.NotFoundRepeatedException;

public interface Stream {

	public char getNext();

	public boolean hasNext();
	
	public char findFirstRepeatedChar() throws NotFoundRepeatedException;
}
