package com.gildedrose;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

public class TestFunctional {

	@Test
	public void test1jour() throws IOException {
		compareResultat("1", "resultat1jour.txt");
	}

	@Test
	public void test2jours() throws IOException {
		compareResultat("2", "resultat2jours.txt");
	}

	@Test
	public void test50jours() throws IOException {
		compareResultat("50", "resultat50jours.txt");
	}

	private void compareResultat(String s2, String filename) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		TexttestFixture.tools(new String[]{s2}, new PrintStream(out));

		String res = new String(out.toByteArray(), StandardCharsets.UTF_8);

		byte[] buf = IOUtils.toByteArray(TestFunctional.class.getClassLoader().getResourceAsStream(filename));
		String s = new String(buf, StandardCharsets.UTF_8);
		assertEquals(s, res);
	}

}
