package com.gildedrose.item;

import com.gildedrose.Item;

public abstract class SpecializedItem {

	protected final Item item;

	public SpecializedItem(Item item) {
		this.item = item;
	}

	public Item getItem() {
		return item;
	}

	public abstract void updateQuality();

	protected void decrementQualityIfPossible(Item item) {
		if (item.quality > 0) {
			decrementQuality(item);
		}
	}

	protected void incrementQualityIfPossible(Item item) {
		if (item.quality < 50) {
			incrementQuality(item);
		}
	}

	protected void decrementSellIn(Item item) {
		item.sellIn = item.sellIn - 1;
	}

	protected void decrementQuality(Item item) {
		item.quality = item.quality - 1;
	}

	protected void incrementQuality(Item item) {
		item.quality = item.quality + 1;
	}

}
