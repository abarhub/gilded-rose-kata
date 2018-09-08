package com.gildedrose;

import com.gildedrose.item.SpecializedItem;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

class GildedRose {

	private List<SpecializedItem> items;

	public GildedRose(Item[] items) {
		if (items == null) {
			throw new NullPointerException("Item est null");
		}
		this.items = new ArrayList<>();
		Factory factory = new Factory();
		for (Item item : items) {
			this.items.add(factory.convertItem(item));
		}
	}

	public void updateQuality() {
		for (SpecializedItem item : items) {
			item.updateQuality();
		}
	}

	public List<Item> getItems() {
		List<Item> liste = new ArrayList<>();
		for (SpecializedItem item : items) {
			liste.add(item.getItem());
		}
		return ImmutableList.copyOf(liste);
	}
}