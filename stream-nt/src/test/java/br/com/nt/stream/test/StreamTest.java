package br.com.nt.stream.test;

import junit.framework.Assert;

import org.junit.Test;

import br.com.nt.stream.Stream;
import br.com.nt.stream.exception.NotFoundRepeatedException;
import br.com.nt.stream.impl.StreamImpl;

public class StreamTest {

	private Stream stream;

	@Test
	public void returnFirstLetterBnotRepeated() throws NotFoundRepeatedException {
		stream = new StreamImpl("aAbBABac");

		Assert.assertEquals('b', stream.findFirstRepeatedChar());
	}

	@Test
	public void returnFirstLetterWnotRepeated() throws NotFoundRepeatedException {
		stream = new StreamImpl("abCdEEW");

		Assert.assertEquals('W', stream.findFirstRepeatedChar());
	}

	@Test
	public void returnFirstLetterGnotRepeated() throws NotFoundRepeatedException {
		stream = new StreamImpl("zwYttg");

		Assert.assertEquals('g', stream.findFirstRepeatedChar());
	}

	@Test(expected = NotFoundRepeatedException.class)
	public void returnZero() throws NotFoundRepeatedException {
		stream = new StreamImpl("AbCdEfGh");

		Assert.assertEquals(0, stream.findFirstRepeatedChar());
	}
}
