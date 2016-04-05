package com.gildedrose;

class GildedRose {
    Item[] items;


     static class QualityHandlerFactory {
         static final QualityHandler DEFAULT_QUALITY_HANDLER = new DefaultQualityHandler();
         static final QualityHandler AGED_BRIE_QUALITY_HANDLER = new AgedBrieQualityHandler();
         static final QualityHandler BACKSTAGE_PASSES_QUALITY_HANDLER = new BackStagePassesQualityHandler();


         static QualityHandler buildFromItem(Item item) {
            switch (item.name) {
                case "Aged Brie":
                    return AGED_BRIE_QUALITY_HANDLER;
                case "Backstage passes":
                    return BACKSTAGE_PASSES_QUALITY_HANDLER;
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

            handler.handleQuality(item);

            if (item.sellIn < 0) {
                if (item.name.equals("Backstage passes")) {
                    item.quality = -1;
                }

                if (isBackstage(item)) {
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

    private boolean isBackstage(Item item) {
        return item.name.equals("Backstage passes");
    }

    private void decrementDays(Item item) {
        if (item.name.equals("Sulfuras")) {
            return;
        }
        item.sellIn = item.sellIn - 1;
    }
}
