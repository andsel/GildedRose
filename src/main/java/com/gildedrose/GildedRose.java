package com.gildedrose;

class GildedRose {
    Item[] items;


     static class QualityHandlerFactory {
        static final QualityHandler DEFAULT_QUALITY_HANDLER = new DefaultQualityHandler();

        static QualityHandler buildFromItem
                (Item item) {
            switch (item.name) {
//                case "Sulfuras":
//                    return null;
                default:
                    return DEFAULT_QUALITY_HANDLER;
            }
        }
    }


    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            decrementDays(item);
            if (item.name.equals("Sulfuras")) {
                item.quality = 80;
                break;
            }
            QualityHandler handler = QualityHandlerFactory.buildFromItem(item);

            if (item.name.equals("Backstage passes")) {
                if (item.sellIn < 10) {
                    item.quality = item.quality + 1;
                }

                if (item.sellIn < 5) {
                    item.quality = item.quality + 1;
                }
            }

            if (isOlderGetBetter(item)) {
                item.quality = item.quality + 1;
            } else {
                handler.handleQuality(item);
            }

            if (item.sellIn < 0) {
                if (item.name.equals("Backstage passes")) {
                    item.quality = -1;
                }

                if (isOlderGetBetter(item)) {
                    item.quality = item.quality + 1;
                } else {
                    handler.handleQuality(item);
                }
            }

            if (item.quality > 50) {
                item.quality = 50;
            }
        }
    }

    private boolean isOlderGetBetter(Item item) {
        return item.name.equals("Aged Brie") || item.name.equals("Backstage passes");
    }

    private void decrementDays(Item item) {
        if (item.name.equals("Sulfuras")) {
            return;
        }
        item.sellIn = item.sellIn - 1;
    }
}
