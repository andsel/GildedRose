package com.gildedrose;

class AgedBrieQualityHandler extends DefaultQualityHandler {

    @Override
    public void handleQuality(Item item) {
        item.quality = item.quality + 1;
        limitMinMaxQuality(item);
    }

    @Override
    public void handleQualityOnceSellInExpires(Item item) {
        item.quality = item.quality + 2;
        limitMinMaxQuality(item);
    }
}
