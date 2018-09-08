package com.gildedrose;

import com.gildedrose.item.*;

public class Factory {

	private static final String ITEM_AGED_BRIE = "Aged Brie";
	private static final String ITEM_BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
	private static final String ITEM_SULFURAS = "Sulfuras, Hand of Ragnaros";

	public SpecializedItem convertItem(Item item) {
		if (item == null) {
			throw new NullPointerException("Item est null");
		}
		if (item.name.equals(ITEM_SULFURAS)) {
			return new SulfurasItem(item);
		} else if (item.name.equals(ITEM_AGED_BRIE)) {
			return new AgedBrieItem(item);
		} else if (item.name.equals(ITEM_BACKSTAGE_PASSES)) {
			return new BackstagePassesItem(item);
		} else {
			return new CustomItem(item);
		}
	}
}
