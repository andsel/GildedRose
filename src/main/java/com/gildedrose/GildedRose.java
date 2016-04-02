package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            decrementDays(item);
            if (!item.name.equals("Aged Brie")
                    && !item.name.equals("Backstage passes")) {
                if (item.quality > 0) {
                    if (!item.name.equals("Sulfuras")) {
                        item.quality = item.quality - 1;
                    } else {
                        item.quality = 80;
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals("Backstage passes")) {
                        if (item.sellIn < 10) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 5) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes")) {
                        if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras")) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = item.quality - item.quality;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }

            if (item.quality > 50 && !item.name.equals("Sulfuras")) {
                item.quality = 50;
            }
        }
    }

    private void decrementDays(Item item) {
        if (!item.name.equals("Sulfuras")) {
            item.sellIn = item.sellIn - 1;
        }
    }
}
