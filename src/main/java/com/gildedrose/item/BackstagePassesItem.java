package com.gildedrose.item;

import com.gildedrose.Item;

public class BackstagePassesItem extends SpecializedItem {

	public BackstagePassesItem(Item item) {
		super(item);
	}

	@Override
	public void updateQuality() {

		incrementQualityIfPossible(item);

		if (item.sellIn < 11) {
			incrementQualityIfPossible(item);
		}

		if (item.sellIn < 6) {
			incrementQualityIfPossible(item);
		}

		decrementSellIn(item);

		if (item.sellIn < 0) {
			item.quality = 0;
		}
	}
}
