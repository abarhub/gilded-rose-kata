package com.gildedrose;

class GildedRose {
	private static final String ITEM_AGED_BRIE = "Aged Brie";
	private static final String ITEM_BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
	private static final String ITEM_SULFURAS = "Sulfuras, Hand of Ragnaros";
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {
			updateQuality(items[i]);
		}
	}

	private void updateQuality(Item item) {
		if (equals(item, ITEM_SULFURAS)) {
			//on ne fait rien
		} else {
			if (!equals(item, ITEM_AGED_BRIE)
					&& !equals(item, ITEM_BACKSTAGE_PASSES)) {
				if (item.quality > 0) {
					decrementQuality(item);
				}
			} else {
				if (item.quality < 50) {
					incrementQuality(item);

					if (equals(item, ITEM_BACKSTAGE_PASSES)) {
						if (item.sellIn < 11) {
							incrementQualityIfPossible(item);
						}

						if (item.sellIn < 6) {
							incrementQualityIfPossible(item);
						}
					}
				}
			}

			decrementSellIn(item);

			if (item.sellIn < 0) {
				if (!equals(item, ITEM_AGED_BRIE)) {
					if (!equals(item, ITEM_BACKSTAGE_PASSES)) {
						if (item.quality > 0) {
							decrementQuality(item);
						}
					} else {
						item.quality = 0;
					}
				} else {
					incrementQualityIfPossible(item);
				}
			}
		}
	}

	private void incrementQualityIfPossible(Item item) {
		if (item.quality < 50) {
			incrementQuality(item);
		}
	}

	private boolean equals(Item item, String itemBackstagePasses) {
		return item.name.equals(itemBackstagePasses);
	}

	private void decrementSellIn(Item item) {
		item.sellIn = item.sellIn - 1;
	}

	private void decrementQuality(Item item) {
		item.quality = item.quality - 1;
	}

	private void incrementQuality(Item item) {
		item.quality = item.quality + 1;
	}
}