package com.gildedrose.item;

import com.gildedrose.Item;

public class CustomItem extends SpecializedItem {

	public CustomItem(Item item) {
		super(item);
	}

	@Override
	public void updateQuality() {
		decrementQualityIfPossible(item);

		decrementSellIn(item);

		if (item.sellIn < 0) {
			decrementQualityIfPossible(item);
		}
	}
}
