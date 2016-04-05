package com.gildedrose;

class ConjuredQualityHandler extends DefaultQualityHandler {

    @Override
    public void handleQuality(Item item) {
        item.quality = item.quality - 2;
        limitMinMaxQuality(item);
    }

    @Override
    public void handleQualityOnceSellInExpires(Item item) {
        item.quality = item.quality - 4;
        limitMinMaxQuality(item);
    }
}
