package com.gildedrose.item;

import com.gildedrose.Item;

public class AgedBrieItem extends SpecializedItem {

	public AgedBrieItem(Item item) {
		super(item);
	}

	@Override
	public void updateQuality() {
		incrementQualityIfPossible(item);

		decrementSellIn(item);

		if (item.sellIn < 0) {
			incrementQualityIfPossible(item);
		}
	}
}
