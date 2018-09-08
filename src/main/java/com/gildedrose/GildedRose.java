package com.gildedrose;

import com.gildedrose.item.SpecializedItem;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

class GildedRose {
	private static final String ITEM_AGED_BRIE = "Aged Brie";
	private static final String ITEM_BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
	private static final String ITEM_SULFURAS = "Sulfuras, Hand of Ragnaros";

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

//	private void updateQuality(SpecializedItem item) {
//		if (equals(item, ITEM_SULFURAS)) {
//			//on ne fait rien
//		} else {
//			if (equals(item, ITEM_AGED_BRIE)) {
//				incrementQualityIfPossible(item);
//			} else if (equals(item, ITEM_BACKSTAGE_PASSES)) {
//				incrementQualityIfPossible(item);
//
//				if (item.sellIn < 11) {
//					incrementQualityIfPossible(item);
//				}
//
//				if (item.sellIn < 6) {
//					incrementQualityIfPossible(item);
//				}
//			} else {
//				decrementQualityIfPossible(item);
//			}
//
//			decrementSellIn(item);
//
//			if (item.sellIn < 0) {
//				if (equals(item, ITEM_AGED_BRIE)) {
//					incrementQualityIfPossible(item);
//				} else if (equals(item, ITEM_BACKSTAGE_PASSES)) {
//					item.quality = 0;
//				} else {
//					decrementQualityIfPossible(item);
//				}
//			}
//		}
//	}
//
//	private void decrementQualityIfPossible(Item item) {
//		if (item.quality > 0) {
//			decrementQuality(item);
//		}
//	}
//
//	private void incrementQualityIfPossible(Item item) {
//		if (item.quality < 50) {
//			incrementQuality(item);
//		}
//	}
//
//	private boolean equals(Item item, String itemBackstagePasses) {
//		return item.name.equals(itemBackstagePasses);
//	}
//
//	private void decrementSellIn(Item item) {
//		item.sellIn = item.sellIn - 1;
//	}
//
//	private void decrementQuality(Item item) {
//		item.quality = item.quality - 1;
//	}
//
//	private void incrementQuality(Item item) {
//		item.quality = item.quality + 1;
//	}

	public List<Item> getItems() {
		List<Item> liste = new ArrayList<>();
		for (SpecializedItem item : items) {
			liste.add(item.getItem());
		}
		return ImmutableList.copyOf(liste);
	}
}