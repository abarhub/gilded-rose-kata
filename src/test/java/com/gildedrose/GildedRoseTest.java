package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

	@Test
	public void testFoo() {
		Item[] items = new Item[] { new Item("foo", 0, 0) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("foo", app.items[0].name);
	}

	@Test
	public void testSimple() {
		Item[] items = new Item[] { new Item("pomme", 10, 20) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("pomme", app.items[0].name);
		assertEquals(9, app.items[0].sellIn);
		assertEquals(19, app.items[0].quality);
	}

}