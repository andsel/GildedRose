package com.gildedrose;

class BackStagePassesQualityHandler extends DefaultQualityHandler {

    @Override
    public void handleQuality(Item item) {
        item.quality = item.quality + 1;

        if (item.sellIn < 10) {
            item.quality = item.quality + 1;
        }

        if (item.sellIn < 5) {
            item.quality = item.quality + 1;
        }
        limitMaxQuality(item);
    }

    @Override
    public void handleQualityOnceSellInExpires(Item item) {
        item.quality = 0;
    }
}