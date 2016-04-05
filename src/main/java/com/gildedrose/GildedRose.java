package com.gildedrose;

class GildedRose {
    Item[] items;


    static class QualityHandlerFactory {
        static final QualityHandler DEFAULT_QUALITY_HANDLER = new DefaultQualityHandler();
        static final QualityHandler AGED_BRIE_QUALITY_HANDLER = new AgedBrieQualityHandler();
        static final QualityHandler BACKSTAGE_PASSES_QUALITY_HANDLER = new BackStagePassesQualityHandler();
        static final QualityHandler SULFURAS_QUALITY_HANDLER = new SulfurasQualityHandler();

        static QualityHandler buildFromItem(Item item) {
            switch (item.name) {
                case "Aged Brie":
                    return AGED_BRIE_QUALITY_HANDLER;
                case "Backstage passes":
                    return BACKSTAGE_PASSES_QUALITY_HANDLER;
                case "Sulfuras":
                    return SULFURAS_QUALITY_HANDLER;
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
            QualityHandler handler = QualityHandlerFactory.buildFromItem(item);

            if (item.sellIn < 0) {
                handler.handleQualityOnceSellInExpires(item);
            } else {
                handler.handleQuality(item);
            }
        }
    }

    private void decrementDays(Item item) {
        if (item.name.equals("Sulfuras")) {
            return;
        }
        item.sellIn = item.sellIn - 1;
    }
}
