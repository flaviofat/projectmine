package br.com.nt.stream.impl;

import br.com.nt.stream.Stream;

public class StreamImpl implements Stream {

	private String input;
	private int indexChar = 1;

	public StreamImpl(String input) {
		this.input = (input == null ? "" : input);
	}

	public char getNext() {
		return input.charAt(indexChar++);
	}

	public boolean hasNext() {
		return indexChar < input.length();
	}

	public char findFirstRepeatedChar() {
		
		int index = 0;
		char current;
		char nextChar;
		char foundRepeated = 0;
		char found = 0;

		while (hasNext()) {
			current = input.charAt(index);
			nextChar = getNext();
			
			if (foundRepeated != 0 && Character.toUpperCase(foundRepeated) != Character.toUpperCase(nextChar)){
				found = nextChar;
				break;
			}
			
			if (Character.toUpperCase(current) == Character.toUpperCase(nextChar)){
				foundRepeated = current;
			}

			index++;
		}
		
		return found;
	}
}	
